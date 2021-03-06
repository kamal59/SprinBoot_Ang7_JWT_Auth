package com.training.jwt;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.training.jwt.entities.ActivityBO;
import com.training.jwt.entities.RoleBO;
import com.training.jwt.entities.Task;
import com.training.jwt.entities.UserBO;
import com.training.jwt.repository.ActivityRepository;
import com.training.jwt.repository.TaskRepository;
import com.training.jwt.services.admin.account.AccountService;
import com.training.jwt.services.admin.assoManagement.IActivityManagement;


@SpringBootApplication
public class SpringBootAngularJwtProjectApplication implements CommandLineRunner{

	@Autowired
	TaskRepository repository;
	
	@Autowired
	IActivityManagement activityMgt; 
	
	@Autowired AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularJwtProjectApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		accountService.saveUser(new UserBO(null,"admin","1234","066666666", "admin@gmail.com","admin","admin", null));
		accountService.saveUser(new UserBO(null,"user","1234","077777777", "admin@gmail.com", "user", "user", null));
		accountService.saveRole(new RoleBO(null, "ADMIN"));
		accountService.saveRole(new RoleBO(null, "USER"));
		accountService.addUserRole("admin", "ADMIN");
		accountService.addUserRole("admin", "USER");
		accountService.addUserRole("user", "USER");
		
		Stream.of("T1","T2","T3").forEach(t->{
			repository.save(new Task(null, t));
		});		
		repository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
		});
		
		System.out.println("--------------------------------------");
		ActivityBO act = activityMgt.saveActivity(new ActivityBO(new Date(), "desc1", "info1"));
		System.out.println(act.toString());
		
	}
	
	@Bean
	public BCryptPasswordEncoder getBc (){
		return new BCryptPasswordEncoder();
	}

	
}

