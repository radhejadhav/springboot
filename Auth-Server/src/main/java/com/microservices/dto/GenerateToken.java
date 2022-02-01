package com.microservices.dto;

import java.util.Base64;

public class GenerateToken {

	public String getToken(TokenRequest tokenRequest) {
		
		String pair = tokenRequest.getUsername()+":"+tokenRequest.getPassword();
		
		byte[] encodedbyte = Base64.getEncoder().encode(pair.getBytes());
		
		String encodedString = new String(encodedbyte);
		
//		getUsernamePassword("Bearer "+encodedString);
		
		return "Basic "+encodedString;
	}
//	public TokenRequest getUsernamePassword(String token) {
//		StringBuffer buffer = new StringBuffer();
//		TokenRequest token = new TokenRequest();
//		
//		byte[] encodedbyte = token.substring(7).getBytes();
//		byte[] decodedbyte = Base64.getDecoder().decode(encodedbyte);
//		
//		char[] chr = new String(decodedbyte).toCharArray();
//		for(char ch:chr) {
//			if(ch ==':') {
//				
//			}
//		}
//		System.out.println(str);
//		
//		return null;
//	}
}
