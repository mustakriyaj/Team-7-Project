package com.example.projectv1.model;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Order {

	@Id
	private int orderId;
	private String orderStatus;
	private LocalDate orderDate;
	
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL)
	private Map <Product,Integer> product;
	
	@OneToOne
	private Customer cus;
	
	@OneToOne
	private Address address;

	public Order() {		
	}
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	
	public Map<Product, Integer> getProduct() {
		return product;
	}

	public void setProduct(Map<Product, Integer> product) {
		this.product = product;
	}

	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
