package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class CgSecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PersonService personService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(personService);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/hello1").hasRole("ADMIN")
		.antMatchers("/hello2").hasRole("ADMIN")
		.antMatchers("/hello3").hasRole("USER")
		.antMatchers("/hello4").hasAnyRole("USER","ADMIN")
		.and()
		.httpBasic()
		.and()
		.formLogin();
		
	}
}
