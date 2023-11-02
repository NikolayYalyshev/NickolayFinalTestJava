package com.example.NickolayFinalTestJava.authorization.controller.profile;

import com.example.NickolayFinalTestJava.authorization.entity.Person;
import com.example.NickolayFinalTestJava.authorization.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowProfileController {
	@Autowired
	private PersonService personService;
	
	@GetMapping("/showprofile")
	public String showProfile(Model model) throws Exception {
		model.addAttribute("name", personService.giveUsernameWithoutStorage());
		
		if (!personService.selectProfile().hasNext()) {
			return "noprofile.html";
		} else {
			model.addAttribute("people", personService.selectAll());
			return "showprofile.html";
		}
	}
}
