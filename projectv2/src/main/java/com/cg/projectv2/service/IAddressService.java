package com.cg.projectv2.service;

import java.util.List;

import com.cg.projectv2.dto.AddressDto;
import com.cg.projectv2.exception.AddressIdException;
import com.cg.projectv2.exception.CustomerNotFoundException;
import com.cg.projectv2.exception.ValidateAddressException;
import com.cg.projectv2.model.Address;

public interface IAddressService {

	public Address addAddress(AddressDto addressdto)throws ValidateAddressException,CustomerNotFoundException;
	public Address updateAddress(AddressDto addressdto) throws AddressIdException,CustomerNotFoundException,ValidateAddressException;
	public boolean removeAddress(Integer addressId)throws AddressIdException;
	public List<Address> viewAllAddress()throws AddressIdException;
	public Address viewAddress(Integer addressId)throws AddressIdException;
	
}
