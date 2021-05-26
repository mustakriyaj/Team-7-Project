package com.cg.projectv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.projectv2.model.Address;

public interface IAddressRepository extends JpaRepository<Address,Integer>{
	/*public Address AddAddress(Address add);
	public Address updateAddress(Address add);
	public Address removeAddress(Address add);
	public List<Address> viewAllAddress(String id);
	public Address viewAddress(Address add);
	*/
}
