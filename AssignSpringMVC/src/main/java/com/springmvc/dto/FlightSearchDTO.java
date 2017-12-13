package com.springmvc.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FlightSearchDTO {

	private String  fromCity;
	private String toCity;
	// @DateTimeFormat (pattern="yyyy-MM-dd HH:mm:ss")
	private String departureDate;

	

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

}
