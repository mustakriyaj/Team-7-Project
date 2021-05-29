package com.cg.projectv2.repository;

import java.time.LocalDate;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.projectv2.model.Order1;


public interface IOrderRepository extends JpaRepository<Order1,String>{

	
}
