package com.microservices.dto;

import java.util.Base64;

public class GenerateToken {

	public String getToken(TokenRequest tokenRequest) {
		
		String pair = tokenRequest.getUsername()+":"+tokenRequest.getPassword();
		
		byte[] encodedbyte = Base64.getEncoder().encode(pair.getBytes());
		
		String encodedString = new String(encodedbyte);
		
		return "Basic "+encodedString;
	}
}
