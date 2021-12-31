package com.microservices.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.microservices.services.AuthUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private AuthUserService authUserService;
	
	@Autowired
	private PreAuthFilter preAuthFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
	
		http
				.csrf().disable()
				.cors().disable()
				.authorizeRequests()
				.antMatchers("/user/admin").hasAnyAuthority("ADMIN")
				.antMatchers("/user/user").hasAnyAuthority("USER")
				.antMatchers(HttpMethod.POST, "/user/signup").permitAll()
				.anyRequest().authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.httpBasic()
				.and()
				.addFilterBefore(preAuthFilter, UsernamePasswordAuthenticationFilter.class);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth
			.userDetailsService(authUserService)
			.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder  passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
