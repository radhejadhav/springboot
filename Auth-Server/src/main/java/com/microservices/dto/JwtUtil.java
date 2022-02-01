package com.microservices.dto;


import java.security.Key;
import java.sql.Time;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	String secrete = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
	
	Key myKay = new SecretKeySpec(Base64.getDecoder().decode(secrete.getBytes()),
			SignatureAlgorithm.HS256.getJcaName());

	public String createToken(TokenRequest tokenRequest) {
		try {
			String token = Jwts.builder()
					.claim("username", tokenRequest.getUsername())
					.claim("password", tokenRequest.getPassword())
					.setSubject("radheshyam")
					.setIssuedAt(Date.from(Instant.now()))
					.setExpiration(new Date(System.currentTimeMillis()+(4 * 60 * 60 * 1000)))
					.signWith(myKay)
					.compact();
			return "Bearer "+token;
		}catch (Exception e) {

			throw new RuntimeException(e.getMessage());
		}
	}
	
	public TokenRequest validateToken(String token) {
	
		TokenRequest tokenRequest = new TokenRequest();
		try {
			Jws<Claims> jws = Jwts.parserBuilder()
					.setSigningKey(myKay)
						.build()
						.parseClaimsJws(token);
			tokenRequest.setUsername(jws.getBody().get("username").toString());
			tokenRequest.setPassword(jws.getBody().get("password").toString());
			return tokenRequest;
		}catch (Exception e) {

			throw new RuntimeException(e.getMessage());
		}
	}
}
