package br.com.boletos.aplicacao;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.boletos.comando.NovoBoletoComando;
import br.com.boletos.consulta.BoletoData;
import br.com.boletos.dominio.boleto.IBoleto;
import br.com.boletos.dominio.boleto.IBoletoId;
import br.com.boletos.dominio.boleto.IBoletoRepositorio;
import br.com.boletos.dominio.boleto.IDatas;
import br.com.boletos.dominio.publico.Publico;
import br.com.boletos.dominio.publico.PublicoId;
import br.com.boletos.dominio.publico.PublicoRepositorio;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import net.sf.jasperreports.engine.JRException;

@Service
@Transactional
public class BoletoService {

	@Autowired
	private IBoletoRepositorio boletoRepositorio;
	
	@Autowired
	private PublicoRepositorio publicoRepositorio;

	public String criarBoleto(NovoBoletoComando comando) {

		IBoleto bol = new IBoleto(boletoRepositorio.novoId(), 
								  new PublicoId(comando.getBeneficiarioId()), 
								  new PublicoId(comando.getPagadorId()), 
								  comando.getValor(), 
								  /*comando.getQuantidadeMoeda(),
								  comando.getValorMoeda(), 
								  comando.getValorDescontos(),
								  comando.getValorDeducoes(),
								  comando.getValorMulta(),
								  comando.getValorAcrescimos(), 
								  comando.getEspecieMoeda(),
								  comando.getCodigoEspecieMoeda(), 
								  comando.getEspecieDocumento(), 
								  comando.getNumeroDocumento(),*/
								  new IDatas(comando.getEmissao(), 
										     comando.getProcessamento(), 
										     comando.getVencimento()),
									comando.getInstrucao1(), comando.getInstrucao2(), comando.getInstrucao3(), comando.getInstrucao4(),
									comando.getInstrucao5(), comando.getLocalPagamento1(), comando.getLocalPagamento2(), comando.getBanco());

		boletoRepositorio.salvar(bol);

		return bol.getBoletoId().id();

	}

	public IBoleto obterPeloId(IBoletoId boletoId) {
		
		IBoleto boleto = boletoRepositorio.buscarBoletoPorId(boletoId);
		if (boleto == null)
			throw new RuntimeException("Boleto não encontrado.");
		
		return boleto;
	}

	public List<BoletoData> listarTodos() {

		List<BoletoData> lista = new ArrayList<BoletoData>();
		
		List<IBoleto> boletos = boletoRepositorio.buscarTodos();

		for (IBoleto boleto : boletos)
			lista.add(construir(boleto));

		Collections.sort(lista, new Comparator<BoletoData>() {

			@Override
			public int compare(BoletoData boleto1, BoletoData boleto2) {
				return boleto2.getEmissao().compareTo(boleto1.getEmissao());
			}
			
		});
		
		return lista;

	}

	private BoletoData construir(IBoleto boleto) {
		return boleto == null ? null
			  : new BoletoData(boleto.getBoletoId().id(), 
					  			boleto.getBeneficiarioId().id(), 
					  			boleto.getPagadorId().id(), 
					  			/*boleto.getQuantidadeMoeda(), 
					  			boleto.getValorMoeda(), 
					  			boleto.getValorDescontos(), 
					  			boleto.getValorDeducoes(),
					  			boleto.getValorMulta(), 
					  			boleto.getValorAcrescimos(), 
					  			boleto.getEspecieMoeda(), 
					  			boleto.getCodigoEspecieMoeda(), 
					  			boleto.getEspecieDocumento(), */
					  			boleto.getDatas().getDocumento(), 
					  			boleto.getDatas().getProcessamento(), 
					  			boleto.getDatas().getVencimento(), 
					  			boleto.getValorBoleto(), 
					  			//boleto.getNumeroDocumento(), 
					  			boleto.getInstrucao1(), 
					  			boleto.getInstrucao2(), 
					  			boleto.getInstrucao3(), 
					  			boleto.getInstrucao4(), 
					  			boleto.getInstrucao5(), 
					  			boleto.getLocalPagamento1(), 
					  			boleto.getLocalPagamento2(), 
					  			boleto.getBanco());
	}

