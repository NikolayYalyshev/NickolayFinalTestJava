package com.example.NickolayFinalTestJava.authorization.repo;

import com.example.NickolayFinalTestJava.authorization.entity.Person;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepo extends CrudRepository<Person, Long>{
	Person findByUsername(String username);
	
	@Override
	Iterable<Person> findAll();
}
