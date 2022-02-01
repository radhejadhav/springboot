package com.authentication.server.controllers;

import com.authentication.server.securityconfig.TokenGenerator;
import com.authentication.server.services.MyUserDetailService;
import com.authentication.server.userDto.UserLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;



@RestController
//@RequestMapping()
public class MyController {

    @Autowired
    public MyUserDetailService myUserDetailService;

    @Autowired
    public AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public String token(@RequestBody UserLogin userLogin){
    	try {
    		UserDetails user = this.myUserDetailService.loadUserByUsername(userLogin.getUsername());
    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    	}catch(Exception e){
    		throw new RuntimeException(e.getMessage());
    	}
        return TokenGenerator.encode(userLogin.getUsername(),userLogin.getPassword());
    }

    @GetMapping("/user")
    public String getUser(){
    	
        return "hello Admin";
    }
}
