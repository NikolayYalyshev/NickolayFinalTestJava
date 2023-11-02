package com.example.NickolayFinalTestJava.authorization.controller;

import com.example.NickolayFinalTestJava.authorization.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class PresentationController {
	@Autowired
	private PersonService personService;
	
	@GetMapping("/presentation")
	public String showPresentationPage(Model model) throws Exception {
		model.addAttribute("name", personService.giveUsernameWithoutStorage());
		model.addAttribute("people", personService.selectAll());
		return "presentation.html";
	}
}
