package com.example.NickolayFinalTestJava.authorization.controller;

import com.example.NickolayFinalTestJava.authorization.entity.Person;
import com.example.NickolayFinalTestJava.authorization.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorizationController {
	
	@GetMapping("/authorization")
	public String showAuthorizationPage() {
		return "authorization.html";
	}
	
	
}
