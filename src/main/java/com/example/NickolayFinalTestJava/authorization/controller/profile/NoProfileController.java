package com.example.NickolayFinalTestJava.authorization.controller.profile;

import com.example.NickolayFinalTestJava.authorization.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NoProfileController {
	@Autowired
	private PersonService personService;
	
	@GetMapping("/noprofile")
	public String showNoProfilePage(Model model) throws Exception {
		model.addAttribute("name", personService.giveUsernameWithoutStorage());
		
		return "noprofile.html";
	}
}
