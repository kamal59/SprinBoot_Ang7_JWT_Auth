package com.training.jwt.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class UserBO {
	

	@Id @GeneratedValue
	private Long id;
	@Column(unique=true)
	private String username; 
	private String password;
	@ManyToMany(fetch=FetchType.EAGER)
	private List<RoleBO> roles;

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

	public List<RoleBO> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleBO> roles) {
		this.roles = roles;
	}
}