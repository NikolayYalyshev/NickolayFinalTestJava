package com.example.NickolayFinalTestJava.authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorizationController {
	
	@GetMapping("/authorization")
	public String showAuthorizationPage() {
		return "authorization.html";
	}
	

}
