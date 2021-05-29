package com.cg.projectv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.projectv2.model.Customer;
import com.cg.projectv2.model.Order1;
import com.cg.projectv2.service.IOrderServiceImp;

@RestController
@RequestMapping("/order")
public class OrderController
{
	@Autowired
	IOrderServiceImp ordservice;
	
	@PostMapping("/add")
	public Order1 addOrder(@RequestBody Order1 order1)
	{
		return ordservice.addOrder(order1);
	}
	
	@DeleteMapping("/remove/{id}")
	public Order1 removeOrder(@PathVariable("id") String id)
	{
		Order1 c = new Order1();
		c.setOrdId(id);
		ordservice.removeOrder(c);
		return c;
	}
	
	@PutMapping("/update/{id}")
	public Order1 updateOrder(@PathVariable("id") String id,@RequestBody Order1 order1) 
	{
		order1.setOrdId(id);
		ordservice.updateOrder(order1);
		return order1;
	}
	
	@GetMapping("/get/{id}")
	public Order1 viewOrder(@PathVariable("id") String id, @RequestBody Order1 order1) 
	{
		return ordservice.viewOrder(order1);	
	}

}
