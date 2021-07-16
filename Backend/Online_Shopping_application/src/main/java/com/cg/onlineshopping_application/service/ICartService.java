package com.cg.onlineshopping_application.service;

import java.util.List;

import com.cg.onlineshopping_application.dto.CartDto;
import com.cg.onlineshopping_application.entity.CartItem;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.ProductNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateCartException;



public interface ICartService {

	public CartItem addProductToCart(Integer customerId, Integer productId)throws CustomerNotFoundException, ProductNotFoundException; 
	public boolean removeProductFromCart(Integer cartItemId) throws ValidateCartException;
	public List<CartItem> viewAllProductsInCart(Integer customerId) throws ValidateCartException,CustomerNotFoundException;
}
