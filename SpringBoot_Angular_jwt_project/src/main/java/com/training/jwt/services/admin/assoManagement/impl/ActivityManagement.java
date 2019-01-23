package com.training.jwt.services.admin.assoManagement.impl;

import java.util.List;
import java.util.Optional;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.jwt.entities.ActivityBO;
import com.training.jwt.repository.ActivityRepository;
import com.training.jwt.services.admin.assoManagement.IActivityManagement;

@Service
public class ActivityManagement implements IActivityManagement {

	@Autowired
	ActivityRepository repository;
	
	@Override
	public ActivityBO getActivity(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public ActivityBO saveActivity(ActivityBO activity) {
		if(null == activity.getId()){
			return repository.save(activity);
		}else{
			Optional<ActivityBO> activityOptDB = repository.findById(activity.getId());
			if (activityOptDB.isPresent()){
				ActivityBO actvityDB = activityOptDB.get();
				actvityDB.setDescription(activity.getDescription());
				actvityDB.setInformation(activity.getInformation());
				actvityDB.setStartDate(activity.getStartDate());
				return repository.save(actvityDB);
			}
			else{
				return null;
			}
		}
		
	}

	@Override
	public void deleteActivity(ActivityBO activity) {
		repository.deleteById(activity.getId());

	}

	@Override
	public List<ActivityBO> getActivities() {
		return repository.findAll();
	}

}
