package com.br.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.br.model.Login;

@Controller
public class LoginController {
	 Login employee = new Login();
	
	@RequestMapping(value={"/", "login"}, method=RequestMethod.GET)
	public String login(ModelMap map){
		map.addAttribute("login", new Login());
		return "login";
	}

	
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String login(HttpSession session){
		session.invalidate();
		return "redirect:/login";
	}
	

}
