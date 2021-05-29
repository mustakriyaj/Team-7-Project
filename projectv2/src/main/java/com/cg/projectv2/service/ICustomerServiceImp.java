package com.cg.projectv2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.cg.projectv2.model.Address;
import com.cg.projectv2.model.Customer;
import com.cg.projectv2.repository.IAddressRepository;
import com.cg.projectv2.repository.ICustomerRepository;

@Service
public class ICustomerServiceImp implements ICustomerService
{
	@Autowired
	ICustomerRepository repository;
	@Autowired
	IAddressRepository repository1;
	@Override
	public Customer addCustomer(Customer cust) {
		Optional<Customer> findById = repository.findById(cust.getCustomerId());
		if(!findById.isPresent()) {
			return repository.save(cust);
		}
		
		return cust;
//		else
//			throw new AddressException("Address already present");
	}

	public Address updateAddress(Address add) {
		Optional<Address> findById = repository1.findById(add.getAddressId());
		if(findById.isPresent())
		{
			add.setStreetNo(add.getStreetNo());
			add.setBuildingName(add.getBuildingName());
			add.setCity(add.getCity());
			add.setState(add.getState());
			add.setCountry(add.getCountry());
			add.setPincode(add.getPincode());
			add.setCustomer(add.getCustomer());
			add.setOrd(add.getOrd());
			repository1.save(add);
			}
		return null;
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		Optional<Customer> findById = repository.findById(cust.getCustomerId());
		if(findById.isPresent())
		{
			//cust.setCustomerId(cust.getCustomerId());
			cust.setFirstName(cust.getFirstName());
			cust.setLastName(cust.getLastName());
			cust.setMobileNumber(cust.getMobileNumber());
			cust.setEmail(cust.getEmail());
			cust.setUser(cust.getUser());
			cust.setAddress(cust.getAddress());
			cust.setCart(cust.getCart());
			cust.setOrd(cust.getOrd());
			
			repository.save(cust);
		}
		/*else
			throw new RecordNotFoundException("No Record Found");
	}*/
		return null;
	}

	@Override
	public Customer removeCustomer(Customer cust) {
		Optional<Customer> findById = repository.findById(cust.getCustomerId());
		if(findById.isPresent()) {
			Customer c = findById.get();
			repository.delete(cust);
			return c;
			}
		return cust;
	}

	@Override
	public Customer viewCustomer(Customer cust) {
		Optional<Customer> findById = repository.findById(cust.getCustomerId());
		if(findById.isPresent()) {
			return findById.get();
		}
		return cust;
//		else 
//			throw new CustomerException("Customer not found");
	}

//	@Override
//	public List<Customer> ViewAllCustomers(String location) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
