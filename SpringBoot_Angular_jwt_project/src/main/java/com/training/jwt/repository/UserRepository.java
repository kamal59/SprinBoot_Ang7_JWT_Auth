package com.training.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.jwt.entities.UserBO;

public interface UserRepository extends JpaRepository<UserBO, Long> {
	public UserBO findByUsername(String username); 

}
