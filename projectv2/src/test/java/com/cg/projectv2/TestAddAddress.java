package com.cg.projectv2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.projectv2.dto.AddressDto;
import com.cg.projectv2.exception.AddressIdException;
import com.cg.projectv2.exception.CustomerNotFoundException;
import com.cg.projectv2.exception.ValidateAddressException;
import com.cg.projectv2.model.Address;
import com.cg.projectv2.model.Customer;
import com.cg.projectv2.repository.IAddressRepository;
import com.cg.projectv2.repository.ICustomerRepository;
import com.cg.projectv2.service.IAddressService;
import com.cg.projectv2.service.IAddressServiceImp;

@SpringBootTest
public class TestAddAddress {
	@Mock
	private ICustomerRepository customerDao;
	
	@Mock
	private IAddressRepository addressDao;
	
	@InjectMocks
	private IAddressService addressService = new IAddressServiceImp();
	
	@BeforeEach
	public void berforeEach() {
		when(customerDao.findById(1)).thenReturn(Optional.of(new Customer()));
		when(customerDao.findById(2)).thenReturn(Optional.empty());
		when(addressDao.save(any(Address.class))).thenReturn(new Address());
	}
	
	@Test
	public void testViewAddressById() throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		AddressDto dto = new AddressDto(1,"13c","gt road","betapark","kolkata","westbengal","700017");
		
		assertNotNull(addressService.addAddress(dto));
		
	}
	
	@Test
	public void testViewAddressById2() throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		
		AddressDto dto = new AddressDto(2,"13c","gt road","betapark","kolkata","westbengal","700017");
		assertThrows(CustomerNotFoundException.class,()-> addressService.addAddress(dto));
		
	}
	
	@Test
	public void testViewAddressById3() throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		
		AddressDto dto = new AddressDto(1,"13yeyeyeyeyeye","gt road","betapark","kolkata","westbengal","700017");
		assertThrows(ValidateAddressException.class,()-> addressService.addAddress(dto));
		
	}
	
	@Test
	public void testViewAddressById4() throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		
		AddressDto dto = new AddressDto(1,"13c","gt road123","betapark","kolkata","westbengal","700017");
		assertThrows(ValidateAddressException.class,()-> addressService.addAddress(dto));
		
	}
	
	@Test
	public void testViewAddressById5() throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		
		AddressDto dto = new AddressDto(1,"13c","gt road","betapark","kolkata","westbengal","000017");
		assertThrows(ValidateAddressException.class,()-> addressService.addAddress(dto));
		
	}
	
	@Test
	public void testViewAddressById6() throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		
		AddressDto dto = new AddressDto(1,"13c","gt road","betapark","kolkata","westbengal","1");
		assertThrows(ValidateAddressException.class,()-> addressService.addAddress(dto));
		
	}
}













