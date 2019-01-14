package com.training.jwt.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.jwt.entities.UserBO;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
			UserBO user = null;
			/**
			 * si les donneés sont envoyées en format 3wUrLEncoded
			 */
			//String username = request.getParameter("username");
			try {
				user = new ObjectMapper().readValue(request.getInputStream(), UserBO.class);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			} 
			System.out.println("*****************************");
			System.out.println("username :"+ user.getUsername());
			System.out.println("password :"+ user.getPassword());
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		//get user info after authentication 
		User springUser = (User)authResult.getPrincipal();
		String jwtToken = Jwts.builder()
				.setSubject(springUser.getUsername())
				.setExpiration(new
						Date(System.currentTimeMillis()+SecuityConstants.EXPIRATION_DATE))
				.signWith(SignatureAlgorithm.HS256, SecuityConstants.SECRET)
				.claim("roles", springUser.getAuthorities())
				.compact();
		response.addHeader(SecuityConstants.HEADER_STRING, SecuityConstants.TOKEN_PREFEX+jwtToken);
	}

}
