package com.example.NickolayFinalTestJava.authorization.service;

import com.example.NickolayFinalTestJava.authorization.entity.Passport;
import com.example.NickolayFinalTestJava.authorization.entity.Person;
import com.example.NickolayFinalTestJava.authorization.entity.Profile;
import com.example.NickolayFinalTestJava.authorization.exceptions.ExceptionNoExistPerson;
import com.example.NickolayFinalTestJava.authorization.exceptions.ExceptionPersonExists;
import com.example.NickolayFinalTestJava.authorization.model.PersonModel;
import com.example.NickolayFinalTestJava.authorization.repo.PassportRepo;
import com.example.NickolayFinalTestJava.authorization.repo.PersonRepo;
import com.example.NickolayFinalTestJava.authorization.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;


@Service
public class PersonService {
	@Autowired
	private PersonRepo personRepo;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@Autowired
	private PassportRepo passportRepo;
	
	ArrayList<String> storageUsername;
	
	public Person registration(Person person) throws ExceptionPersonExists {
		if (personRepo.findByUsername(person.getUsername()) != null){
			throw new ExceptionPersonExists();
		}
		String username = person.getUsername();
		storageUsername = new ArrayList<>();
		storageUsername.add(0, username);
		return personRepo.save(person);
	}
	
	public Person findPersonById(Long id){
		return personRepo.findById(id).orElseThrow();
	}
	
	public Person findByUsername(String username){
		return personRepo.findByUsername(username);
	}
	
	
	public String validPersonModel(PersonModel personModel)
			throws ExceptionNoExistPerson {
		String username = personModel.getUsername();
		storageUsername = new ArrayList<>();
		storageUsername.add(0, username);
		Person person = personRepo.findByUsername(username);
		if(!person.getPassword().equals(personModel.getPassword())){
			throw new ExceptionNoExistPerson();
		}
		return username;
	}
	
	public String giveUsernameWithoutStorage() throws ExceptionNoExistPerson {
		String username = storageUsername.get(0);
		if (username == null){
			throw new ExceptionNoExistPerson();
		}
		return username;
	}
	
	public Person saveProfile(Profile profile){
		Person person =	findByUsername(storageUsername.get(0));
		person.setProfile(profile);
		return personRepo.save(person);
	}
	
	public Person savePassport(Passport passport){
		Person person =	findByUsername(storageUsername.get(0));
		person.setPassport(passport);
		return personRepo.save(person);
	}
	
	public Iterable<Person> selectAll(){
		Iterable<Person> people = personRepo.findAll();
		return people;
	}
	
	public Iterator<Profile> selectProfile(){
		Iterable<Profile> profile = profileRepo.findAll();
		Iterator<Profile> iterator = profile.iterator();
		return iterator;
	}
	
	public Iterator<Passport> selectPassport(){
		Iterable<Passport> passport = passportRepo.findAll();
		Iterator<Passport> iterator = passport.iterator();
		return iterator;
	}
}
