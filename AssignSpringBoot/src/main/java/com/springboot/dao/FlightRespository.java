package com.springboot.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.dto.FlightPlane;
import com.springboot.model.Flight;

public interface FlightRespository extends JpaRepository<Flight, Integer> {

	public final static String QUERY_TEST = "select f.flightID, f.fromCity, f.toCity, f.duration, p.planeID, p.fare, p.departureTime ,p.departureDate"
			+ "  from Flight f , Plane p   "
			+ " where f.flightID = p.flight and f.fromCity = :fromCity and f.toCity = :toCity and p.departureDate = :date";

	List<FlightPlane> findAllByFromCityAndToCityAndPlaneDepartureDate(String fromCity, String toCity, Date date);

	@Query(QUERY_TEST)
	public List<Object> findByFromCityAndToCityAndPlaneDepartureTime(@Param("fromCity") String fromCity,
			@Param("toCity") String toCity, @Param("date") Timestamp date);

	
	//public List<?> findByFromCityAndToCityAndPlaneDepartureTime (String fromCity,String toCity,  String time);
}
