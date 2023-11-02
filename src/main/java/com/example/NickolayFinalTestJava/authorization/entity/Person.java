package com.example.NickolayFinalTestJava.authorization.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	private String username;
	private String email;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_id", nullable = true)
	private Profile profile;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passport_id", nullable = true)
	private Passport passport;
}