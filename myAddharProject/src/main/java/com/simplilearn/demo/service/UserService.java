package com.simplilearn.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.demo.entity.User;
import com.simplilearn.demo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	
	// Add user
	
	public User addUser(User u) {
		return repo.save(u);
		}
	
	public List<User> getAllUser(){
		return repo.findAll();
	}
	
	// get User
	
	public User getUserById(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}
		
	}
	
	// update user
	
	public User updateUser(int id, User newUser) {
		if(repo.findById(id).isPresent()) {
			
			User olduser= repo.findById(id).get();
			
			olduser.setName(newUser.getName());
			olduser.setMobile(newUser.getMobile());
			olduser.setAddress(newUser.getAddress());
			olduser.setDob(newUser.getDob());
			olduser.setGender(newUser.getGender());
			olduser.setAction(newUser.getAction());
			olduser.setPassword(newUser.getPassword());
			
			
			
			return repo.save(olduser);
		 }
		else {
			return null;
		  }
	     }
	
	
	//Delete user
	public boolean deleteUser(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		
		else {
			return false;
		}
	}
	public String getUserByUsername(String username) {
		User i =repo.findByUsername(username);
		if(i!=null) {
			return i.getPassword();
		}
		else {
			return null;
		}
		
		
	}

		

}