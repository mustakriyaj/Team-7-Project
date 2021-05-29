package com.cg.projectv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.projectv2.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer>{

}
