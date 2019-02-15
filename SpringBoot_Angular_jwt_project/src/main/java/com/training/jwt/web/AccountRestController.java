package com.training.jwt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.jwt.entities.UserBO;
import com.training.jwt.services.admin.account.AccountService;

@RestController
public class AccountRestController {

	@Autowired
	private AccountService service;
	
	@PostMapping("/register")
	public UserBO register(@RequestBody RegisterForm userForm){
		if(!userForm.getPassword().equals(userForm.getConfirmedpassword()))
		throw new RuntimeException("error password");
		UserBO dbUser = service.findUserByUserName(userForm.getUsername());
		if(dbUser != null) throw new RuntimeException("user already exists");
		UserBO user = new UserBO();
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		service.saveUser(user);
		service.addUserRole(userForm.getUsername(), "USER");
		return user;
	}
	
	@GetMapping("/getUsersList")
	public List<UserBO> getUserList(){
		return service.getUsersList();
	}
}
