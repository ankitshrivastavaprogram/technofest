package com.tech.tests.exception;

public class UnAuthorizedAdminException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message = "only creater of topic can modify it";

	public UnAuthorizedAdminException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	
	
	

}
