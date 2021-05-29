package com.cg.projectv2.controller;

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

import com.cg.projectv2.dto.AddressDto;
import com.cg.projectv2.dto.CustomerDto;
import com.cg.projectv2.dto.SuccessMessageDto;
import com.cg.projectv2.exception.AddressIdException;
import com.cg.projectv2.exception.CustomerIdException;
import com.cg.projectv2.exception.CustomerNotFoundException;
import com.cg.projectv2.exception.UserNotFoundException;
import com.cg.projectv2.exception.ValidateAddressException;
import com.cg.projectv2.exception.ValidateCustomerException;
import com.cg.projectv2.model.Address;
import com.cg.projectv2.model.Customer;
import com.cg.projectv2.service.ICustomerServiceImp;
import com.cg.projectv2.util.ShoppingConstants;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	
		@Autowired
		ICustomerServiceImp customerService;
		
		@PostMapping("/addcustomer")
		public SuccessMessageDto addCustomer(@RequestBody CustomerDto customerDto) throws ValidateCustomerException, UserNotFoundException
		{
			Customer customer= customerService.addCustomer(customerDto);
			return new SuccessMessageDto(ShoppingConstants.CUSTOMER_ADDED+ customer.getCustomerId());
		}
		
//		@DeleteMapping("/remove/{id}")
//		public Customer removeCustomer(@PathVariable("id") Integer id)
//		{
//			Customer c = new Customer();
//			c.setCustomerId(id);
//			cusservice.removeCustomer(c);
//			return c;
//		}
		
		@PutMapping("/updatecustomer")
		public SuccessMessageDto updateCustomer(@RequestBody CustomerDto add) throws CustomerIdException, ValidateCustomerException, UserNotFoundException 
		{
			Customer customer=customerService.updateCustomer(add);
			return new SuccessMessageDto(ShoppingConstants.CUSTOMER_UPDATED+customer.getCustomerId());
		}
		
		@GetMapping("/getcustomerbyid/{id}")
		public Customer viewCustomerById(@PathVariable("id")Integer id) throws CustomerIdException 
		{
		
			return customerService.viewCustomer(id);	
		}
		
		@GetMapping("/getallcustomer")
		public List<Customer> viewCustomer() throws CustomerIdException 
		{
			return customerService.viewAllCustomers();	
		}
		

}
