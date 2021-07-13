package com.example.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("hello1")
	public String hello1() {
		System.out.println("from hello1()");
		return "I am from hello1";
	}
	
	@GetMapping("hello2")
	public String hello2() {
		System.out.println("from hello2()");
		return "I am from hello2";}
		
		@GetMapping("hello3")
		public String hello3() {
			System.out.println("from hello3()");
			return "I am from hello3";}
		
		@GetMapping("/")
		public String welcome() {
			System.out.println("welcome");
			return "Welcome everyone";}
			
			@GetMapping("hello4")
			public String hello4() {
				System.out.println("from hello4()");
				return "I am from hello4";
	}

}
