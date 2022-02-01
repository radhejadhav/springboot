package com.microservices.security.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.filter.OncePerRequestFilter;

import com.microservices.dto.JwtUtil;
import com.microservices.dto.TokenRequest;
import com.microservices.services.AuthUserService;

@Component
public class PreAuthFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthUserService authUserService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String headers = request.getHeader("Authorization");
		
		try {
			if(headers != null) {
				
				TokenRequest tokenRequest = this.jwtUtil.validateToken(headers.substring(7));
				UserDetails user = this.authUserService.loadUserByUsername(tokenRequest.getUsername());
				
				SecurityContext context = SecurityContextHolder.getContext();
				
				UsernamePasswordAuthenticationToken authentication = 
						new UsernamePasswordAuthenticationToken(tokenRequest.getUsername(), tokenRequest.getPassword(), user.getAuthorities());
				
				System.out.println("Is Authenticated: "+authentication.isAuthenticated());
				
				if(authentication.isAuthenticated()) {
					context.setAuthentication(authentication);
				}else{
					response.setStatus(HttpStatus.BAD_GATEWAY.value());
				}
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		filterChain.doFilter(request, response);
	}

}
