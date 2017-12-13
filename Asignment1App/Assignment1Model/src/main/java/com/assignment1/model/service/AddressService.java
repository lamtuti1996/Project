package com.assignment1.model.service;

import java.util.List;

import com.assignment1common.model.Addresses;



public interface AddressService {
	List<Addresses> getAllAddress();

	Addresses getAdressById(int id);

	void saveAddress(Addresses a);
	
	void deleteAdress(int id);
}
