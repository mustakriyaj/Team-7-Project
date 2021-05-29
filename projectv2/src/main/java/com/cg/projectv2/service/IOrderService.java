package com.cg.projectv2.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.projectv2.model.Order1;

public interface IOrderService {
	public Order1 addOrder(Order1 order1);
	public Order1 updateOrder(Order1 order1);
	public Order1 removeOrder(Order1 order1);
	public Order1 viewOrder(Order1 order1);
//	public List<Order1> viewAllOrders(LocalDate date);
//	public List<Order1> viewAllOrdersByLocation(String location);
//	public List<Order1> viewAllOrderByUserId(String userid);

}
