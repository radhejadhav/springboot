package com.microservices.zuulApiGateway.configurations;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
//@Order(1)
public class AuthFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		request.getSession().invalidate();;
		System.out.println(request.getMethod());
		request.getParameterNames();
		System.out.println(request.isRequestedSessionIdFromCookie());
		
		filterChain.doFilter(request, response);
		
	}

	
	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		filterChain.doFilter(request, response);
//	}

}
