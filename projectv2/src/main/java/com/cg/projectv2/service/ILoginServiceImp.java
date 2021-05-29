package com.cg.projectv2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.projectv2.model.Customer;
import com.cg.projectv2.model.User;
import com.cg.projectv2.repository.ILoginRepository;

@Service
public class ILoginServiceImp implements ILoginService
{
	@Autowired
	ILoginRepository repository;
	
	@Override
	public User addUser(User user) {

		Optional<User> findById = repository.findById(user.getUserId());
		if(!findById.isPresent()) {
			return repository.save(user);
		}
		return null;
	}

	@Override
	public User removeUser(User user) {

		Optional<User> findById = repository.findById(user.getUserId());
		if(findById.isPresent()) {
			User c = findById.get();
			repository.delete(user);
			return c;
			}
		return null;
	}

//	@Override
//	public User validateUser(User user) {
//
//		return null;
//	}
//
//	@Override
//	public User signOut(User user) {
//
//		return null;
//	}

}
