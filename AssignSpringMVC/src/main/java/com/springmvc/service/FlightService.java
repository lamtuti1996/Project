package com.springmvc.service;

import java.util.List;

import com.springmvc.dto.FlightPlane;

public interface FlightService {
    
	List<FlightPlane> searchFlight(String fromCity, String toCity, String departure);
	

}
