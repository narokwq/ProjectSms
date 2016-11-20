package com.br.controller;

import java.util.Collections;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Professor;
import com.br.model.Sala;
import com.br.services.SalaService;
import com.br.util.HashPassword;

@RequestMapping("sala")
@Controller
public class SalaController {
	@Autowired
	private SalaService salaService;

	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form(ModelMap map) {
		map.addAttribute("sala", new Sala());
		return "form_sala";
	}

	@RequestMapping(method = RequestMethod.POST, value = "salvar")
	public String salvar(@Valid @ModelAttribute("sala") Sala sala, BindingResult result, HttpSession session)
			throws Exception {
		if (result.hasErrors()) {
			return "erro";
		}
		Professor professor = (Professor) session.getAttribute("usuario");
		if (professor.hasValidId()) {
			String keyHash = HashPassword.uniqueLink();
			while (salaService.checkKey(keyHash))
				;
			sala.setKey(keyHash);
			sala.setProfessor(professor);
			salaService.criar(sala);
		} else {
			return "redirect:/login";
		}
		return "redirect:/home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{keyhash}/list")
	public String updateForm(@PathVariable String keyhash, ModelMap map) {
		Sala sala = salaService.procurarByKey(keyhash);
		if(sala != null){
			Collections.sort(sala.getParticipacaos());
			map.addAttribute("sala", sala);
			map.addAttribute("keyhash", keyhash);
			return "sala";
		}
		return "redirect:/home";
		
	}
	/////////////////////// Guga
	@RequestMapping(method = RequestMethod.GET, value = "{keyhash}/remover")
	public String remover(@PathVariable String keyhash){
		Sala sala = salaService.procurarByKey(keyhash);
		System.out.println("entrou remover");
		if(sala!= null){
			salaService.remover(sala);
		}
		return "redirect:/home";
		
	}
	
}
