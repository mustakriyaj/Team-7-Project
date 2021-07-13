package com.cg.onlineshopping_application.service;

import java.util.List;

import com.cg.onlineshopping_application.dto.Order1Dto;
import com.cg.onlineshopping_application.entity.Order1;
import com.cg.onlineshopping_application.exception.AddressNotFoundException;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.OrderIdException;
import com.cg.onlineshopping_application.exception.ProductNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateOrderException;

public interface IOrderService {
	public Order1 addOrder(Order1Dto order1Dto)throws ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, ProductNotFoundException  ;
	public Order1 updateOrder(Order1Dto order1Dto)throws OrderIdException, ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, ProductNotFoundException;
	public boolean removeOrder(Integer ordId)throws OrderIdException;
	public Order1 viewOrder(Integer ordId)throws OrderIdException;
	public List<Order1> viewAllOrdersByLocation(Integer addressId) throws AddressNotFoundException;
    public List<Order1> viewAllOrderByCustomerId(Integer customerId) throws CustomerNotFoundException;

}