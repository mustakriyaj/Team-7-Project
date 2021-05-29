package com.cg.projectv2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.projectv2.dto.AddressDto;
import com.cg.projectv2.dto.LoginDto;
import com.cg.projectv2.exception.AddressIdException;
import com.cg.projectv2.exception.CustomerNotFoundException;
import com.cg.projectv2.exception.UserIdException;
import com.cg.projectv2.exception.ValidateAddressException;
import com.cg.projectv2.exception.ValidateCustomerException;
import com.cg.projectv2.exception.ValidateUserException;
import com.cg.projectv2.model.Address;
import com.cg.projectv2.model.Customer;
import com.cg.projectv2.model.User;
import com.cg.projectv2.repository.ILoginRepository;
import com.cg.projectv2.util.ShoppingConstants;

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
