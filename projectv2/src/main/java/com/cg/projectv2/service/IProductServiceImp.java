package com.cg.projectv2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.projectv2.model.Address;
import com.cg.projectv2.model.Customer;
import com.cg.projectv2.model.Product;
import com.cg.projectv2.repository.IProductRepository;

@Service
public class IProductServiceImp implements IProductService
{
	@Autowired
	IProductRepository repository;

//	@Override
//	public List<Product> viewAllProducts() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Product addProduct(Product product) {
		Optional<Product> findById = repository.findById(product.getProductId());
		if(!findById.isPresent()) {
			return repository.save(product);
		}
		
		return product;
//		else
//			throw new AddressException("Address already present");
	}

	@Override
	public Product updateProduct(Product product) {

		Optional<Product> findById = repository.findById(product.getProductId());
		if(findById.isPresent())
		{
			product.setProductName(product.getProductName());
			product.setPrice(product.getPrice());
			product.setColor(product.getColor());
			product.setDimension(product.getDimension());
			product.setSpecification(product.getSpecification());
			product.setManufacturer(product.getManufacturer());
			product.setQuantity(product.getQuantity());
			product.setCategory(product.getCategory());
			product.setCart(product.getCart());
			product.setOrd(product.getOrd());
			repository.save(product);
		}
		return null;
	}

	@Override
	public Product viewProduct(int id) {
		Optional<Product> findById = repository.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

//	@Override
//	public List<Product> viewProductsByCategory(String cat) {
//		return null;
//	}

	@Override
	public Product removeProduct(Integer prodid) {
		Optional<Product> findById = repository.findById(prodid);
		if(findById.isPresent()) {
			Product c = findById.get();
			repository.deleteById(prodid);
			return c;
			}
		
		return null;
	}

	

}
