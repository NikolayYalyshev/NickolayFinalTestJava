package com.example.NickolayFinalTestJava.authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/demo/mainpage")
    public String showMainPage(){
        return "mainpage.html";
    }
}
