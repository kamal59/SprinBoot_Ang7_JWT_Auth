package com.training.jwt.services.admin.account;

import com.training.jwt.entities.RoleBO;
import com.training.jwt.entities.UserBO;

public interface AccountService {
	public UserBO saveUser(UserBO user);
	public RoleBO saveRole(RoleBO role);
	public void addUserRole (String userName, String role);
	public UserBO findUserByUserName(String userName);
}