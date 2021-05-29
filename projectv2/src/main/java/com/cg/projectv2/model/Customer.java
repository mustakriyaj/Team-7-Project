package com.cg.projectv2.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer 
{
	
	@Id
	private int customerId;
	
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	
	@OneToOne
	private User user;
	
	@OneToOne(mappedBy="customer",cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(mappedBy="customer",cascade = CascadeType.ALL)
	private Cart cart;
	
	@OneToOne(mappedBy="customer",cascade = CascadeType.ALL)
	private Order1 ord;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Order1 getOrd() {
		return ord;
	}

	public void setOrd(Order1 ord) {
		this.ord = ord;
	}
	
}