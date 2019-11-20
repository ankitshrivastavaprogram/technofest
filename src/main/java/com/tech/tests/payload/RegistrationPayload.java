package com.tech.tests.payload;

import java.util.List;

public class RegistrationPayload {
	
	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	
	AddressPayload address;	
	List<String> roles;
	public RegistrationPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegistrationPayload(String username, String email, String firstName, String lastName, String password,
			AddressPayload address, List<String> roles) {
		super();
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.address = address;
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AddressPayload getAddress() {
		return address;
	}
	public void setAddress(AddressPayload address) {
		this.address = address;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	

}
