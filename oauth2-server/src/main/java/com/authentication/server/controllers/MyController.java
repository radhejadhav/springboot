package com.authentication.server.controllers;

import com.authentication.server.entities.MyUser;
import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/user")
public class MyController {

    public String getUser(){
        MyUser user = new MyUser();
        user.setUsername("radhejadhav");
        user.setPassword("radhe123");
        user.setRoles();

        return "Hello";
    }
}
