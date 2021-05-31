package com.cg.onlineshopping_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping_application.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer>{

}
