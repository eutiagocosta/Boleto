package br.com.boletos.persistencia;

import org.springframework.data.repository.CrudRepository;

import br.com.boletos.dominio.beneficiario.IBeneficiario;

public interface BeneficiarioRepositorioSpringData extends CrudRepository<IBeneficiario, Long> {
	
}
