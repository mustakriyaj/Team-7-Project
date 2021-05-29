package com.cg.projectv2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.projectv2.dto.CustomerDto;
import com.cg.projectv2.exception.CustomerIdException;
import com.cg.projectv2.exception.UserNotFoundException;
import com.cg.projectv2.exception.ValidateCustomerException;
import com.cg.projectv2.model.Customer;
import com.cg.projectv2.model.User;
import com.cg.projectv2.repository.ICustomerRepository;
import com.cg.projectv2.repository.ILoginRepository;
import com.cg.projectv2.util.ShoppingConstants;

@Service
public class ICustomerServiceImp implements ICustomerService
{
	@Autowired
	ICustomerRepository customerDao;
	@Autowired
	ILoginRepository userDao;
	
	public Customer addCustomer(CustomerDto customerDto) throws ValidateCustomerException, UserNotFoundException {
		validateCustomer(customerDto);
		Customer customer = new Customer();
		Optional<User> optUser = userDao.findById(customerDto.getUserId());
		if (!optUser.isPresent())
			throw new UserNotFoundException(ShoppingConstants.USER_NOT_FOUND);
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setEmail(customerDto.getEmail());
		customer.setUser(optUser.get());
		return customerDao.save(customer);
	}

	private boolean validateCustomer(CustomerDto customerDto) throws ValidateCustomerException {
	
		if (!customerDto.getFirstName().matches(ShoppingConstants.CUSTOMER_PATTERN)) 
			throw new ValidateCustomerException(ShoppingConstants.CUSTOMER_CANNOT_BE_EMPTY);
		
		if (!customerDto.getLastName().matches(ShoppingConstants.CUSTOMER_PATTERN)) 
			throw new ValidateCustomerException(ShoppingConstants.CUSTOMER_CANNOT_BE_EMPTY);
		
		if (!customerDto.getMobileNumber().matches("[1-9][0-9]{9}"))
			throw new ValidateCustomerException(ShoppingConstants.PHONENUMBER_CANNOT_BE_EMPTY);
		
		if (!customerDto.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
			throw new ValidateCustomerException(ShoppingConstants.EMAIL_CANNOT_BE_EMPTY);
		return true;
	}

	

	public Customer updateCustomer(CustomerDto customerDto) throws CustomerIdException, ValidateCustomerException, UserNotFoundException {
		validateCustomer(customerDto);
		Optional<Customer> optCustomer = customerDao.findById(customerDto.getCustomerId());
		if (!optCustomer.isPresent())
			throw new CustomerIdException(ShoppingConstants.CUSTOMER_NOT_FOUND);
		Optional<User> optUser = userDao.findById(customerDto.getUserId());
		if (!optUser.isPresent())
			throw new UserNotFoundException(ShoppingConstants.USER_NOT_FOUND);
		Customer customer = optCustomer.get();
		User user = optUser.get();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setEmail(customerDto.getEmail());
		customer.setUser(user);
		return customerDao.save(customer);

	}
	
	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerIdException {
		Optional<Customer> optcustomer = customerDao.findById(customerId);
		if (!optcustomer.isPresent()) {
			throw new CustomerIdException(ShoppingConstants.CUSTOMER_NOT_FOUND);

		}
		return optcustomer.get();
	}


	

	@Override
	public boolean removeCustomer(Integer customerId) throws CustomerIdException {
		
			Optional<Customer> optcustomer = customerDao.findById(customerId);

			if (!optcustomer.isPresent()) {
				throw new CustomerIdException(ShoppingConstants.CUSTOMER_NOT_FOUND);

			}
			customerDao.delete(optcustomer.get());
			return true;
		}



	@Override
	public List<Customer> viewAllCustomers() throws CustomerIdException {
	
			List<Customer> customerlist = customerDao.findAll();
			if (customerlist.isEmpty())
				throw new CustomerIdException(ShoppingConstants.CUSTOMER_NOT_FOUND);
			customerlist.sort((a1, a2) -> a1.getFirstName().compareTo(a2.getFirstName()));
			return customerlist;
		
	}

//	

}
