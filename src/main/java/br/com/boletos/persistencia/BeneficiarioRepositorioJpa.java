package br.com.boletos.persistencia;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.boletos.dominio.beneficiario.IBeneficiario;
import br.com.boletos.dominio.beneficiario.IBeneficiarioRepositorio;

public class BeneficiarioRepositorioJpa implements IBeneficiarioRepositorio{
	
	@Autowired
	private BeneficiarioRepositorioSpringData repositorio;

	@Override
	public IBeneficiario salvar(IBeneficiario beneficiario) {
		return repositorio.save(beneficiario);
		
	}

} 
