package com.training.jwt.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;




import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;




import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTAuthorizationFilter extends OncePerRequestFilter {



	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", 
				"Origin, Accept, X-Requested-With, Content-Type, "
				+ "Access-Control-Request-Method, "
				+ "Access-Control-Request-Headers, "
				+"Authorization");
		response.addHeader("Access-Control-Expose-Headers", 
				"Access-Control-Allow-Origin, "
				+ "Access-Control-Allow-Credentials, "
				+"Authorization");
		String jwt = request.getHeader(SecuityConstants.HEADER_STRING);
		//a chaque action le client envoie 2 requettes 1ere et de type "Option" 
		//( requette de vérification ) => on neglige cette requette et on passe au suivante
		
		if(request.getMethod().equals("OPTIONS")){
			response.setStatus(HttpServletResponse.SC_OK);
		}else {
			if(jwt == null || !jwt.startsWith(SecuityConstants.TOKEN_PREFEX)){
				filterChain.doFilter(request, response);
				return;
			}
			Claims claims = Jwts.parser() // contenu du token
					.setSigningKey(SecuityConstants.SECRET)
					.parseClaimsJws(jwt.replace(SecuityConstants.TOKEN_PREFEX, ""))
					.getBody();
			String username = claims.getSubject();
			ArrayList<Map<String, String>> roles = (ArrayList<Map<String,String>>) claims.get("roles");
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			roles.forEach(r->{
				authorities.add(new SimpleGrantedAuthority(r.get("authority")));
			});
			UsernamePasswordAuthenticationToken authenticatedUser = 
					new UsernamePasswordAuthenticationToken(username, null,authorities);
			SecurityContextHolder.getContext().setAuthentication(authenticatedUser); //charger l'utilisateur authentifié dans le context de spring
			filterChain.doFilter(request, response);
		}
		
	}

}
