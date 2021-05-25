package com.example.projectv1.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	private int catId;
	private String categoryName;
	
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL)
	private Map<Product, Integer>products;
	
	
	public Category() {
	
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Map<Product, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}
	
	
}
