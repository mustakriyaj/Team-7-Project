package com.cg.projectv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.projectv2.model.Address;
import com.cg.projectv2.model.Product;
import com.cg.projectv2.service.IProductServiceImp;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	IProductServiceImp prodservice;
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product)
	{
		return prodservice.addProduct(product);
	}
	
	@DeleteMapping("/remove/{id}")
	public Product removeProduct(@PathVariable("id") Integer id)
	{
		Product prodremove = new Product();
		prodremove.setProductId(id);
		prodservice.removeProduct(id);
		return prodremove;
	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable("id") Integer id,@RequestBody Product product) 
	{
		product.setProductId(id);
		prodservice.updateProduct(product);
		return product;
	}
	
	@GetMapping("/get/{id}")
	public Product viewProduct(@PathVariable("id") Integer id) 
	{
		return prodservice.viewProduct(id);	
	}

}
