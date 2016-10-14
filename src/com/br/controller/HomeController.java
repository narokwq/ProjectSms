package com.br.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Professor;

@Controller
public class HomeController {
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String home(ModelMap map, HttpSession session){
		Professor professor = (Professor) session.getAttribute("usuario");
		map.addAttribute("salas", professor.getSalas());
		return "home";
	}
}
