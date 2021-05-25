package com.example.projectv1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectv1.model.Cart;
import com.example.projectv1.model.Product;

public interface ICartRepository extends JpaRepository<Cart,Integer>{
	public Cart addProductToCart(Cart cart, Product p,int quantity);
	public Cart removeProductFromCart(Cart cart,Product p);
	public Cart updateProductQuantity(Cart cart, Product p,int quantity);
	public Cart removeAllProducts(Cart cart);
	public List<Product> viewAllProducts(Cart cart);
}
