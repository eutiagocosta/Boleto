package br.com.boletos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.boletos.aplicacao.BoletoService;
import br.com.boletos.comando.NovoBoletoComando;
import br.com.boletos.dominio.boleto.IBoletoId;
import br.com.boletos.util.Retorno;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/boleto")
public class BoletoController {

	@Autowired
	private BoletoService servico;
	
	@RequestMapping(value = "novo", method = RequestMethod.POST)
	@ResponseBody 
	public Retorno novoBoleto(@RequestBody NovoBoletoComando comando) throws Exception{
		String id = servico.criarBoleto(comando);
		return new Retorno(servico.obterPeloId(new IBoletoId(id)));
	}
	
	@RequestMapping(value = "listar", method=RequestMethod.GET)
	@ResponseBody 
	public Retorno listarBoletos(){
		return new Retorno(servico.listarTodos());
	}
	
	@RequestMapping(value = "imprimir_boleto", method=RequestMethod.GET)
	@ResponseBody 
	public ResponseEntity<InputStreamResource> imprimirBoleto(@RequestParam(value="boletoId")String boletoId) throws JRException{
		return servico.imprimirBoleto(boletoId);
	}	

}
