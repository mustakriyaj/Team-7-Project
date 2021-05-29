package com.cg.projectv2.service;

import com.cg.projectv2.model.User;

public interface ILoginService {

	public User addUser(User user);
	public User removeUser(User user);
//	public User validateUser(User user);
//	public User signOut(User user);
}
