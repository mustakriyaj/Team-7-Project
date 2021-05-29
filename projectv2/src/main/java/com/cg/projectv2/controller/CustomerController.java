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
import com.cg.projectv2.service.ICustomerServiceImp;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	
		@Autowired
		ICustomerServiceImp cusservice;
		
		@PostMapping("/add")
		public Customer addCustomer(@RequestBody Customer cust)
		{
			return cusservice.addCustomer(cust);
		}
		
		@DeleteMapping("/remove/{id}")
		public Customer removeCustomer(@PathVariable("id") Integer id)
		{
			Customer c = new Customer();
			c.setCustomerId(id);
			cusservice.removeCustomer(c);
			return c;
		}
		
		@PutMapping("/update/{id}")
		public Customer updateCustomer(@PathVariable("id") Integer id,@RequestBody Customer cust) 
		{
			cust.setCustomerId(id);
			cusservice.updateCustomer(cust);
			return cust;
		}
		
		@GetMapping("/get/{id}")
		public Customer viewCustomer(@PathVariable("id") Integer id, @RequestBody Customer cust) 
		{
			return cusservice.viewCustomer(cust);	
		}

}
