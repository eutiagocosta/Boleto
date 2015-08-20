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
import br.com.boletos.consulta.IBoletoData;
import br.com.boletos.dominio.beneficiario.IBeneficiario;
import br.com.boletos.dominio.boleto.IBoleto;
import br.com.boletos.dominio.boleto.IBoletoId;
import br.com.boletos.dominio.boleto.IBoletoRepositorio;
import br.com.boletos.dominio.boleto.IDatas;
import br.com.boletos.dominio.boleto.IEndereco;
import br.com.boletos.dominio.boleto.IPagador;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.bancos.Bradesco;
import br.com.caelum.stella.boleto.bancos.Caixa;
import br.com.caelum.stella.boleto.bancos.HSBC;
import br.com.caelum.stella.boleto.bancos.Itau;
import br.com.caelum.stella.boleto.bancos.Safra;
import br.com.caelum.stella.boleto.bancos.Santander;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import net.sf.jasperreports.engine.JRException;

@Service
@Transactional
public class BoletoAplicacaoService {

	@Autowired
	private IBoletoRepositorio repositorio;

	public String criarBoleto(NovoBoletoComando comando) {
		
		Banco banco;

		IBoleto bol = new IBoleto(repositorio.novoId(), comando.getValor(), comando.getQuantidadeMoeda(),
				comando.getValorMoeda(), comando.getValorDescontos(), comando.getValorDeducoes(),
				comando.getValorMulta(), comando.getValorAcrescimos(), comando.getEspecieMoeda(),
				comando.getCodigoEspecieMoeda(), comando.getEspecieDocumento(), comando.getNumeroDocumento(),
				new IDatas(comando.getEmissao(), comando.getProcessamento(), comando.getVencimento()),
				new IPagador(comando.getNomePagador(), comando.getCpfPagador(),
						new IEndereco(comando.getLogradouroPagador(), comando.getBairroPagador(),
								comando.getCepPagador(), comando.getCidadePagador(), comando.getUfPagador())),
				new IBeneficiario(comando.getAgenciaBeneficiario(), comando.getAgenciaBeneficiario(),
						comando.getCodigoBeneficiario(), comando.getDigitoCodigoBeneficiario(),
						comando.getCarteiraBeneficiario(), comando.getNossoNumero(), comando.getDigitoNossoNumero(),
						comando.getNomeBeneficiario(), comando.getCpfBeneficiario(),
						new IEndereco(comando.getLogradouroBeneficiario(), comando.getBairroBeneficiario(),
								comando.getCepBeneficiario(), comando.getCidadeBeneficiario(),
								comando.getUfBeneficiario()),
						comando.getConvenioBeneficiario()),
				comando.getInstrucao1(), comando.getInstrucao2(), comando.getInstrucao3(), comando.getInstrucao4(),
				comando.getInstrucao5(), comando.getLocalPagamento1(), comando.getLocalPagamento2());

		/*Datas datas = Datas.novasDatas().comDocumento(comando.getEmissao()).comProcessamento(comando.getProcessamento())
				.comVencimento(comando.getVencimento());

		Endereco enderecoBeneficiario = Endereco.novoEndereco().comLogradouro(comando.getLogradouroBeneficiario())
				.comBairro(comando.getBairroBeneficiario()).comCep(comando.getCepBeneficiario())
				.comCidade(comando.getCidadeBeneficiario()).comUf(comando.getUfBeneficiario());

		// Quem emite o boleto
		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comNomeBeneficiario(comando.getNomeBeneficiario())
				.comAgencia(comando.getAgenciaBeneficiario()).comDigitoAgencia(comando.getDigitoBeneficiario())
				.comCodigoBeneficiario(comando.getCodigoBeneficiario())
				.comDigitoCodigoBeneficiario(comando.getDigitoCodigoBeneficiario())
				.comNumeroConvenio(comando.getConvenioBeneficiario()).comCarteira(comando.getCarteiraBeneficiario())
				.comEndereco(enderecoBeneficiario).comNossoNumero(comando.getNossoNumero());

		Endereco enderecoPagador = Endereco.novoEndereco().comLogradouro(comando.getLogradouroPagador())
				.comBairro(comando.getBairroPagador()).comCep(comando.getCepPagador())
				.comCidade(comando.getCidadePagador()).comUf(comando.getUfPagador());

		// Quem paga o boleto
		Pagador pagador = Pagador.novoPagador().comNome(comando.getNomePagador()).comDocumento(comando.getCpfPagador())
				.comEndereco(enderecoPagador);
		
		switch (comando.getBanco()) {
		case "BANCO BRASIL":
			banco = new BancoDoBrasil();
			break;

		case "CAIXA":
			banco = new Caixa();
			break;
		
		case "ITAÚ":
			banco = new Itau();
			break;
		
		case "BRADESCO":
			banco = new Bradesco();
			break;
		
		case "SANTANDER":
			banco = new Santander();
			break;
			
		case "HSBC":
			banco = new HSBC();
			break;
			
		default:
			banco = new Safra();
			break;
		}

		Boleto boleto = Boleto.novoBoleto().comBanco(banco).comDatas(datas).comBeneficiario(beneficiario)
				.comPagador(pagador).comValorBoleto(comando.getValor())
				.comNumeroDoDocumento(comando.getNumeroDocumento())
				.comInstrucoes(comando.getInstrucao1(), comando.getInstrucao2(), comando.getInstrucao3(),
						comando.getInstrucao4(), comando.getInstrucao5())
				.comLocaisDePagamento(comando.getLocalPagamento1(), comando.getLocalPagamento2());

		GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);

		gerador.geraPDF("C:\\Boleto.pdf");
*/
		repositorio.salvar(bol);

		return bol.getBoletoId().id();

	}

