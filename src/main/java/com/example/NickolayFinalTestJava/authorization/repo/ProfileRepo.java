package com.example.NickolayFinalTestJava.authorization.repo;

import com.example.NickolayFinalTestJava.authorization.entity.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepo extends CrudRepository<Profile, Long> {
	@Override
	Iterable<Profile> findAll();
}
