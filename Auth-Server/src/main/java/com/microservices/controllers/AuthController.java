package com.microservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/signup")
	public UserDetails addNewUser(@RequestBody AuthUser authUser) {
		return this.authUserService.addNewUser(authUser);
	}

}
