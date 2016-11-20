package com.br.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Professor;
import com.br.services.ProfessorService;

@RequestMapping("cliente")
@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form(ModelMap map) {
		map.addAttribute("cliente", new Professor());
		return "form";
	}

	@RequestMapping(method = RequestMethod.POST, value = "salvar")
	public String salvar(@Valid @ModelAttribute("cliente") Professor professor, BindingResult result,
			HttpSession session, ModelMap map) throws NoSuchAlgorithmException{
		System.out.println("passou Aqui");
		Date dataCadastro = new Date();
		professor.getLogin().criarSenha(professor.getLogin().getSenha());
		professor.setData(dataCadastro);
		try {
			professorService.criar(professor);
		} catch (Exception e) {
				map.addAttribute("message", "Usu�rio j� existe!");
				return "form";
		}
		map.addAttribute("message","Cadastro efetuado com sucesso!");
		return "form";
	}
}
