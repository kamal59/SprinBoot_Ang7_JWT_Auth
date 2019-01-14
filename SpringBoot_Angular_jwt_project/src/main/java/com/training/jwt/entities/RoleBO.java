package com.training.jwt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RoleBO {
	@Id @GeneratedValue
	private Long id;
	private String roleName;
	
	public RoleBO() {
	}
	public RoleBO(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
