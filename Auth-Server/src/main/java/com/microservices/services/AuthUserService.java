package com.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservices.dao.AuthUserDao;
import com.microservices.entities.AuthUser;

@Service
public class AuthUserService implements UserDetailsService {

	@Autowired
	private AuthUserDao authUserDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails user = new AuthUser();
		
		try {
			user = this.authUserDao.findByUsername(username);
			
			if(user!=null) {
				return user;
			}else {
				throw new RuntimeException("Username Not Found "+username);
			}
		}catch(Exception e) {
			throw new RuntimeException("Username Not Found "+username);
		}
	}
	
	public UserDetails addNewUser(AuthUser authUser) {
		
		authUser.setPassword(new BCryptPasswordEncoder().encode(authUser.getPassword()));
		return this.authUserDao.save(authUser);
	}

}
