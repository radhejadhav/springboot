package com.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.entities.AuthUser;

public interface AuthUserDao extends JpaRepository<AuthUser, Long> {

	public AuthUser findByUsername(String username);
}
