package com.intranetcmv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(){
		return "home";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	//login invalido
	@GetMapping("/login-error")
	public String loginError(ModelMap model) {
		model.addAttribute("alerta", "erro");
		model.addAttribute("titulo", "Credenciais inválidas!");
		model.addAttribute("texto", "Login ou senha inválidos, tente novamente.");
		model.addAttribute("alerta", "erro");
		return "login";
	}
	
}
