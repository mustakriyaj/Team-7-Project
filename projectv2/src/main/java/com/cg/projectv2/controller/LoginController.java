package com.cg.projectv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.projectv2.dto.AddressDto;
import com.cg.projectv2.dto.LoginDto;
import com.cg.projectv2.dto.SuccessMessageDto;
import com.cg.projectv2.exception.CustomerNotFoundException;
import com.cg.projectv2.exception.UserIdException;
import com.cg.projectv2.exception.ValidateAddressException;
import com.cg.projectv2.exception.ValidateUserException;
import com.cg.projectv2.model.Address;
import com.cg.projectv2.model.User;
import com.cg.projectv2.service.ILoginServiceImp;
import com.cg.projectv2.util.ShoppingConstants;

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
