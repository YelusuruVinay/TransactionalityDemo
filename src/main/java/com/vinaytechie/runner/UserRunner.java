package com.vinaytechie.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.vinaytechie.model.User;
import com.vinaytechie.service.UserService;

@Component
public class UserRunner implements CommandLineRunner {
	@Autowired
	UserService userService;

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try {
		User user1 = new User("Peter", "Ops", 1200L);
		User user2 = new User("rAJ", "tech", 12009L);
		User user3 = new User("vIN VIRAT", "TECH", 140000L);
		User user4 = new User("vik", "Ops", 1300000L);
		userService.insert(Arrays.asList(user1, user2, user3, user4));
		
		}
		catch (RuntimeException exception) {
			// TODO: handle exception
			System.out.println("Exception!--------"+exception.getMessage());
		}
		System.out.println("retrive users---------------------" + userService.getUsers());
	}

}
