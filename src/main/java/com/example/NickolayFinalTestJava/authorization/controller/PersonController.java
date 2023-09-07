package com.example.NickolayFinalTestJava.authorization.controller;

import com.example.NickolayFinalTestJava.authorization.entity.Person;
import com.example.NickolayFinalTestJava.authorization.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity registration(@RequestBody Person person) {
		try{
			personService.registration(person);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
