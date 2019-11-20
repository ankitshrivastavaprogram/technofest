package com.tech.tests.service;

import org.springframework.stereotype.Service;

import com.tech.tests.payload.LoginPayload;

@Service
public class LoginService {

	public void login(LoginPayload loginPayload) {
	
		String usernameOrEmail = loginPayload.getUsernameOrEmail();
		String password = loginPayload.getPassword();
		
	}

	
	
}
