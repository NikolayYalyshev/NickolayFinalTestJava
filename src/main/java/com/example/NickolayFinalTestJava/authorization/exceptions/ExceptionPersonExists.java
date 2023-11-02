package com.example.NickolayFinalTestJava.authorization.exceptions;

public class ExceptionPersonExists extends Exception{
	public ExceptionPersonExists() {
		super("Такой пользователь существует");
	}
}
