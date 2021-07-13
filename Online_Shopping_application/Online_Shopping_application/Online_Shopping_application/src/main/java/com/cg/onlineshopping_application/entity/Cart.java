package com.cg.onlineshopping_application.entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
/*
 * public class Cart {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO) private int cartId;
 * 
 * 
 * @OneToMany
 * 
 * @JsonIgnore private List<Product> products;
 * 
 * public int getCartId() { return cartId; }
 * 
 * public void setCartId(int cartId) { this.cartId = cartId; }
 * 
 * public List<Product> getProducts() { return products; }
 * 
 * public void setProducts(List<Product> products) { this.products = products; }
 * 
 * 
 * 
 * }
 */