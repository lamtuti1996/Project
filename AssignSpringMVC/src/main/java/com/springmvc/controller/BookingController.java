package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.common.Common;
import com.springmvc.model.Bookings;
import com.springmvc.service.BookingsService;

@Controller
public class BookingController {

	@Autowired
	BookingsService bookingService;

	

	@RequestMapping(value = { "/addBooking/{id}" }, method = RequestMethod.GET)
	public String addBooking(@PathVariable String planeID, ModelMap model) {
       Common common =new Common();
		
		String bookingDate = common.getDate();
	
		String bookingTime = common.getTime();
		String code = common.genRand();
		int userID = 0;

		Bookings booking = new Bookings();

		bookingService.saveBookings(booking);

		return "SearchBooking";

	}

	@RequestMapping(value = { "/searchBooking/{id}" }, method = RequestMethod.GET)
	public String searchBooking(@PathVariable String code, ModelMap model) {
		List<Bookings> listBooking = null;
		if (code.equals("") || code == null) {
			String userName="";
			listBooking = bookingService.searchBookings("", userName, true);

		} else {
			listBooking = bookingService.searchBookings(code, "", false);
		}
        
		model.addAttribute("listBooking",listBooking);
		return "ManageBooking";

	}

}
