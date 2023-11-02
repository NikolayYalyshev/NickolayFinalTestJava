package com.example.NickolayFinalTestJava.authorization.controller.passport;

import com.example.NickolayFinalTestJava.authorization.entity.Person;
import com.example.NickolayFinalTestJava.authorization.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowPassportController {
	@Autowired
	private PersonService personService;
	
	@GetMapping("/showpassport")
	public String showPassport(Model model) throws Exception {
		model.addAttribute("name", personService.giveUsernameWithoutStorage());
		
		if (!personService.selectPassport().hasNext()) {
			return "nopassport.html";
		} else {
			model.addAttribute("people", personService.selectAll());
			return "showpassport.html";
		}
	}
}
