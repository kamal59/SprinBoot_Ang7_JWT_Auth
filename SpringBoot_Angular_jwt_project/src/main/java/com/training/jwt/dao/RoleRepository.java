package com.training.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.jwt.entities.RoleBO;

public interface RoleRepository extends JpaRepository<RoleBO, Long> {
	public RoleBO findByRoleName(String roleName);

}
