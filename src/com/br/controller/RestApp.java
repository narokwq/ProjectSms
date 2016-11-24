package com.br.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.model.Login;

@RestController
@RequestMapping("rest")
public class RestApp {
	Login login = new Login();

	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
	public Login getEmployeeInJSON(@PathVariable String name) {

		login.setLogin(name);
		login.setSenha("employee1@rest.com");

		return login;

	}
	
}
