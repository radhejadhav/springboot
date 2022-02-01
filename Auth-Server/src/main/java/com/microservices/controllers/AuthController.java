package com.microservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.dto.JwtUtil;
import com.microservices.dto.TokenRequest;
import com.microservices.entities.AuthUser;
import com.microservices.services.AuthUserService;


@RestController
@RequestMapping(value = "/user")
public class AuthController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthUserService authUserService;
	
//	@Autowired
//	private AuthenticationManager authenticationManager;
	
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
			
		UserDetails user = this.authUserService.loadUserByUsername(tokenRequest.getUsername());
		
		try {
			SecurityContext context = SecurityContextHolder.getContext();
			UsernamePasswordAuthenticationToken authentication = 
					new UsernamePasswordAuthenticationToken(tokenRequest.getUsername(), tokenRequest.getPassword(), user.getAuthorities());
			if(authentication.isAuthenticated()) {
					context.setAuthentication(authentication);
					String token = this.jwtUtil.createToken(tokenRequest);
					System.out.println(token);
					return token;
			}
			return "Bad Credential !";
			
		} catch (Exception e) {
			throw new RuntimeException("Bad Credential");
		}
	}
}
