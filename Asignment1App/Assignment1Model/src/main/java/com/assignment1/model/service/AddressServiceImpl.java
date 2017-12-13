package com.assignment1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.assignment1.model.dao.DataDAO;
import com.assignment1common.model.Addresses;



@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	DataDAO dao;

	@Override
	public List<Addresses> getAllAddress() {
		// TODO Auto-generated method stub
		return dao.getAddress();
	}

	@Override
	public Addresses getAdressById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAddress(Addresses a) {
		dao.addAddresses(a);

	}

	@Override
	public void deleteAdress(int id) {
		dao.deleteAddress(id);
		
	}

}
