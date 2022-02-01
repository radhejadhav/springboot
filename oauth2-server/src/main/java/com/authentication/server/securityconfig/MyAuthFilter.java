//package com.authentication.server.securityconfig;
//
//import com.authentication.server.services.MyUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Base64;
//
//@Component
//public class MyAuthFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private MyUserDetailService myUserDetailService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String header = request.getHeader("Authorization");
//        System.out.println(header);
//        byte[] byt = Base64.getDecoder().decode(header.substring(7));
//        String str1 = new String(byt);
//        StringBuilder builder = new StringBuilder();
//        for(char ch:str1.toCharArray()){
//            if(ch==':'){
//                break;
//            }
//            builder.append(ch);
//        }
//        System.out.println(builder.toString());
//
//        UserDetails userDetails = myUserDetailService.loadUserByUsername(builder.toString());
//
//        if(builder.toString() !=null && SecurityContextHolder.getContext().getAuthentication()==null){
//            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,userDetails.getAuthorities());
//            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//        }else {
//            System.out.println("bad request");
//        }
//
////        request.authenticate(response);
//
//        filterChain.doFilter(request,response);
//    }
//}
