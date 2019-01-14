package com.training.jwt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.jwt.dao.TaskRepository;
import com.training.jwt.entities.Task;

@RestController
public class TaskRestController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/tasks")
	public List<Task> getTaskList(){
		return taskRepository.findAll();
	}
	
	@PostMapping("/tasks")
	public Task save(@RequestBody Task task){
		return taskRepository.save(task);
	}
}
