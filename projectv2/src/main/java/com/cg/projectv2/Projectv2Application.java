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
public class Projectv2Application {

	public static void main(String[] args) {
		SpringApplication.run(Projectv2Application.class, args);
	}
	

	

}
