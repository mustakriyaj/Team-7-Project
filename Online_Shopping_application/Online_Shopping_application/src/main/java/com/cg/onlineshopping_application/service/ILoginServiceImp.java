package com.cg.onlineshopping_application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping_application.dto.LoginDto;
import com.cg.onlineshopping_application.entity.User;
import com.cg.onlineshopping_application.exception.UserIdException;
import com.cg.onlineshopping_application.exception.ValidateUserException;
import com.cg.onlineshopping_application.repository.ILoginRepository;
import com.cg.onlineshopping_application.util.ShoppingConstants;

@Service
public class ILoginServiceImp implements ILoginService
{
	@Autowired
	ILoginRepository userDao;

	
	public User addUser(LoginDto loginDto) throws ValidateUserException {
		validateUser(loginDto);
		User user = new User();
		user.setUserEmail(loginDto.getUserEmail());
		user.setPassword(loginDto.getPassword());
		user.setRole(loginDto.getRole());
		return userDao.save(user);
	}
	
	public boolean validateUser(LoginDto loginDto) throws ValidateUserException {
		if (!loginDto.getUserEmail().matches(ShoppingConstants.USEREMAIL_PATTERN))
			throw new ValidateUserException(ShoppingConstants.USEREMAIL_CANNOT_BE_EMPTY);
		if (!loginDto.getPassword().matches(ShoppingConstants.PASSWORD_PATTERN))
			throw new ValidateUserException(ShoppingConstants.PASSWORD_NOT_STRONG);
		if (!loginDto.getRole().matches("USER") && !loginDto.getRole().matches("ADMIN"))
			throw new ValidateUserException(ShoppingConstants.ROLE_INVALID);
		return true;
	}

	@Override
	public boolean removeUser(Integer userId) throws UserIdException {
		
		Optional<User> optuser = userDao.findById(userId);

		if (!optuser.isPresent()) {
			throw new UserIdException(ShoppingConstants.USER_NOT_FOUND);

		}
		userDao.delete(optuser.get());
		return true;
	}
	
	
	

}
