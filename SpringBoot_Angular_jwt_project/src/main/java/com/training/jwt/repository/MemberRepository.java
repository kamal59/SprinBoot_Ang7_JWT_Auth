package com.training.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.training.jwt.entities.MemberBO;

public interface MemberRepository extends JpaRepository<MemberBO, Long>, JpaSpecificationExecutor<MemberBO>{
	
}