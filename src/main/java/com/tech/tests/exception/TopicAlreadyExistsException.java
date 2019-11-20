package com.tech.tests.exception;

public class TopicAlreadyExistsException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message = "Topic creation fails , Topic with this name already exists";

	public TopicAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	
	
	

}
