package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.CityDAO;

import com.springmvc.model.Cities;

@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDAO dao;


	public List<Cities> findAllCity() {

		return dao.getAllCity();
	}

	
	public void addCity(Cities city) {
		dao.addCity(city);
		
	}

}
