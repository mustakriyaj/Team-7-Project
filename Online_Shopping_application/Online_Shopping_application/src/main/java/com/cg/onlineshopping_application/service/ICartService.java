package com.cg.onlineshopping_application.service;

import com.cg.onlineshopping_application.entity.Cart;
import com.cg.onlineshopping_application.entity.Product;



public interface ICartService {

	public Cart addProductToCart(Cart cart, Product p,int quantity);
	public Cart removeProductFromCart(Cart cart,Product p);
	public Cart updateProductQuantity(Cart cart, Product p,int quantity);
	public Cart removeAllProducts(Cart cart);
}
