package com.authentication.server.controllers;

import com.authentication.server.entities.MyUser;
import com.authentication.server.securityconfig.TokenGenerator;
import com.authentication.server.services.MyUserDetailService;
import com.authentication.server.userDto.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping()
public class MyController {

    @PostMapping("/token")
    public String token(@RequestBody UserLogin userLogin){

        return TokenGenerator.encode(userLogin.getUsername(),userLogin.getPassword());
    }

    @GetMapping("/user")
    public String getUser(){
//        return this.myUserDetailService.loadUserByUsername("radhejadhav");
        return "hello Admin";
    }
}
