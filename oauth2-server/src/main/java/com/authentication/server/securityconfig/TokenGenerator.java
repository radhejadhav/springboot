package com.authentication.server.securityconfig;

import org.springframework.stereotype.Component;

import java.util.Base64;

public class TokenGenerator {

    public static String encode(String username, String password){
        String pair = new String(username+":"+password);

        byte[] byt = pair.getBytes();
        String encoded = Base64.getEncoder().encodeToString(byt);
        return "Bearer "+encoded;
    }

    public static String decode(String token){
        byte[] byt = Base64.getDecoder().decode(token.substring(7));
        String str1 = new String(byt);
        StringBuilder builder = new StringBuilder();
        for(char ch:str1.toCharArray()){
            if(ch==':'){
                break;
            }
            builder.append(ch);
        }
        System.out.println(builder.toString());
        return builder.toString();
    }
}
