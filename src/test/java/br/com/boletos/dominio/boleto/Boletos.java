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
import br.com.boletos.dominio.publico.CPF;
import br.com.boletos.dominio.publico.Email;
import br.com.boletos.dominio.publico.Endereco;
import br.com.boletos.dominio.publico.Publico;
import br.com.boletos.dominio.publico.PublicoId;
import br.com.boletos.dominio.publico.PublicoRepositorio;
import br.com.boletos.dominio.publico.Sexo;
import br.com.boletos.dominio.publico.Telefone;
import br.com.boletos.dominio.publico.Tipo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@Transactional
public class Boletos {

	@Autowired
	private IBoletoRepositorio repositorio;
	
	@Autowired
	private PublicoRepositorio publicoRepositorio;

	private Calendar cal;
	private IBoleto boleto;
	
	private Publico pagador;
	
	private Publico beneficiario;

	@Before
	public void setUp() {
		
		this.cal = Calendar.getInstance();
		
		this.pagador = new Publico(new PublicoId("2"), "Tiago");
		publicoRepositorio.salvar(pagador);
		
		this.beneficiario = new Publico(new PublicoId("3"), 
										"Migue", 
										new CPF("36456155800"), 
										new Endereco("Jose Augusto M. 331", 
													 "Sumare", "14530000", 
													 "Miguelopolis", 
													 "SP"), 
										new Email("tiago@teste.com"), 
										cal, 
										new Telefone(16, 992167200), 
										Sexo.buscarPeloFlag("M"), 
										Tipo.buscarPeloFlag("B"), 
										"1997", 
										"1", 
										"96000", 
										"5", 
										"1207113", 
										"18", 
										"0", 
										"9000206");
		
		publicoRepositorio.salvar(beneficiario);
		
	}
	
	@Test
	public void buscarBeneficiario(){
		Publico beneficiario = publicoRepositorio.buscarPeloId(new PublicoId("3"));
		
		assertEquals("3", beneficiario.getPublicoId().id());
		
	}

	@Test
	public void criarBoleto() {
		
		this.boleto = new IBoleto(new IBoletoId("1"), 
				  this.pagador.getPublicoId(), 
				  this.beneficiario.getPublicoId(), 
			      new BigDecimal(1000), 
			      //new BigDecimal(100), 
			      //new BigDecimal(1), 
			      //new BigDecimal(1), 
			      //new BigDecimal(0), 
			      //new BigDecimal(0), 
			      //new BigDecimal(0), 
			      //"0", 
			      //1, 
			      //"DM", 
			      //"1212", 
			      new IDatas(cal, cal, cal), 
			      "instrucao 1", 
			      "instrucao 2", 
			      "instrucao 3", 
			      "instrucao 4", 
			      "instrucao 5", 
			      "local 1", 
			      "local 2", 
			      "CAIXA");	

		repositorio.salvar(boleto);
		
		IBoleto bol = repositorio.buscarBoletoPorId(new IBoletoId(boleto.getBoletoId().id()));
		
		assertEquals(boleto.getBoletoId().id(), bol.getBoletoId().id());

	}
	
}
