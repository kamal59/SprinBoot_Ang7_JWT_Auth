package com.training.jwt.services.admin.assoManagement.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javassist.NotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.jwt.entities.ActivityBO;
import com.training.jwt.repository.ActivityRepository;
import com.training.jwt.services.admin.assoManagement.IActivityManagement;
import com.training.jwt.services.admin.assoManagement.impl.ActivityManagement;

@RunWith(MockitoJUnitRunner.class)
public class ActivityManagementTest {

	@InjectMocks 
	private ActivityManagement service;
	
	@Mock
	private ActivityRepository repository;
	


	@Test
	public void testaddActivity() {
		ActivityBO act = new ActivityBO();
		act.setDescription("desc");
		act.setInformation("info");
		act.setStartDate(new Date());
		//when(repository.add(Mockito.any(ActivityBO.class))).thenReturn(act);
		ActivityBO actDB = service.addActivity(act);
		assertEquals("desc", actDB.getDescription());
	}

	

}
