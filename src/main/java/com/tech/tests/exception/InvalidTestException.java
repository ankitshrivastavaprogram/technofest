package com.tech.tests.exception;

public class InvalidTestException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message = 
			"Test creation fail , test with this name already exists is alredy exists";

	public InvalidTestException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	
	
	

}
