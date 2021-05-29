package com.cg.projectv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.projectv2.model.Product;

public interface IProductRepository extends JpaRepository<Product,Integer>{
	 //public List<Product> viewAllProducts();
	 public Product addProduct(Product product);
	 public Product updateProduct(Product product);
	 public Product viewProduct(int id);
	 //public List<Product> viewProductsByCategory(String cat); 
	 public Product removeProduct(Integer prodid);
}
