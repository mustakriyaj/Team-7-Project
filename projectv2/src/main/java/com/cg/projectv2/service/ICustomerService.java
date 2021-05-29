package com.cg.projectv2.service;

import java.util.List;

import com.cg.projectv2.dto.CustomerDto;
import com.cg.projectv2.exception.CustomerIdException;
import com.cg.projectv2.exception.UserNotFoundException;
import com.cg.projectv2.exception.ValidateCustomerException;
import com.cg.projectv2.model.Customer;

public interface ICustomerService {
	public Customer addCustomer(CustomerDto customerdto)throws ValidateCustomerException,UserNotFoundException;
	public Customer updateCustomer(CustomerDto customerdto)throws CustomerIdException,UserNotFoundException,ValidateCustomerException;;
	public boolean removeCustomer(Integer customerId)throws CustomerIdException;;
	public Customer viewCustomer(Integer customerId)throws CustomerIdException;;
	public List<Customer> viewAllCustomers()throws CustomerIdException;

}
