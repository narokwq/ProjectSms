package com.br.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Login;
import com.br.model.Professor;
import com.br.services.ProfessorService;

@Controller
public class LoginController {
	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping(value={"/", "login"}, method=RequestMethod.GET)
	public String login(ModelMap map){
		map.addAttribute("login", new Login());
		return "login";
	}

	@RequestMapping(value="logar", method=RequestMethod.POST)
	public String logar(@Valid @ModelAttribute("login") Login user, BindingResult result, HttpSession sessao, ModelMap map){
		if(result.hasErrors()){
			return  "login";
		}
		
		Professor professorBD = null;
		professorBD = professorService.logar(user);

		if(professorBD == null){
			user.setSenha("");
			result.rejectValue("","login", "Nome de usuário ou senha errados. Por favor tente outra vez.");
			return  "login";
		}
		sessao.setAttribute("usuario", professorBD);
		return "redirect:/home";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String login(HttpSession session){
		session.invalidate();
		return "redirect:/login";
	}
	
	

}
