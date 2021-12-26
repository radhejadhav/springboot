package com.authentication.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    UserDetails user = User
            .withUsername("radhejadhav")
            .password(new BCryptPasswordEncoder().encode("radhe123"))
            .roles("ADMIN")
            .build();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(user.getUsername().equals(username)) {
            return this.user;
        }else {
            throw new UsernameNotFoundException("Username not found !");
        }
    }
}
