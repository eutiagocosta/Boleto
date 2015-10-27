package br.com.boletos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.boletos.aplicacao.PublicoService;
import br.com.boletos.comando.NovoPublicoComando;
import br.com.boletos.dominio.publico.PublicoId;
import br.com.boletos.util.Retorno;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/publico")
public class PublicoController {
	
	@Autowired
	private PublicoService servico;
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	@ResponseBody 
	public Retorno novoPublico(@RequestBody NovoPublicoComando comando) throws Exception{
		String id = servico.cadastrarPublico(comando);
		return new Retorno(servico.obterPublicoPeloId(new PublicoId(id)));
	}
	
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	@ResponseBody 
	public Retorno listarPublicos(){
		return new Retorno(servico.listarTodos());
	}
	
	@RequestMapping(value = "/atualizar", method=RequestMethod.POST)
	@ResponseBody 
	public Retorno atualizarPublico(@RequestBody NovoPublicoComando comando) throws Exception{
		String id = servico.atualizarPublico(comando);
		return new Retorno(servico.obterPublicoPeloId(new PublicoId(id)));
	}
	
	@RequestMapping(value = "/buscarPeloCodigo", method=RequestMethod.GET)
	@ResponseBody 
	public Retorno buscarPublicoPeloCodigo(@RequestBody String codigo) throws Exception{
		return new Retorno(servico.obterPublicoPeloCodigo(Long.parseLong(codigo)));
	}
	
	@RequestMapping(value = "/buscarPeloTipo", method=RequestMethod.GET)
	@ResponseBody 
	public Retorno buscarPublicoPeloTipo(@RequestParam(value="tipo")String tipo) throws Exception{
		return new Retorno(servico.obterPublicoPeloTipo(tipo));
	}
	
	@RequestMapping(value = "/obter_nome_pagador", method = RequestMethod.GET)
	@ResponseBody
	public Retorno obterNomePagador(@RequestParam(value="pagadorId")String pagadorId) throws JRException{
		return new Retorno(servico.obterNomePeloId(pagadorId));
	}
}
