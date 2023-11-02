package com.example.NickolayFinalTestJava.authorization.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int series;
	
	private int number;
	
	private String organization;
	
	private String dateIssue;
	
	private String departmentCode;
	
	@OneToOne(mappedBy = "passport", cascade = CascadeType.ALL, fetch =
			FetchType.EAGER)
	private Person person;
}
