package com.cg.projectv2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.projectv2.dto.AddressDto;
import com.cg.projectv2.exception.AddressIdException;
import com.cg.projectv2.exception.CustomerNotFoundException;
import com.cg.projectv2.exception.ValidateAddressException;
import com.cg.projectv2.model.Address;
import com.cg.projectv2.model.Customer;
import com.cg.projectv2.repository.IAddressRepository;
import com.cg.projectv2.repository.ICustomerRepository;
import com.cg.projectv2.util.ShoppingConstants;

@Service
public class IAddressServiceImp implements IAddressService {

	@Autowired
	IAddressRepository addressDao;
	@Autowired
	private ICustomerRepository customerDao;

	public Address AddAddress(AddressDto addressDto) throws ValidateAddressException, CustomerNotFoundException {
		validateAddress(addressDto);
		Address address = new Address();
		Optional<Customer> optCustomer = customerDao.findById(addressDto.getCustomerId());
		if (!optCustomer.isPresent())
			throw new CustomerNotFoundException(ShoppingConstants.CUSTOMER_NOT_FOUND);
		address.setStreetNo(addressDto.getStreetNo());
		address.setBuildingName(addressDto.getBuildingName());
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		address.setPincode(addressDto.getPincode());
		address.setState(addressDto.getState());
		address.setCustomer(optCustomer.get());
		Address savedAddress=addressDao.save(address);
		return savedAddress;
	}

	public Address updateAddress(AddressDto addressDto)
			throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		validateAddress(addressDto);
		Optional<Address> optAddress = addressDao.findById(addressDto.getAddressId());
		if (!optAddress.isPresent())
			throw new AddressIdException(ShoppingConstants.ADDRESS_NOT_FOUND);
		Optional<Customer> optCustomer = customerDao.findById(addressDto.getCustomerId());
		if (!optCustomer.isPresent())
			throw new CustomerNotFoundException(ShoppingConstants.CUSTOMER_NOT_FOUND);
		Address address = optAddress.get();
		Customer customer = optCustomer.get();
		address.setStreetNo(addressDto.getStreetNo());
		address.setBuildingName(addressDto.getBuildingName());
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		address.setPincode(addressDto.getPincode());
		address.setState(addressDto.getState());
		address.setCustomer(customer);
		Address updatedAddress = addressDao.save(address);
		return updatedAddress;

	}

	public boolean validateAddress(AddressDto addressDto) throws ValidateAddressException {
		if (!addressDto.getStreetNo().matches("[A-Za-z0-9]{1,3}")) {
			throw new ValidateAddressException(ShoppingConstants.STREET_CANNOT_BE_EMPTY);
		}
		if (!addressDto.getBuildingName().matches("([a-zA-Z])|([A-Za-z]+[ ]{1}[a-zA-Z]+)"))
			throw new ValidateAddressException(ShoppingConstants.BUILDING_CANNOT_BE_EMPTY);
		if (!addressDto.getCity().matches("([a-zA-Z])|([A-Za-z]+[ ]{1}[a-zA-Z]+)"))
			throw new ValidateAddressException(ShoppingConstants.CITY_CANNOT_BE_EMPTY);
		if (!addressDto.getCountry().matches("([a-zA-Z])|([A-Za-z]+[ ]{1}[a-zA-Z]+)"))
			throw new ValidateAddressException(ShoppingConstants.COUNTRY_CANNOT_BE_EMPTY);
		if (!addressDto.getState().matches("([a-zA-Z])|([A-Za-z]+[ ]{1}[a-zA-Z]+)"))
			throw new ValidateAddressException(ShoppingConstants.STATE_CANNOT_BE_EMPTY);
		if (!addressDto.getPincode().matches("[1-9][0-9]{5}"))
			throw new ValidateAddressException(ShoppingConstants.PINCODE_CANNOT_BE_EMPTY);
		return true;
	}

	@Override
	public boolean removeAddress(Integer addressId) throws AddressIdException {
		Optional<Address> optaddress = addressDao.findById(addressId);

		if (!optaddress.isPresent()) {
			throw new AddressIdException(ShoppingConstants.ADDRESS_NOT_FOUND);

		}
		addressDao.delete(optaddress.get());
		return true;
	}

	@Override
	public Address viewAddress(Integer addressId) throws AddressIdException {
		Optional<Address> optaddress = addressDao.findById(addressId);
		if (!optaddress.isPresent()) {
			throw new AddressIdException(ShoppingConstants.ADDRESS_NOT_FOUND);

		}
		return optaddress.get();
	}

	@Override
	public List<Address> viewAllAddress() throws AddressIdException {
		List<Address> addresslist = addressDao.findAll();
		if (addresslist.isEmpty())
			throw new AddressIdException(ShoppingConstants.ADDRESS_NOT_FOUND);
		addresslist.sort((a1, a2) -> a1.getState().compareTo(a2.getState()));
		return addresslist;
	}

}
