package com.cg.projectv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.projectv2.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer>{

//	public Customer addCustomer(Customer cust);
//	public Customer updateCustomer(Customer cust);
//	public Customer removeCustomer(Customer cust);
//	public Customer viewCustomer(Customer cust);
//	public List<Customer> ViewAllCustomers(String location);

}
