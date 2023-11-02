package com.example.NickolayFinalTestJava.authorization.controller;

import com.example.NickolayFinalTestJava.authorization.entity.Person;
import com.example.NickolayFinalTestJava.authorization.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
@Autowired
private PersonService personService;

    @GetMapping("/mainpage")
    public String showMainPage(Model model) throws Exception {
        model.addAttribute("name", personService.giveUsernameWithoutStorage());
        
        if (!personService.selectProfile().hasNext()) {
            return "mainpage.html";
        } else {
            model.addAttribute("people", personService.selectAll());
            return "showprofile.html";
        }
    }
}
