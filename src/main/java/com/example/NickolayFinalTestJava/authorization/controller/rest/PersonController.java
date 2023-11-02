package com.example.NickolayFinalTestJava.authorization.controller.rest;


import com.example.NickolayFinalTestJava.authorization.entity.Passport;
import com.example.NickolayFinalTestJava.authorization.entity.Profile;
import com.example.NickolayFinalTestJava.authorization.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.NickolayFinalTestJava.authorization.entity.Person;
import com.example.NickolayFinalTestJava.authorization.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@PostMapping("/savePerson")
	public ResponseEntity statusPerson(@RequestBody Person person) {
		try {
			personService.registration(person);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/authorizationPerson")
	public ResponseEntity authorization(@RequestBody PersonModel personModel) {
		try {
			 personService.validPersonModel(personModel);
			return new ResponseEntity<>( HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/saveProfile")
	public ResponseEntity statusProfile(@RequestBody Profile profile){
		try {
			personService.saveProfile(profile);
			return new ResponseEntity<>( HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/savePassport")
	public ResponseEntity statusPassport(@RequestBody Passport passport){
		try {
			personService.savePassport(passport);
			return new ResponseEntity<>( HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity findPersonById(Long id) {
		try {
			personService.findPersonById(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
