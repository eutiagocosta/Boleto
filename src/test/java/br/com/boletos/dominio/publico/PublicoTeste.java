package br.com.boletos.dominio.publico;

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
import br.com.boletos.aplicacao.PublicoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@Transactional
public class PublicoTeste {
	
	@Autowired
	private PublicoRepositorio repositorio;
	
	@Autowired
	private PublicoService servico;
	
	private Calendar data;
	
	private Publico pagador;
	
	@Before
	public void setUp(){
		this.data = Calendar.getInstance();
		
		this.pagador = new Publico(new PublicoId("44"), 
				 "Tiago", 
				 new CPF("36456155800"), 
				 new Endereco("Jose Augusto M. 331", 
						 	  "Sumaré", 
						 	  "14530000", 
						 	  "Miguelopolis", 
						 	  "SP"), 
				 new Email("tiago@hadrion.com.br"), 
				 this.data, 
				 new Telefone(16, 992167200), 
				 Sexo.M, 
				 Tipo.P);
		
		repositorio.salvar(pagador);
	}

	@Test
	public void cadastrarPublico(){
		
		//repositorio.salvar(pagador);
		
		Publico teste = repositorio.buscarPeloId(new PublicoId(pagador.getPublicoId().id()));
		
		assertEquals("44", teste.getPublicoId().id());
	}
	
	/*@Test
	public void buscarPublicoPeloCodigo(){
		
		Publico publico = repositorio.buscarPeloCodigo(pagador.getCodigoPublico());
		
		assertEquals(new Long(137), publico.getCodigoPublico());
	
	}*/
	
	@Test
	public void atualizarPublico(){
		
		Publico publico = repositorio.buscarPeloCodigo(pagador.getCodigoPublico());
		
		//publico.getEmail().alterar("EMAILATUALIZADO@COM.BR");
		publico.setEmail(new Email("EMAILATUALIZADO@COM.BR"));
		
		repositorio.atualizar(publico);
		
		assertEquals("EMAILATUALIZADO@COM.BR", publico.getEmail().email());
	
	}
	
	@Test
	public void buscaPublicoPeloTipo(){
		//Publico publico = repositorio.buscarPeloTipo(Tipo.buscarPeloTipo("P"));
		
		//assertEquals(Tipo.P, publico.getTipo());
		
	}
}
