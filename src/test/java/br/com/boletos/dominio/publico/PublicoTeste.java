package br.com.boletos.dominio.publico;

import static org.junit.Assert.assertEquals;

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

	@Test
	public void cadastrarBeneficiario(){
		
		Publico pagador = new Publico(new PublicoId("1"), "Tiago");
		repositorio.salvar(pagador);
		
		Publico teste = repositorio.buscarPeloId(new PublicoId(pagador.getPublicoId().id()));
		
		assertEquals(pagador.getPublicoId().id(), teste.getPublicoId().id());
	}
	
	@Test
	public void buscarPublicoPeloCodigo(){
		
		Publico publico = repositorio.buscarPeloCodigo(new Long(44));
		
		assertEquals(new Long(44), publico.getCodigoPublico());
	
	}
	
	@Test
	public void atualizarPublico(){
		
		Publico publico = repositorio.buscarPeloCodigo(new Long(44));
		
		//publico.getEmail().alterar("EMAILATUALIZADO@COM.BR");
		publico.setEmail(new Email("EMAILATUALIZADO@COM.BR"));
		
		repositorio.atualizar(publico);
		
		assertEquals("EMAILATUALIZADO@COM.BR", publico.getEmail().email());
	
	}
}