	public List<Banco> listarBancos() {
		List<Banco> bancos = new ArrayList<Banco>();
		return bancos;
	}

	public IBoleto obterPeloId(IBoletoId boletoId) {
		
		IBoleto iboleto = repositorio.buscarBoletoPorId(boletoId);
		if (iboleto == null)
			throw new RuntimeException("Boleto não encontrado.");
		
		return iboleto;
	}

	public List<IBoletoData> listarTodos() {

		List<IBoletoData> lista = new ArrayList<IBoletoData>();

		List<IBoleto> boletos = repositorio.buscarTodos();

		for (IBoleto iBoleto : boletos)
			lista.add(construir(iBoleto));

		Collections.sort(lista, new Comparator<IBoletoData>() {

			@Override
			public int compare(IBoletoData boleto1, IBoletoData boleto2) {
				return boleto2.getEmissao().compareTo(boleto1.getEmissao());
			}
			
		});
		
		return lista;

	}

	private IBoletoData construir(IBoleto boleto) {
		return boleto == null ? null
				: new IBoletoData(boleto.getBoletoId().id(), boleto.getValorBoleto(), boleto.getQuantidadeMoeda(),
						boleto.getValorMoeda(), boleto.getValorDescontos(), boleto.getValorDeducoes(),
						boleto.getValorMulta(), boleto.getValorAcrescimos(), boleto.getEspecieMoeda(),
						boleto.getCodigoEspecieMoeda(), boleto.getEspecieDocumento(), boleto.getNumeroDocumento(),
						boleto.getDatas().getDocumento(), boleto.getDatas().getProcessamento(),
						boleto.getDatas().getVencimento(), boleto.getPagador().getNome(),
						boleto.getPagador().getDocumento(), boleto.getPagador().getEndereco().getLogradouro(),
						boleto.getPagador().getEndereco().getBairro(), boleto.getPagador().getEndereco().getCep(),
						boleto.getPagador().getEndereco().getCidade(), boleto.getPagador().getEndereco().getUf(),
						boleto.getBeneficiario().getEndereco().getLogradouro(),
						boleto.getBeneficiario().getEndereco().getBairro(),
						boleto.getBeneficiario().getEndereco().getCep(), boleto.getBeneficiario().getDocumento(),
						boleto.getBeneficiario().getEndereco().getCidade(),
						boleto.getBeneficiario().getEndereco().getUf(), boleto.getBeneficiario().getNomeBeneficiario(),
						boleto.getBeneficiario().getAgencia(), boleto.getBeneficiario().getDigitoAgencia(),
						boleto.getBeneficiario().getCodigoBeneficiario(),
						boleto.getBeneficiario().getDigitoCodigoBeneficiario(),
						boleto.getBeneficiario().getNumeroConvenio(), boleto.getBeneficiario().getCarteira(),
						boleto.getBeneficiario().getDigitoNossoNumero(), boleto.getBeneficiario().getNossoNumero(),
						boleto.getInstrucao1(), boleto.getInstrucao2(), boleto.getInstrucao3(), boleto.getInstrucao4(),
						boleto.getInstrucao5(), boleto.getLocalPagamento1(), boleto.getLocalPagamento2());
	}

