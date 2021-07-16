package com.example.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements UserDetailsService{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Person person=personRepository.findById(username).get();
		
		List <SimpleGrantedAuthority> roles=new ArrayList<SimpleGrantedAuthority>();
		
		roles.add(new SimpleGrantedAuthority(person.getRole()));
		UserDetails user=new User(username,person.getPassword(),roles);
		return user;
		
	}

	public Person save(Person person) {
	personRepository.save(person);
	return person;
}
}
