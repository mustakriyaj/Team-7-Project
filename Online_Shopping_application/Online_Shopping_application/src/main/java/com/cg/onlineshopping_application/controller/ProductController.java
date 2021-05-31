package com.cg.onlineshopping_application.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping_application.dto.ProductDto;
import com.cg.onlineshopping_application.dto.SuccessMessageDto;
import com.cg.onlineshopping_application.entity.Product;
import com.cg.onlineshopping_application.exception.CategoryNotFoundException;
import com.cg.onlineshopping_application.exception.ProductIdException;
import com.cg.onlineshopping_application.exception.ValidateProductException;
import com.cg.onlineshopping_application.service.IProductServiceImp;
import com.cg.onlineshopping_application.util.ShoppingConstants;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	IProductServiceImp prodservice;
	
	@PostMapping("/addproduct")
	public SuccessMessageDto addProduct(@RequestBody ProductDto productDto) throws ValidateProductException, CategoryNotFoundException
	{
		Product product= prodservice.addProduct(productDto);
		return new SuccessMessageDto(ShoppingConstants.PRODUCT_ADDED+ product.getProductId());
	}
	
	@DeleteMapping("/removeproduct/{id}")
	public SuccessMessageDto removeProduct(@PathVariable("id") Integer id) throws ProductIdException
	{
		prodservice.removeProduct(id);
        return new SuccessMessageDto(ShoppingConstants.PRODUCT_REMOVED);
	}
	
	@PutMapping("/updateproduct")
	public SuccessMessageDto updateProduct(@RequestBody ProductDto pro) throws ProductIdException, ValidateProductException, CategoryNotFoundException
	{
		Product product=prodservice.updateProduct(pro);
		return new SuccessMessageDto(ShoppingConstants.PRODUCT_UPDATED+product.getProductId());
	}
	
	@GetMapping("/getproductbyid/{id}")
	public Product viewProduct(@PathVariable("id") Integer id) throws ProductIdException
	{
		return prodservice.viewProduct(id);	
	}

	
	@GetMapping("/getallproducts")
	public List<Product> viewAllProducts() throws ProductIdException 
	{
		return prodservice.viewAllProducts();	
	}
	
	@GetMapping("/getproduct/{id}")
	public List<Product> viewProductsByCategory(@PathVariable("id") Integer categoryId) throws CategoryNotFoundException
	{
		return prodservice.viewProductsByCategory(categoryId);	
	}
}
