package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Bookings;


public interface BookingsService {

	void saveBookings(Bookings booking);
	
	List<Bookings> searchBookings(String code,String userName,boolean condition);
}
