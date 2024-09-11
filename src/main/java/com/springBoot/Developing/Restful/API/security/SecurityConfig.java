package com.springBoot.Developing.Restful.API.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
private JwtRequestFilter jwtRequestFilter;
	
	public  SecurityConfig(JwtRequestFilter jwtRequestFilter) {
		this.jwtRequestFilter=jwtRequestFilter;
	}
	
	@Bean 
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
	  throws Exception {
		http.csrf( csrf -> csrf .disable() )// Disable CSRF for simplicity
	  .authorizeHttpRequests(authorize -> authorize.requestMatchers("/login").permitAll()
	  .anyRequest()
	  .authenticated())
	  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);// All other requests need authentication
	http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
 