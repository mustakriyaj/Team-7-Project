package com.example.projectv1.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	private int cartId;
	
	@OneToOne
	private Customer cus;
	
	@OneToMany(mappedBy="cart",cascade = CascadeType.ALL)
	private Map<Product, Integer>products;
	
	
	public Cart() {
		
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public Map<Product, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}
	public Customer getCus() {
		return cus;
	}
	public void setCus(Customer cus) {
		this.cus = cus;
	}
	
	

}
