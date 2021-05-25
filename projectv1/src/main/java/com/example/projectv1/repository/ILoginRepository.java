package com.example.projectv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectv1.model.User;

public interface ILoginRepository extends JpaRepository<User,String> {

	public User addUser(User user);
	public User removeUser(User user);
	public User validateUser(User user);
	public User signOut(User user);
}
