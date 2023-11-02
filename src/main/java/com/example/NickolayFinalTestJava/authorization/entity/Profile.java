package com.example.NickolayFinalTestJava.authorization.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String surname;
	
	private String lastname;
	
	private String birthday;
	
	private long phoneNumber;
	
	@OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Person person;
	
	public Profile(String surname, String lastname, String birthday,
				   long phoneNumber) {
		this.surname = surname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Profile{" + "id=" + id + ", surname='" + surname + '\'' +
				", lastname='" + lastname + '\'' + ", birthday='" + birthday +
				'\'' + ", phoneNumber=" + phoneNumber + ", person=" + person +
				'}';
	}
}
