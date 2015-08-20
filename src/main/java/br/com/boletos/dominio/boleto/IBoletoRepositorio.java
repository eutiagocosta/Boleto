package br.com.boletos.dominio.boleto;

import java.util.List;

public interface IBoletoRepositorio {
	
	IBoleto buscarBoletoPorId(IBoletoId boletoId);
	
	void salvar(IBoleto  Boleto);
	
	void remover(IBoletoId boletoId);
	
	 IBoletoId novoId();

	List<IBoleto> buscarTodos();

}
