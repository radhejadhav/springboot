package com.authentication.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.server.dao.LoginUserDao;
import com.authentication.server.entities.MyUser;

@Service
public class AuthUser {
	
	@Autowired
	private LoginUserDao loginUserDao;

	public MyUser addNewUser(MyUser myUser) {
		return this.loginUserDao.save(myUser);
	}
	
	public List<MyUser> getAllUser() {
		return this.loginUserDao.findAll();
	}
}
