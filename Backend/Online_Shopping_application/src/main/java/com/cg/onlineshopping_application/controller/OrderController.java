package com.cg.onlineshopping_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping_application.dto.Order1Dto;
import com.cg.onlineshopping_application.dto.SuccessMessageDto;
import com.cg.onlineshopping_application.entity.Order1;
import com.cg.onlineshopping_application.exception.AddressNotFoundException;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.OrderIdException;
import com.cg.onlineshopping_application.exception.ProductNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateOrderException;
import com.cg.onlineshopping_application.service.IOrderServiceImp;
import com.cg.onlineshopping_application.util.ShoppingConstants;

@RestController
@RequestMapping("/order")
public class OrderController
{
	@Autowired
	IOrderServiceImp orderService;
	
	@PostMapping("/addorder")
	public SuccessMessageDto addOrder(@RequestBody Order1Dto order1Dto) throws ValidateOrderException, CustomerNotFoundException,AddressNotFoundException, ProductNotFoundException 
	{
		Order1 order1= orderService.addOrder(order1Dto);
		return new SuccessMessageDto(ShoppingConstants.ORDER_ADDED+ order1.getOrdId());
	}
	
	@DeleteMapping("/removeorder/{id}")
		public SuccessMessageDto removeOrder(@PathVariable("id") Integer ordId) throws OrderIdException
		{
			orderService.removeOrder(ordId);
			return new SuccessMessageDto(ShoppingConstants.ORDER_REMOVED);
		}
	
	@PutMapping("/updateorder")
	public SuccessMessageDto updateOrder(@RequestBody Order1Dto order1Dto) throws OrderIdException, ValidateOrderException, CustomerNotFoundException, ProductNotFoundException,AddressNotFoundException
	{
		Order1 order1=orderService.updateOrder(order1Dto);
		return new SuccessMessageDto(ShoppingConstants.ORDER_UPDATED+order1.getOrdId());
	}
	
	@GetMapping("/getorderbyid/{id}")
	public Order1 viewOrderById(@PathVariable("id")Integer ordId) throws OrderIdException 
	{
	
		return orderService.viewOrder(ordId);	
	}
	
	@GetMapping("/getorderbyaddress/{id}")
	public List<Order1> viewAllOrdersByLocation(@PathVariable("id") Integer addressId) throws AddressNotFoundException
	{
		return orderService.viewAllOrdersByLocation(addressId);	
	}
	
	@GetMapping("/getorderbycustomer/{id}")
	public List<Order1> viewAllOrderByCustomerId(@PathVariable("id") Integer customerId) throws CustomerNotFoundException
	{
		return orderService.viewAllOrderByCustomerId(customerId);	
	}
}