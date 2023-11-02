package com.example.NickolayFinalTestJava.authorization.exceptions;

public class ExceptionNoExistPerson extends Exception{
	
	public ExceptionNoExistPerson() {
		super("Несуществующий пользователь");
	}
	
}
