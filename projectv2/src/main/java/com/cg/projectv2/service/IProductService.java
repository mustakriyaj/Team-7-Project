package com.cg.projectv2.service;

import java.util.List;

import com.cg.projectv2.model.Product;

public interface IProductService {
 //public List<Product> viewAllProducts();
 public Product addProduct(Product product);
 public Product updateProduct(Product product);
 public Product viewProduct(int id);
 //public List<Product> viewProductsByCategory(String cat); 
 public Product removeProduct(Integer prodid);
}
