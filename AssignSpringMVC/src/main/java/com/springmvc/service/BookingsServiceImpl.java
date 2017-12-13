package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.BookingsDAO;
import com.springmvc.model.Bookings;

@Service("bookingService")
@Transactional
public class BookingsServiceImpl implements BookingsService {

	@Autowired
	BookingsDAO dao;

	public void saveBookings(Bookings booking) {
		dao.addBooking(booking);

	}

	
	public List<Bookings> searchBookings(String code, String userName, boolean condition) {
	
		return dao.searchBookings(code, userName, condition);
	}

	

}
