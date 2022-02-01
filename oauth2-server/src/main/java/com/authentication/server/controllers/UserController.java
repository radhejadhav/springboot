package com.authentication.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.server.entities.MyUser;
import com.authentication.server.services.AuthUser;

@RestController
@RequestMapping("/authuser")
public class UserController {

	@Autowired
	private AuthUser authUser;
	
	@PostMapping()
	public MyUser addNewUser(@RequestBody MyUser myUser) {
		return this.authUser.addNewUser(myUser);
	}
	
	@GetMapping()
	public List<MyUser> getAllUser(){
		return this.authUser.getAllUser();
	}
}