	public ResponseEntity<InputStreamResource> imprimirBoleto(String boletoId) throws JRException {

		IBoleto boleto = repositorio.buscarBoletoPorId(new IBoletoId(boletoId));

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
		
		Datas datas = Datas.novasDatas().comDocumento(
				iboleto.getDatas().getDocumento())
				.comProcessamento(iboleto.getDatas().getProcessamento())
				.comVencimento(iboleto.getDatas().getVencimento());

		Endereco enderecoBeneficiario = Endereco.novoEndereco()
				.comLogradouro(iboleto.getBeneficiario().getEndereco().logradouro)
				.comBairro(iboleto.getBeneficiario().getEndereco().bairro)
				.comCep(iboleto.getBeneficiario().getEndereco().cep)
				.comCidade(iboleto.getBeneficiario().getEndereco().cidade)
				.comUf(iboleto.getBeneficiario().getEndereco().uf);

		// Quem emite o boleto
		Beneficiario beneficiario = Beneficiario.novoBeneficiario()
				.comNomeBeneficiario(iboleto.getBeneficiario().getNomeBeneficiario())
				.comAgencia(iboleto.getBeneficiario().getAgencia())
				.comDigitoAgencia(iboleto.getBeneficiario().getDigitoAgencia())
				.comCodigoBeneficiario(iboleto.getBeneficiario().getCodigoBeneficiario())
				.comDigitoCodigoBeneficiario(iboleto.getBeneficiario().getDigitoCodigoBeneficiario())
				.comNumeroConvenio(iboleto.getBeneficiario().getNumeroConvenio())
				.comCarteira(iboleto.getBeneficiario().getCarteira())
				.comEndereco(enderecoBeneficiario)
				.comNossoNumero(iboleto.getBeneficiario().getNossoNumero());

		Endereco enderecoPagador = Endereco.novoEndereco()
				.comLogradouro(iboleto.getPagador().getEndereco().logradouro)
				.comBairro(iboleto.getPagador().getEndereco().bairro)
				.comCep(iboleto.getPagador().getEndereco().cep)
				.comCidade(iboleto.getPagador().getEndereco().cidade)
				.comUf(iboleto.getPagador().getEndereco().uf);

		// Quem paga o boleto
		Pagador pagador = Pagador.novoPagador()
				.comNome(iboleto.getPagador().getNome())
				.comDocumento(iboleto.getPagador().getDocumento())
				.comEndereco(enderecoPagador);

		Banco banco = new BancoDoBrasil();

		Boleto boleto = Boleto.novoBoleto()
				.comBanco(banco)
				.comDatas(datas)
				.comBeneficiario(beneficiario)
				.comPagador(pagador)
				.comValorBoleto(iboleto.getValorBoleto())
				.comNumeroDoDocumento(iboleto.getNumeroDocumento())
				.comInstrucoes(iboleto.getInstrucao1(), iboleto.getInstrucao2(), iboleto.getInstrucao3(),
						iboleto.getInstrucao4(), iboleto.getInstrucao5())
				.comLocaisDePagamento(iboleto.getLocalPagamento1(), iboleto.getLocalPagamento2());
		
		return boleto;
	}
}
