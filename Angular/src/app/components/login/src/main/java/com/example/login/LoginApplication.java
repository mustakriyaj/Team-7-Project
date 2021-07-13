package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LoginApplication implements CommandLineRunner{

	@Autowired
	private PersonService personservice;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p1=new Person();
		p1.setUsername("Debosmita");
		p1.setPassword(getPasswordEncoder().encode("Sai"));
		p1.setRole("ROLE_ADMIN");
		
		Person p2=new Person();
		p2.setUsername("Diya");
		p2.setPassword(getPasswordEncoder().encode("Sai"));
		p2.setRole("ROLE_USER");
	
		personservice.save(p1);
		personservice.save(p2);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
