package com.example.NickolayFinalTestJava.authorization.controller.passport;

import com.example.NickolayFinalTestJava.authorization.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoPassportController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/nopassport")
	public String showNoPassportPage(Model model) throws Exception {
		model.addAttribute("name", personService.giveUsernameWithoutStorage());
		
		return "nopassport.html";
	}
}
