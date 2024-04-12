package com.raj.orderNow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.raj.orderNow.Entities.User;
import com.raj.orderNow.services.UserService;
import com.raj.orderNow.servicesImpl.UserServiceImpl;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	

	@MutationMapping	
	public User createUser(@Argument String name,@Argument String email, @Argument String phone, @Argument String password) {
		 User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		return userServiceImpl.createUser(user);
		
	}
	
	@QueryMapping
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@QueryMapping
	public User getUser(@Argument int userId) {
		return userService.getUser(userId);
	}
	
	@MutationMapping
	public String deleteUser(int userId) {
		return userService.deleteUser(userId);
	}
}