	public ResponseEntity<InputStreamResource> imprimirBoleto(String boletoId) throws JRException {

		IBoleto boleto = boletoRepositorio.buscarBoletoPorId(new IBoletoId(boletoId));

		if (boleto == null)
			throw new RuntimeException("Boleto não encontrado.");

		return imprimir(boleto);
	}

	public ResponseEntity<InputStreamResource> imprimir(IBoleto boleto) throws JRException {
		
		GeradorDeBoleto gerador = new GeradorDeBoleto(converterIboletoParaBoleto(boleto));
		
		byte[] pdf = gerador.geraPDF();

		HttpHeaders respHeaders = new HttpHeaders();
		respHeaders.setContentType(new MediaType("application", "pdf"));
		respHeaders.set("Cache-Control", "no-cache");
		respHeaders.set("Content-Disposition", "inline; filename=pre-" + boleto.getBoletoId() + ".pdf");
		InputStreamResource isr = new InputStreamResource(new ByteArrayInputStream(pdf));
		return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
	}
	
	public Boleto converterIboletoParaBoleto(IBoleto iboleto){
		
		Publico beneficiario = publicoRepositorio.buscarPeloId(new PublicoId(iboleto.getBeneficiarioId().id()));
		Publico pagador = publicoRepositorio.buscarPeloId(new PublicoId(iboleto.getPagadorId().id()));
		
		Datas datas = Datas.novasDatas().comDocumento(
				iboleto.getDatas().getDocumento())
				.comProcessamento(iboleto.getDatas().getProcessamento())
				.comVencimento(iboleto.getDatas().getVencimento());

		Endereco enderecoBeneficiario = Endereco.novoEndereco()
				.comLogradouro(beneficiario.getEndereco().logradouro)
				.comBairro(beneficiario.getEndereco().bairro)
				.comCep(beneficiario.getEndereco().cep)
				.comCidade(beneficiario.getEndereco().cidade)
				.comUf(beneficiario.getEndereco().uf);

		// Quem emite o boleto
		Beneficiario ben = Beneficiario.novoBeneficiario()
				.comNomeBeneficiario(beneficiario.getNome())
				.comAgencia(beneficiario.getAgencia())
				.comDigitoAgencia(beneficiario.getDigito())
				.comCodigoBeneficiario(beneficiario.getCodigo())
				.comDigitoCodigoBeneficiario(beneficiario.getDigitoCodigo())
				.comNumeroConvenio(beneficiario.getConvenio())
				.comCarteira(beneficiario.getCarteira())
				.comEndereco(enderecoBeneficiario)
				.comNossoNumero(beneficiario.getNossoNumero());

		Endereco enderecoPagador = Endereco.novoEndereco()
				.comLogradouro(pagador.getEndereco().logradouro)
				.comBairro(pagador.getEndereco().bairro)
				.comCep(pagador.getEndereco().cep)
				.comCidade(pagador.getEndereco().cidade)
				.comUf(pagador.getEndereco().uf);

		// Quem paga o boleto
		Pagador pag = Pagador.novoPagador()
				.comNome(pagador.getNome())
				.comDocumento(pagador.getDocumento().getNumero())
				.comEndereco(enderecoPagador);

		Banco banco = new BancoDoBrasil();

		Boleto boleto = Boleto.novoBoleto()
				.comBanco(banco)
				.comDatas(datas)
				.comBeneficiario(ben)
				.comPagador(pag)
				.comValorBoleto(iboleto.getValorBoleto())
				.comNumeroDoDocumento("1234")
				.comInstrucoes(iboleto.getInstrucao1(), iboleto.getInstrucao2(), iboleto.getInstrucao3(),
						iboleto.getInstrucao4(), iboleto.getInstrucao5())
				.comLocaisDePagamento(iboleto.getLocalPagamento1(), iboleto.getLocalPagamento2());
		
		return boleto;
	}
}
