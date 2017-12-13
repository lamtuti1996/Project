package com.springboot.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.springboot.dto.FlightPlane;



public interface FlightService {
	List<FlightPlane> searchFlight(String fromCity, String toCity, Date departure);
	
	List<FlightPlane> searchTest(String fromCity, String toCity,Timestamp date);
}
