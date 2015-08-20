package br.com.boletos.dominio.beneficiario;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.boletos.aplicacao.Application;
import br.com.boletos.dominio.boleto.IEndereco;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@Transactional
public class BeneficiarioTeste {

	@Autowired
	private IBeneficiarioRepositorio repositorio;
	
	@Test
	public void cadastrarBeneficiario(){
	
		IBeneficiario beneficiario = new IBeneficiario("1997", "1", "76000", "4", "18", "9000206", "1", "Tiago Costa", "11111", 
										 new IEndereco("Jose Augusto", "Sumare", "14530000", "Miguelopolis", "SP"), "12345");
		
		IBeneficiario bene = repositorio.salvar(beneficiario);
		
		assertEquals(beneficiario, bene);
	}
}
