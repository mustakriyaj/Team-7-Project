package com.cg.projectv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.projectv2.model.User;

public interface ILoginRepository extends JpaRepository<User,String>{

//	public User addUser(User user);
//	public User removeUser(User user);
//	public User validateUser(User user);
//	public User signOut(User user);
}
