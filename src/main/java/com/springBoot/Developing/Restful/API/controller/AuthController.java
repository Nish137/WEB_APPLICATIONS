package com.springBoot.Developing.Restful.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.Developing.Restful.API.entity.AuthRequest;
import com.springBoot.Developing.Restful.API.security.JwtUtil;

@RestController
public class AuthController {
	
	private JwtUtil jwtUtil;
	@Autowired
	public AuthController(JwtUtil jwtUtil) {
		this.jwtUtil=jwtUtil;
	}
	@PostMapping("/login")
	public String createToken(@RequestBody AuthRequest authRequest) {
		 String username = authRequest.getUserName();
		 String password = authRequest.getPassword();
		 
		 if("Shiva".equals(username) && "password".equals(password)) {
			 return  jwtUtil.generateToken(username);
		 }	
		return "Invalid username or password";
		
	}

}
