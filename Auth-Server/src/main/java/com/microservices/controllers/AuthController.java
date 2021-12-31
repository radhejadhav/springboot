package com.microservices.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.dto.GenerateToken;
import com.microservices.dto.TokenRequest;
import com.microservices.entities.AuthUser;
import com.microservices.services.AuthUserService;

@RestController
@RequestMapping(value = "/user")
public class AuthController {
	
	@Autowired
	private AuthUserService authUserService;
	
	@GetMapping("/user")
	public String userLogin() {
		return "Hello User";
	}
	@GetMapping("/admin")
	public String helloAdmin() {
		return "Hello Admin";
	}
	@GetMapping("/home")
	public String homepage() {
		return "Welcome to Homepage !";
	}
	
	@PostMapping("/signup")
	public UserDetails addNewUser(@RequestBody AuthUser authUser) {
		return this.authUserService.addNewUser(authUser);
	}
	
	@GetMapping("/all-user")
	public List<AuthUser> getAllUser(){
		return this.authUserService.getAllUser();
	}
	
	@PostMapping("/token")
	public String getToken(@RequestBody TokenRequest tokenRequest) {
		GenerateToken tokenGen = new GenerateToken();
		UserDetails users = this.authUserService.loadUserByUsername(tokenRequest.getUsername());
		
		if(users.getUsername() != null) {
			return tokenGen.getToken(tokenRequest);
		}else {
//			throw new RuntimeException();
			return null;
		}
		
	}
}
