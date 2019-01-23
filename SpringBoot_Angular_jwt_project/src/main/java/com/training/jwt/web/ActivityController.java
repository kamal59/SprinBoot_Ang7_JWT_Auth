package com.training.jwt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		return service.getActivities();
	}
	
	@GetMapping("/activityDetails")
	public ActivityBO getActivityDetails(@RequestParam String id){
		return service.getActivity(Long.valueOf(id));
	}
	
	@GetMapping("/saveActivity")
	public ActivityBO saveActivity(@RequestBody ActivityBO activity){
		return service.saveActivity(activity);
		
	}

}
