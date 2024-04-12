package com.raj.orderNow.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.orderNow.Entities.User;
import com.raj.orderNow.Repository.UserRepository;
import com.raj.orderNow.helper.ExceptionHelper;
import com.raj.orderNow.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository usrRepository;
	
	// create new user
	public User createUser(User user)
	
	{
		return usrRepository.save(user);
	}

	// get all user
	@Override
	public List<User> getUsers() {
		
		return usrRepository.findAll();
	}

	// get user by id
	@Override
	public User getUser(Integer userId) {
		
		User user=usrRepository.findById(userId).orElseThrow(ExceptionHelper:: throwResourceNotFoundException);
		 return user;
	}

	// update user
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
 
	// delete user
	
	@Override
	public String deleteUser(Integer userId) {
		User user=usrRepository.findById(userId).orElseThrow(ExceptionHelper:: throwResourceNotFoundException);
		 usrRepository.delete(user);
		 return "user deleted ! ";
		
	}
	
	
}
