package com.cg.projectv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.projectv2.model.Address;

public interface IAddressRepository extends JpaRepository<Address,Integer>{
	
	 
}
