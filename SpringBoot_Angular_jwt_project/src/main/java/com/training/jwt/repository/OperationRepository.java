package com.training.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.jwt.entities.OperationBO;

public interface OperationRepository extends JpaRepository<OperationBO, Long> {

}
