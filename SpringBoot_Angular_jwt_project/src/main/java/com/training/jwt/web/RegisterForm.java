package com.training.jwt.web;

public class RegisterForm {
	private String username;
	private String password;
	private String confirmedpassword;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmedpassword() {
		return confirmedpassword;
	}
	public void setConfirmedpassword(String confirmedpassword) {
		this.confirmedpassword = confirmedpassword;
	}

}
