package com.training.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.training.jwt.entities.ActivityBO;

public interface ActivityRepository extends JpaRepository<ActivityBO, Long>, JpaSpecificationExecutor<ActivityBO> {

}
