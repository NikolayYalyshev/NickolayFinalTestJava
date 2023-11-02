package com.example.NickolayFinalTestJava.authorization.repo;

import com.example.NickolayFinalTestJava.authorization.entity.Passport;
import org.springframework.data.repository.CrudRepository;

public interface PassportRepo extends CrudRepository<Passport, Long> {
	@Override
	Iterable<Passport> findAll();
}
