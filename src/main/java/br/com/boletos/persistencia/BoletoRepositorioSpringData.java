package br.com.boletos.persistencia;

import org.springframework.data.repository.CrudRepository;

import br.com.boletos.dominio.boleto.IBoleto;
import br.com.boletos.dominio.boleto.IBoletoId;

public interface BoletoRepositorioSpringData extends CrudRepository<IBoleto, Long>{
	
	IBoleto findByBoletoId(IBoletoId novoBoletoId);

}
