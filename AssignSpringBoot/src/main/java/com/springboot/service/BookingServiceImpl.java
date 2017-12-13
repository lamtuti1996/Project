package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.BookingRespository;
import com.springboot.model.Bookings;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingRespository repository;
	
	@Override
	public List<Bookings> searchBookings(String code, String userName, boolean condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveBookings(Bookings booking) {
		// TODO Auto-generated method stub
		
	}

}
