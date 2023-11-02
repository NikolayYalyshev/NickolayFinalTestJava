package com.example.NickolayFinalTestJava.authorization.controller.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AddProfileController {
	
	@GetMapping("/addprofile")
	public String showAddProfilePage() {
		return "addprofile.html";
	}
	
}
