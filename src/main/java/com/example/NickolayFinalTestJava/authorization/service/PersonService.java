package com.example.NickolayFinalTestJava.authorization.service;

import com.example.NickolayFinalTestJava.authorization.entity.Person;
import com.example.NickolayFinalTestJava.authorization.model.PersonModel;
import com.example.NickolayFinalTestJava.authorization.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
	
	public Person findPersonById(Long id){
		return personRepo.findById(id).orElseThrow();
	}
	
	public Person findByUsername(String username){
		return personRepo.findByUsername(username);
	}
	
	public String validateText(PersonModel personModel) throws Exception {
		String username = personModel.getUsername();
		Person person = personRepo.findByUsername(username);
		if(!person.getPassword().equals(personModel.getPassword())){
			throw new Exception("Несуществующий пользователь");
		}
		return username;
	}
}
