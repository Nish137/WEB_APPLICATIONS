package com.springBoot.Developing.Restful.API.security;

import org.springframework.stereotype.Component;

@Component
public class AuthUser {
	
	private String username;
	private String password;
	
	
	public AuthUser() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AuthUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "AuthUser [username=" + username + ", password=" + password + "]";
	}
	
	

}
