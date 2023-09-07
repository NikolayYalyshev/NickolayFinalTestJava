package com.example.NickolayFinalTestJava.authorization.service;

import com.example.NickolayFinalTestJava.authorization.entity.Person;
import com.example.NickolayFinalTestJava.authorization.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	private PersonRepo personRepo;
	
	public Person registration(Person person) throws Exception {
		if (personRepo.findByUsername(person.getUsername()) != null){
			throw new Exception("Такой пользователь существует");
		}
		return personRepo.save(person);
	}
}
