package com.authentication.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.server.entities.MyUser;

public interface LoginUserDao extends JpaRepository<MyUser, Long> {

	public MyUser findByUsername(String username);
}
