//package com.microservices.zuulApiGateway.configurations;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//@Configuration
//public class CommonFilter extends OncePerRequestFilter {
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		filterChain.doFilter(request, response);
//	}
////	@Override
////	protected boolean shouldNotFilterErrorDispatch() {
////		// TODO Auto-generated method stub
////		return false;
////	}
////
////	@Override
////	protected boolean shouldNotFilterAsyncDispatch() {
////		// TODO Auto-generated method stub
////		return false;
////	}
//}
