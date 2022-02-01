package com.authentication.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authentication.server.dao.LoginUserDao;
import com.authentication.server.entities.MyUser;

@Service
public class MyUserDetailService implements UserDetailsService {

	
	@Autowired
	private LoginUserDao loginUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	UserDetails user = new MyUser();
    	try {
    		user = this.loginUserDao.findByUsername(username);
    		System.out.println(user);
    	}catch (Exception e) {
    		throw new RuntimeException(e.getMessage()); 
    	}
    	return user;
    }
}
