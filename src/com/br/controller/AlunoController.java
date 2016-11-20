package com.br.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Aluno;
import com.br.model.Participacao;
import com.br.model.Sala;
import com.br.services.AlunoService;
import com.br.services.SalaService;

@RequestMapping("aluno")
@Controller
public class AlunoController {
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private SalaService salaService;

	@RequestMapping(method = RequestMethod.GET, value = "{keyhash}/form")
	public String updateForm(@PathVariable String keyhash, ModelMap map) {
		map.addAttribute("aluno", new Aluno());
		map.addAttribute("keyhash", keyhash);
		return "aluno";
	}

	@RequestMapping(method = RequestMethod.POST, value = "{keyhash}/salvar")
	public String salvar(@Valid @ModelAttribute("aluno") Aluno aluno, BindingResult result,
			@PathVariable String keyhash, ModelMap map) throws Exception {
		Sala sala = salaService.procurarByKey(keyhash);

		if (sala != null && !alunoService.procurarByTelefoneAndKey(aluno, keyhash)) {
			Participacao participacao = new Participacao();
			participacao.setSala(sala);
			participacao.setAluno(aluno);
			aluno.addParts(participacao);
			alunoService.criarParticipacao(participacao);
		}
		map.addAttribute("mensagem", "Usuário cadastrado com sucesso!");
		return "redirect:/login";
	}
	
	

	@RequestMapping(method = RequestMethod.GET, value = "{keyhash}/{id}/remover")
	public String deleteForm(@PathVariable String keyhash, @PathVariable Long id, ModelMap map) {
		Aluno aluno = new Aluno();
		aluno.setId(id);
		alunoService.remover(aluno);
		map.addAttribute("aluno", new Aluno());
		return "redirect:/sala/"+keyhash+"/list";
	}
	

}
