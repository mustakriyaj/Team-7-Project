package com.cg.onlineshopping_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping_application.entity.Address;


public interface IAddressRepository extends JpaRepository<Address,Integer>{
	
	 
}
