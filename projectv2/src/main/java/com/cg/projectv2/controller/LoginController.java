package com.cg.projectv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.projectv2.model.Address;
import com.cg.projectv2.model.User;
import com.cg.projectv2.service.ILoginServiceImp;

@RestController
@RequestMapping("/login")
public class LoginController 
{
	

	@Autowired
	ILoginServiceImp logservice;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user)
	{
		return logservice.addUser(user);
	}
	
	@DeleteMapping("/remove/{id}")
	public User removeUser(@PathVariable("id") String id)
	{
		User userremove = new User();
		userremove.setUserId(id);
		logservice.removeUser(userremove);
		return userremove;
	}
	
	
}
