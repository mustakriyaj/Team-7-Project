package com.cg.projectv2.repository;

import java.time.LocalDate;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.projectv2.model.Order1;


public interface IOrderRepository extends JpaRepository<Order1,String>{

	/*public Order addOrder(Order order);
	public Order updateOrder(Order order);
	public Order removeOrder(Order order);
	public Order viewOrder(Order order);
	public List<Order> viewAllOrders(LocalDate date);
	public List<Order> viewAllOrdersByLocation(String location);
	public List<Order> viewAllOrderByUserId(String userid);
	*/
}
