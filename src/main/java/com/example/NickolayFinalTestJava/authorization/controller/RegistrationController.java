package com.example.NickolayFinalTestJava.authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {
	@GetMapping("/registration")
	public String showRegPage() {
		return "registration.html";
	}
	
}
