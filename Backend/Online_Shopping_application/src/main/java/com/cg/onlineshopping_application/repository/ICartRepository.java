package com.cg.onlineshopping_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping_application.entity.CartItem;

@Repository
public interface ICartRepository extends JpaRepository<CartItem,Integer>{
	
	@Query("from CartItem item inner Join item.product p inner Join item.customer c where c.customerId=:custId")
	public List<CartItem> getCartItems(@Param("custId") Integer customerId);
}
