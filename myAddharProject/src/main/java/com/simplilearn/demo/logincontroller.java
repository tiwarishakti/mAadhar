package com.simplilearn.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.demo.entity.User;
import com.simplilearn.demo.service.UserService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/AadharApp/citizens/login")
public class logincontroller {
	@Autowired
	private UserService service;
	@PostMapping("/loginapi")
	public void signup(@RequestBody User u) {
		String username1=u.getUsername();
		String password=u.getPassword();
		
		String pass =service.getUserByUsername(username1) ;
		if(pass==password) {
			System.out.println("login success");
		}
		
		
	}

}
