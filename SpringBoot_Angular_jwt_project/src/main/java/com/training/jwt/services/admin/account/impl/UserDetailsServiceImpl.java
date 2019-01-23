package com.training.jwt.services.admin.account.impl;

import java.util.ArrayList;
import java.util.Collection;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




import com.training.jwt.entities.UserBO;
import com.training.jwt.services.admin.account.AccountService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserBO userBO = accountService.findUserByUserName(userName);
		if(userBO == null) throw new UsernameNotFoundException("user not found");
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		userBO.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		return new User(userBO.getUsername(), userBO.getPassword(),authorities);
	}

	

}
