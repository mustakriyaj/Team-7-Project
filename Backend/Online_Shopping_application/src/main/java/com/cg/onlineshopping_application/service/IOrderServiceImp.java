package com.cg.onlineshopping_application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping_application.dto.Order1Dto;
import com.cg.onlineshopping_application.entity.Address;
import com.cg.onlineshopping_application.entity.Customer;
import com.cg.onlineshopping_application.entity.Order1;
import com.cg.onlineshopping_application.entity.Product;
import com.cg.onlineshopping_application.exception.AddressNotFoundException;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.OrderIdException;
import com.cg.onlineshopping_application.exception.ProductNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateOrderException;
import com.cg.onlineshopping_application.repository.IAddressRepository;
import com.cg.onlineshopping_application.repository.ICustomerRepository;
import com.cg.onlineshopping_application.repository.IOrderRepository;
import com.cg.onlineshopping_application.repository.IProductRepository;
import com.cg.onlineshopping_application.util.ShoppingConstants;

@Service
public class IOrderServiceImp implements IOrderService
{
	@Autowired
	IOrderRepository orderDao;
	
	@Autowired
	IProductRepository productDao;
	
	@Autowired
	IAddressRepository addressDao;
	
	@Autowired
	ICustomerRepository customerDao;
	
	@Override
	public Order1 addOrder(Order1Dto order1Dto)throws ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, ProductNotFoundException  {
		
		
		validateOrder(order1Dto);
		Order1 order1 = new Order1();
		
		Optional<Customer> optCustomer = customerDao.findById(order1Dto.getCustomerId());
		if (!optCustomer.isPresent())
			throw new CustomerNotFoundException(ShoppingConstants.CUSTOMER_NOT_FOUND);
		
		Optional<Product> optProduct = productDao.findById(order1Dto.getProductId());
		if (!optProduct.isPresent())
			throw new ProductNotFoundException(ShoppingConstants.PRODUCT_NOT_FOUND);
		
		Optional<Address> optAddress = addressDao.findById(order1Dto.getAddressId());
		if (!optAddress.isPresent())
			throw new AddressNotFoundException(ShoppingConstants.ADDRESS_NOT_FOUND);
		
		
		
		order1.setOrdStatus(order1Dto.getOrdStatus());
		order1.setOrdDate(order1Dto.getOrdDate());
		order1.setCustomer(optCustomer.get());
		order1.setAddress(optAddress.get());
		
		return orderDao.save(order1);
	}

	@Override
	public Order1 updateOrder(Order1Dto order1Dto) throws OrderIdException, ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, ProductNotFoundException {
		validateOrder(order1Dto);
		
		Optional<Order1> optorder = orderDao.findById(order1Dto.getOrdId());
		if (!optorder.isPresent())
			throw new OrderIdException(ShoppingConstants.ORDER_NOT_FOUND);
		Optional<Product> optProduct = productDao.findById(order1Dto.getProductId());
		if (!optProduct.isPresent())
			throw new ProductNotFoundException(ShoppingConstants.PRODUCT_NOT_FOUND);
		
		Optional<Address> optAddress = addressDao.findById(order1Dto.getAddressId());
		if (!optAddress.isPresent())
			throw new AddressNotFoundException(ShoppingConstants.ADDRESS_NOT_FOUND);
		
		Optional<Customer> optCustomer = customerDao.findById(order1Dto.getCustomerId());
		if (!optCustomer.isPresent())
			throw new CustomerNotFoundException(ShoppingConstants.CUSTOMER_NOT_FOUND);
			
		Order1 order1 = optorder.get();
		
		order1.setOrdStatus(order1Dto.getOrdStatus());
		order1.setOrdDate(order1Dto.getOrdDate());
		order1.setCustomer(optCustomer.get());
		order1.setAddress(optAddress.get());
		
		return orderDao.save(order1);
	}

	
	public boolean validateOrder(Order1Dto order1Dto) throws ValidateOrderException {
		if (!order1Dto.getOrdStatus().matches("[A-Za-z0-9]{1,100}")) {
			throw new ValidateOrderException(ShoppingConstants.STATUS_CANNOT_BE_EMPTY);
		}
		
		return true;
	}
	
	
	@Override
	public boolean removeOrder(Integer ordId) throws OrderIdException {
		Optional<Order1> optorder = orderDao.findById(ordId);

		if (!optorder.isPresent()) {
			throw new OrderIdException(ShoppingConstants.ORDER_NOT_FOUND);

		}
		orderDao.delete(optorder.get());
		return true;
	}

	@Override
	public Order1 viewOrder(Integer ordId) throws OrderIdException {
		Optional<Order1> optorder = orderDao.findById(ordId);
		if (!optorder.isPresent()) {
			throw new OrderIdException(ShoppingConstants.ORDER_NOT_FOUND);

		}
		return optorder.get();	}

	@Override
	public List<Order1> viewAllOrdersByLocation(Integer addressId) throws AddressNotFoundException {
		List<Order1> orderlist = orderDao.findAll();
		Optional<Address> optAddress = addressDao.findById(addressId);
		if (!optAddress.isPresent())
			throw new AddressNotFoundException(ShoppingConstants.ADDRESS_NOT_FOUND);
		orderlist.stream()
		.filter(p ->p.getAddress().getAddressId()==addressId)
		.collect(Collectors.toList()); 
		return orderlist;
	}

	@Override
	public List<Order1> viewAllOrderByCustomerId(Integer customerId) throws CustomerNotFoundException {
		List<Order1> orderlist = orderDao.findAll();
		Optional<Customer> optCustomer = customerDao.findById(customerId);
		if (!optCustomer.isPresent())
			throw new CustomerNotFoundException(ShoppingConstants.CUSTOMER_NOT_FOUND);
		orderlist.stream()
		.filter(p ->p.getCustomer().getCustomerId()==customerId)
		.collect(Collectors.toList()); 
		return orderlist;
	}

}