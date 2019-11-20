package com.tech.tests.payload;

public class LoginPayload {

	private String usernameOrEmail;
	private String password;
	public LoginPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginPayload(String usernameOrEmail, String password) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}
	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}
	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
