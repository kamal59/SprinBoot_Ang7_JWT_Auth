package com.training.jwt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.jwt.entities.ActivityBO;
import com.training.jwt.services.admin.assoManagement.IActivityManagement;

@RestController
@RequestMapping("/activities")
public class ActivityController {
	
	@Autowired
	IActivityManagement service;
	
	
	@GetMapping("/searchActivities")
	public List<ActivityBO> getActivities(){
		System.out.println("in search activities api");
		return service.getActivities();
	}
	
	@GetMapping("/activityDetails")
	public ActivityBO getActivityDetails(@RequestParam String id){
		System.out.println("in activity details api");
		return service.getActivity(Long.valueOf(id));
	}
	
	@PostMapping("/saveActivity")
	public ActivityBO saveActivity(@RequestBody ActivityBO activity){
		System.out.println("in save activity api");
		return service.saveActivity(activity);
		
	}

}
