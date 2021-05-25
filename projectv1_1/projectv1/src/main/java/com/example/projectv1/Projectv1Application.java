package com.example.projectv1;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.projectv1.model.Address;
import com.example.projectv1.model.Cart;
import com.example.projectv1.model.Category;
import com.example.projectv1.model.Customer;
import com.example.projectv1.model.Order;
import com.example.projectv1.model.Product;
import com.example.projectv1.model.User;
import com.example.projectv1.repository.IAddressRepository;
import com.example.projectv1.repository.ICartRepository;
import com.example.projectv1.repository.ICustomerRepository;
import com.example.projectv1.repository.ILoginRepository;
import com.example.projectv1.repository.IOrderRepository;
import com.example.projectv1.repository.IProductRepository;

@SpringBootApplication
public class Projectv1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Projectv1Application.class, args);
	}

	@Autowired
	private IAddressRepository addressRep;
	
	@Autowired
	private ICartRepository cartRep;
	
	@Autowired
	private ICustomerRepository customerRep;
	
	//false_repo
	@Autowired
	private ILoginRepository loginRep;
	
	@Autowired
	private IOrderRepository orderRep;
	
	@Autowired 
	private IProductRepository productRep;
	
	public void run(String...args) throws Exception{
		
		Address address1 = new Address();
		Customer customer1 = new Customer();
		Product product1 = new Product();
		Cart cart1 = new Cart();
		Category category1 = new Category();
		Order order1 = new Order();
		User user1 = new User();
		
		address1.setAddressId(1001);
		address1.setStreetNo("12");
		address1.setBuildingName("xyz building");
		address1.setCity("kolkata");
		address1.setState("West Bengal");
		address1.setCountry("india");
		address1.setPincode("700021");
		
		
		customer1.setCustomerId(4001);
		customer1.setFirstName("Mustak");
		customer1.setLastName("riyaj");
		customer1.setMobileNumber("9999977777");
		customer1.setEmail("lol@lol.lol");
		customer1.setAddress(address1);
		customer1.setUser(user1);
		customer1.setCart(cart1);
		customer1.setOrder(order1);

		
		product1.setProductId(6001);
		product1.setProductName("Jharu");
		product1.setPrice(10000.00);
		product1.setColor("sobuj");
		product1.setDimension("4D");
		product1.setSpecification("sobuj jharu, gujrat ko maru");
		product1.setManufacturer("Xx_Aukur_xX");
		product1.setQuantity(2);
		product1.setCategory(category1);
		product1.setOrder(order1);
		product1.setCart(cart1);
		
		Map<Product, Integer> m1 = new HashMap<Product, Integer>();
		m1.put(product1, 6001);
		
		
		cart1.setCartId(2001);
		cart1.setCus(customer1);
		cart1.setProducts(m1);
		
		
		category1.setCatId(3001);
		category1.setCategoryName("xdxd");
		category1.setProducts(m1);
		
		
		order1.setOrderId(5001);
		order1.setOrderStatus("pending");
		order1.setOrderDate(LocalDate.now());
		order1.setProduct(m1);
		order1.setCus(customer1);
		order1.setAddress(address1);
		
		
		user1.setUserId("lol@lol.lol");
		user1.setPassword("******");
		user1.setRole("chop-shilpi");
		user1.setCus(customer1);
		
		addressRep.save(address1);
		cartRep.save(cart1);
		customerRep.save(customer1);
		loginRep.save(user1);
		orderRep.save(order1);
		productRep.save(product1);
		
	}
	
}
