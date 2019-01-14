package com.training.jwt.security;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class SecurityConfigWithout extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; // faut déclarer le bean dans l'application
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// se connecter avec des utilisateurs en dure.
		/*auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("admin").password("1234").roles("ADMIN", "USER")
		.and()
		.withUser("user").password("user").roles("USER");*/
		
		/**
		 * Authentification with user in DB, 
		 */
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder)
		;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//désactiver la génération du csrf token. suppression du champs (<input hidden name csrfToken ="vkjdk")  
		http.csrf().disable();
		
				
		//use login page for login (page personnalisée)
		//http.formLogin().loginPage("/login");
		
		//Use spring security default login page 
		http.formLogin();
		
		
		//not need authentication to access to login && register pages
		http.authorizeRequests(). // without sessionManager use http.authorizeRequests... 
		antMatchers( "/login/**", "/register/**")
		.permitAll();
		
		//Only user with "ADMIN" role is authorized to do "POST" action with /tasks** url
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/tasks/**").hasAuthority("ADMIN") 
		
		//toutes les requettes necessitent une authentification
		.anyRequest().authenticated();
	}
}
