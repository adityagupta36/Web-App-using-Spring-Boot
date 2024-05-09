package com.aditya.springboot.myFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username , String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("Aditya");
		boolean isValidPassword = password.equalsIgnoreCase("A@1");
		
		return isValidUserName && isValidPassword;
	}

}
