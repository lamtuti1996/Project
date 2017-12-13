package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.FlightDAO;
import com.springmvc.dto.FlightPlane;

@Service("flightService")
@Transactional
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightDAO dao;
	

	public List<FlightPlane> searchFlight(String fromCity, String toCity, String departure) {
		return	dao.searchFlight(fromCity, toCity, departure);
		
	}

}
