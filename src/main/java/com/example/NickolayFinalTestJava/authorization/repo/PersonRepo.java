package com.example.NickolayFinalTestJava.authorization.repo;

import com.example.NickolayFinalTestJava.authorization.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepo extends CrudRepository<Person, Long>{
	Person findByUsername(String username);
	
	Person findPersonById(Long id);
	
	
}
