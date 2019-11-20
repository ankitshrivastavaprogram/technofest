package com.tech.tests.exception;

public class InvalidTestModifierException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message = "Only creater of test can modify the test";

	public InvalidTestModifierException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	
	
	

}
