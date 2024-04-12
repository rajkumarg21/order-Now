package com.raj.orderNow.services;

import java.util.List;

import com.raj.orderNow.Entities.User;



public interface UserService  {
	public List<User> getUsers();
	public User getUser(Integer userId);
	public User updateUser(User user);
	public String deleteUser(Integer userId);
	
	

}
