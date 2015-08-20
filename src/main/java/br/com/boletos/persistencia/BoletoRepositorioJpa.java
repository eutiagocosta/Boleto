package br.com.boletos.persistencia;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.boletos.dominio.boleto.IBoleto;
import br.com.boletos.dominio.boleto.IBoletoId;
import br.com.boletos.dominio.boleto.IBoletoRepositorio;

@Repository
@Transactional
public class BoletoRepositorioJpa implements IBoletoRepositorio{
	
	@Autowired
	private BoletoRepositorioSpringData repositorio;

	@Override
	public IBoleto buscarBoletoPorId(IBoletoId boletoId) {
		return repositorio.findByBoletoId(boletoId);
	}

	@Override
	public void salvar(IBoleto IBoleto) {
		repositorio.save(IBoleto);
	}

	@Override
	public void remover(IBoletoId boletoId) {
		IBoleto boleto = repositorio.findByBoletoId(boletoId);
		if (boleto != null)
			repositorio.delete(boleto);
	}

	@Override
	public IBoletoId novoId() {
		return new IBoletoId(UUID.randomUUID().toString().toUpperCase());
	}

	@Override
	public List<IBoleto> buscarTodos() {
		return (List<IBoleto>) repositorio.findAll();
	}

}
