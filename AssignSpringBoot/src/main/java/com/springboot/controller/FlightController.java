package com.springboot.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.dto.FlightPlane;
import com.springboot.dto.FlightSearchDTO;
import com.springboot.model.Cities;
import com.springboot.service.CityService;
import com.springboot.service.FlightService;

@Controller
@RequestMapping("flight")
public class FlightController {

	@Autowired
	FlightService flightService;
	
	@Autowired
	CityService cityService;

/*	@RequestMapping(value = "/searchFligh", method = RequestMethod.POST)
	public String search(@ModelAttribute("flightsearchDTO") FlightSearchDTO searchDTO, ModelMap model) {
		
		List<FlightPlane> listFlight = flightService.searchFlight("Ha Noi", "Huw",
				"29-AUG-17 02.55.58.000000000 AM");
		model.addAttribute(listFlight);
		return "Bookings";
	}*/
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() throws ParseException {
		String str_date = "2017-08-29"; 
		Timestamp ts = null; 
		DateFormat	formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) formatter.parse(str_date);
		if (date != null) { // simple null check
			ts = new Timestamp(date.getTime()); 
		}
		System.out.println(ts);
		List<FlightPlane> listFlight = flightService.searchTest("Ha Noi", "Hue", ts);
		System.out.println("sizeFlight:"+listFlight.size());
		return "";
	}



	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {

		List<Cities> listCity = cityService.findAllCity();
	       
		
		model.addAttribute("listCity", listCity);
		model.addAttribute("flightsearchDTO", new FlightSearchDTO());
		return "Home";
	}

}


