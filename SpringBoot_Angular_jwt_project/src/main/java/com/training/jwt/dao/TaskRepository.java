package com.training.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.jwt.entities.Task;

public interface TaskRepository  extends JpaRepository<Task, Long>{

}
