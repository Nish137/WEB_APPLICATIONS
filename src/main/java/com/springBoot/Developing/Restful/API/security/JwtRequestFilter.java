package com.springBoot.Developing.Restful.API.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	 @Autowired
	 private JwtUtil jwtUtil;
	 
	 
	 
	 public JwtRequestFilter() {
		super();
		// TODO Auto-generated constructor stub
	}


	public JwtRequestFilter(JwtUtil jwtUtil) {
		 this.jwtUtil=jwtUtil;
	 }


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String authorizationHeader = request.getHeader("Authorization");
       String username = null;
       String jwt = null;

       if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
           jwt = authorizationHeader.substring(7);
           username = jwtUtil.extractUsername(jwt);
       }
       if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
           if (jwtUtil.validateToken(jwt, username)) {
               UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                       username, null, new ArrayList<>());
               authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               SecurityContextHolder.getContext().setAuthentication(authenticationToken);
           }
	}
       
       filterChain.doFilter(request, response);
	
	}

}
