package com.springboot.service;

import java.util.List;

import com.springboot.model.Bookings;



public interface BookingService {
	List<Bookings> searchBookings(String code,String userName,boolean condition);
	
	void saveBookings(Bookings booking);
}
