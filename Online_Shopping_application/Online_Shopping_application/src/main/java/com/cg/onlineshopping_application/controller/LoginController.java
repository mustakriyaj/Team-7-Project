package com.cg.onlineshopping_application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping_application.dto.LoginDto;
import com.cg.onlineshopping_application.dto.SuccessMessageDto;
import com.cg.onlineshopping_application.entity.User;
import com.cg.onlineshopping_application.exception.UserIdException;
import com.cg.onlineshopping_application.exception.ValidateUserException;
import com.cg.onlineshopping_application.service.ILoginServiceImp;
import com.cg.onlineshopping_application.util.ShoppingConstants;

@RestController
@RequestMapping("/login")
public class LoginController 
{
	

	@Autowired
	ILoginServiceImp loginService;
	
	@PostMapping("/adduser")
	public SuccessMessageDto addUser(@RequestBody LoginDto loginDto) throws ValidateUserException
	{
		User user= loginService.addUser(loginDto);
		return new SuccessMessageDto(ShoppingConstants.USER_ADDED+ user.getUserId());
	}
	
	@DeleteMapping("/removeuser/{id}")
	public SuccessMessageDto removeAddress(@PathVariable("id") Integer userId) throws UserIdException
	{
		loginService.removeUser(userId);
		return new SuccessMessageDto(ShoppingConstants.USER_REMOVED);
	}
	
	
}
