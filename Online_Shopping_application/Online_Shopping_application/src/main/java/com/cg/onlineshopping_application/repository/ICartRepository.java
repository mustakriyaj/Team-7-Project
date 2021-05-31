package com.cg.onlineshopping_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping_application.entity.Cart;

public interface ICartRepository extends JpaRepository<Cart,Integer>{

}
