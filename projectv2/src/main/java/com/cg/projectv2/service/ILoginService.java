package com.cg.projectv2.service;

import com.cg.projectv2.dto.LoginDto;
import com.cg.projectv2.exception.UserIdException;
import com.cg.projectv2.exception.ValidateUserException;
import com.cg.projectv2.model.User;

public interface ILoginService {

	public User addUser(LoginDto loginDto) throws ValidateUserException;
	public boolean removeUser(Integer userId)throws UserIdException;
//	public User validateUser(User user);
//	public User signOut(User user);
}
