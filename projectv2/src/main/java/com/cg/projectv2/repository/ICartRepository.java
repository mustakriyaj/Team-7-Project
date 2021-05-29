package com.cg.projectv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.projectv2.model.Cart;
import com.cg.projectv2.model.Product;

public interface ICartRepository extends JpaRepository<Cart,Integer>{
	public Cart addProductToCart(Cart cart, Product p,int quantity);
	public Cart removeProductFromCart(Cart cart,Product p);
	public Cart updateProductQuantity(Cart cart, Product p,int quantity);
	public Cart removeAllProducts(Cart cart);
	//public List<Product> viewAllProducts(Cart cart);
}
