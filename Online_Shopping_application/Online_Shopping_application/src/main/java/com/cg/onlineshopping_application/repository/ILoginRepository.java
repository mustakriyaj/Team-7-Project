package com.cg.onlineshopping_application.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping_application.entity.User;

public interface ILoginRepository extends JpaRepository<User,Integer>{

}
