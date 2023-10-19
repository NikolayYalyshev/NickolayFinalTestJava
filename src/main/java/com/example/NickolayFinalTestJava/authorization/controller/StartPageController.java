package com.example.NickolayFinalTestJava.authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {
	@GetMapping("/start")
	public String showStartPage() {
		return "startpage.html";
	}
}
