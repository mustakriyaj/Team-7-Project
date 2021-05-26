package com.cg.projectv2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.projectv2.model.Address;
import com.cg.projectv2.model.Cart;
import com.cg.projectv2.model.Category;
import com.cg.projectv2.model.Customer;
import com.cg.projectv2.model.Order1;
import com.cg.projectv2.model.Product;
import com.cg.projectv2.model.User;
import com.cg.projectv2.repository.ICustomerRepository;
import com.cg.projectv2.repository.ILoginRepository;
import com.cg.projectv2.repository.IOrderRepository;
import com.cg.projectv2.repository.IProductRepository;
import com.cg.projectv2.repository.IAddressRepository;
import com.cg.projectv2.repository.ICartRepository;

@SpringBootApplication
public class Projectv2Application implements CommandLineRunner {
	
	@Autowired
	private ILoginRepository loginRep;
	
	@Autowired
	private ICustomerRepository customerRep;
	
	@Autowired
	private IProductRepository productRep;
	
	@Autowired
	private IAddressRepository addressRep;
	
	@Autowired
	private ICartRepository cartRep;
	
	@Autowired
	private IOrderRepository orderRep;
	
	

	public static void main(String[] args) {
		SpringApplication.run(Projectv2Application.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		Customer customer1=new Customer();
		User user1=new User();
		Category category1=new Category();
		Product product1=new Product();
		Address address1=new Address();
		Cart cart1=new Cart();
		Order1 order1=new Order1();
		
		user1.setUserId("lol@lol.lol");
		user1.setPassword("******");
		user1.setRole("chop-shilpi");
		user1.setCus(customer1);
		
		cart1.setCartId(2001);
		cart1.setCustomer(customer1);
		cart1.setProducts(product1);
		
		
		customer1.setCustomerId(4001);
		customer1.setFirstName("Mustak");
		customer1.setLastName("riyaj");
		customer1.setMobileNumber("9999977777");
		customer1.setEmail("lol@lol.lol");
		customer1.setAddress(address1);
		customer1.setUser(user1);
		customer1.setCart(cart1);
		customer1.setOrd(order1);
		
		
		address1.setAddressId(1001);
		address1.setStreetNo("12");
		address1.setBuildingName("xyz building");
		address1.setCity("kolkata");
		address1.setState("West Bengal");
		address1.setCountry("india");
		address1.setPincode("700021");
		address1.setCustomer(customer1);
		address1.setOrd(order1);

		
		category1.setCatId(3001);
		category1.setCategoryName("xdxd");
		category1.setProduct(product1);
		
		
		product1.setProductId(6001);
		product1.setProductName("Jh");
		product1.setPrice(10000.00);
		product1.setColor("sobuj");
		product1.setDimension("4D");
		product1.setSpecification("sobuj j");
		product1.setManufacturer("Xx_Aukur_xX");
		product1.setQuantity(2);
		product1.setCategory(category1);
		product1.setCart(cart1);
		product1.setOrd(order1);
		
		
		
		/*Map<Product,Integer> m1 = new HashMap<Product,Integer>();
		m1.put(product1,2);*/
		
		
		order1.setOrdId("5001");
		order1.setOrdStatus("pending hghvhvhvghvvgh");
		order1.setOrdDate(LocalDate.now());
		order1.setCustomer(customer1);
		order1.setAddress(address1);
		order1.setProduct(product1);
		
		
		
		
		loginRep.save(user1);
		customerRep.save(customer1);
		productRep.save(product1);
		addressRep.save(address1);
		cartRep.save(cart1);
		orderRep.save(order1);
	}

}
