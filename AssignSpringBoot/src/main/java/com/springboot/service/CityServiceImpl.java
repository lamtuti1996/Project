package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.CityRespository;
import com.springboot.model.Cities;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRespository repository;
	
	@Override
	public List<Cities> findAllCity() {
		return repository.findAll();
	}

}
