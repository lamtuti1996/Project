package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Cities;


public interface CityService {

	List<Cities> findAllCity();
	
	void addCity(Cities city);

}
