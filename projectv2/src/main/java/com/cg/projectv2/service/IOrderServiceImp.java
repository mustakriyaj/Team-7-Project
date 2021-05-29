package com.cg.projectv2.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.projectv2.model.Customer;
import com.cg.projectv2.model.Order1;
import com.cg.projectv2.model.Product;
import com.cg.projectv2.repository.ICustomerRepository;
import com.cg.projectv2.repository.IOrderRepository;

@Service
public class IOrderServiceImp implements IOrderService
{
	@Autowired
	IOrderRepository repository;
	
	@Override
	public Order1 addOrder(Order1 order1) {
		
		
		Optional<Order1> findById = repository.findById(order1.getOrdId());
		if(!findById.isPresent()) {
			return repository.save(order1);
		}
		
		return null;
	}

	@Override
	public Order1 updateOrder(Order1 order1) {
		Optional<Order1> findById = repository.findById(order1.getOrdId());
		if(findById.isPresent())
		{
			order1.setOrdStatus(order1.getOrdStatus());
			order1.setOrdDate(order1.getOrdDate());
			order1.setCustomer(order1.getCustomer());
			order1.setProducts(order1.getProducts());
			order1.setAddress(order1.getAddress());
			repository.save(order1);
		}
		return null;
	}

	@Override
	public Order1 removeOrder(Order1 order1) {
		// TODO Auto-generated method stub
		Optional<Order1> findById = repository.findById(order1.getOrdId());
		if(findById.isPresent()) {
			Order1 c = findById.get();
			repository.delete(order1);
			return c;
			}
	

		return null;
	}

	@Override
	public Order1 viewOrder(Order1 order1) {
		// TODO Auto-generated method stub
		Optional<Order1> findById = repository.findById(order1.getOrdId());
		if(findById.isPresent()) {
			return findById.get();
		}
		
		return null;
	}

//	@Override
//	public List<Order1> viewAllOrders(LocalDate date) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Order1> viewAllOrdersByLocation(String location) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Order1> viewAllOrderByUserId(String userid) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
