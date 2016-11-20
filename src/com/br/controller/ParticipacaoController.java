package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Participacao;
import com.br.services.AlunoService;
import com.br.services.ParticipacaoService;
import com.br.services.SalaService;
@RequestMapping("participacao")
@Controller
public class ParticipacaoController {
	
	@Autowired
	ParticipacaoService particService;
	@Autowired
	SalaService salaService;
	@Autowired
	AlunoService alunoService;
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}/remover")
	public String removerParticipacao(@PathVariable Long id){
		Participacao participacao = new Participacao();
		participacao.setId(id);
		particService.removerParticipacao(participacao);
		return "redirect:/sala";
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "{keyhash}/{id}/pontuar")
	public String addPontuacao(@PathVariable String keyhash, @PathVariable Long id){
		Participacao participacao = new Participacao();
		participacao.setId(id);
		particService.atualizarPontuacao(participacao);
		
		return "redirect:/sala/"+keyhash+"/list";
		
	}
}
