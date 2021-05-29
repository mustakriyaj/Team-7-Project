package com.cg.projectv2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.projectv2.exception.AddressIdException;
import com.cg.projectv2.model.Address;
import com.cg.projectv2.repository.IAddressRepository;
import com.cg.projectv2.repository.ICustomerRepository;
import com.cg.projectv2.service.IAddressService;
import com.cg.projectv2.service.IAddressServiceImp;

@SpringBootTest
public class TestViewAddressById {
	@Mock
	private ICustomerRepository customerDao;
	
	@Mock
	private IAddressRepository addressDao;
	
	@InjectMocks
	private IAddressService addressService = new IAddressServiceImp();
	
	@BeforeEach
	public void berforeEach() {
		when(addressDao.findById(1)).thenReturn(Optional.of(new Address()));
		when(addressDao.findById(2)).thenReturn(Optional.empty());
	}
	
	@Test
	public void testViewAddressById() throws AddressIdException {
		assertNotNull(addressService.viewAddress(1));
	}
	
	@Test
	public void testViewAddressById2() throws AddressIdException {
		assertThrows(AddressIdException.class,()->addressService.viewAddress(2));
	}
	
	
	
}









