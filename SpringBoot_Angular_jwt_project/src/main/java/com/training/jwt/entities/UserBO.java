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
	private String email;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	@ManyToMany(fetch=FetchType.EAGER)
	private List<RoleBO> roles;


}