package br.com.boletos.dominio.boleto;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.boletos.aplicacao.Application;
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
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@Transactional
public class Boletos {

	@Autowired
	private IBoletoRepositorio repositorio;

	private Calendar cal;

	@Before
	public void setUp() {
		this.cal = Calendar.getInstance();

		IBoleto bol = new IBoleto(new IBoletoId("1"), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
				BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "", 0, "", "12345",
				new IDatas(cal, cal, cal),
				new IPagador("Fulano da Silva", "111.222.333-12",
						new IEndereco("Av dos testes, 111 apto 333", "Bairro Teste", "01234-111", "São Paulo", "SP")),
				new IBeneficiario("1824", "4", "76000", "5", "18", "9000206", "", "Fulano de Tal", "111.222.333-11",
						new IEndereco("Av das Empresas, 555", "Bairro Grande", "01234-555", "São Paulo", "SP"),
						"1207113"),
				"instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5", "local 1", "local 2");
		
		repositorio.salvar(bol);
	}

	@Test
	public void criarBoleto() {

		Datas datas = Datas.novasDatas().comDocumento(1, 5, 2008).comProcessamento(1, 5, 2008).comVencimento(2, 5,
				2008);

		Endereco enderecoBeneficiario = Endereco.novoEndereco().comLogradouro("Av das Empresas, 555")
				.comBairro("Bairro Grande").comCep("01234-555").comCidade("São Paulo").comUf("SP");

		// Quem emite o boleto
		Beneficiario beneficiario = Beneficiario.novoBeneficiario().comNomeBeneficiario("Fulano de Tal")
				.comAgencia("1824").comDigitoAgencia("4").comCodigoBeneficiario("76000")
				.comDigitoCodigoBeneficiario("5").comNumeroConvenio("1207113").comCarteira("18")
				.comEndereco(enderecoBeneficiario).comNossoNumero("9000206");

		Endereco enderecoPagador = Endereco.novoEndereco().comLogradouro("Av dos testes, 111 apto 333")
				.comBairro("Bairro Teste").comCep("01234-111").comCidade("São Paulo").comUf("SP");

		// Quem paga o boleto
		Pagador pagador = Pagador.novoPagador().comNome("Fulano da Silva").comDocumento("111.222.333-12")
				.comEndereco(enderecoPagador);

		Banco banco = new BancoDoBrasil();

		Boleto boleto = Boleto.novoBoleto().comBanco(banco).comDatas(datas).comBeneficiario(beneficiario)
				.comPagador(pagador).comValorBoleto("200.00").comNumeroDoDocumento("1234")
				.comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")
				.comLocaisDePagamento("local 1", "local 2");

		GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);

		gerador.geraPDF("C:\\BoletoTeste.pdf");
		
		assertEquals("200.00", boleto.getValorBoleto().toString());

	}

	@Test
	public void buscarBoleto() {
	
		IBoleto bol1 = repositorio.buscarBoletoPorId(new IBoletoId("1"));
		
		assertEquals("1", bol1.getBoletoId().id());
	}
	
}
