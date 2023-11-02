package com.example.NickolayFinalTestJava.authorization.controller.passport;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddPassportController {
	
	@GetMapping("/addpassport")
	public String showAddPassportPage() {
		return "addpassport.html";
	}
}
