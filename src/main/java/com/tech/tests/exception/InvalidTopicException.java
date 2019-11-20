package com.tech.tests.exception;

public class InvalidTopicException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message = "No topic exisits with this ID or name";

	public InvalidTopicException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	
	
	

}
