package com.training.jwt.services.admin.assoManagement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.jwt.entities.ActivityBO;

public interface IActivityManagement {
	
	ActivityBO getActivity(Long id);
	ActivityBO saveActivity(ActivityBO activity);
	void deleteActivity(ActivityBO activity);
	List<ActivityBO> getActivities(); 

}
