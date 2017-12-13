package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.dto.FlightPlane;
import com.springmvc.dto.FlightSearchDTO;
import com.springmvc.model.Users;
import com.springmvc.service.FlightService;

@Controller
public class FlightController {

	@Autowired
	FlightService fligtService;

	@RequestMapping(value = "/searchFligh", method = RequestMethod.POST)
	@ResponseBody
	public String search(@ModelAttribute("flightsearchDTO") FlightSearchDTO searchDTO, ModelMap model) {
		List<FlightPlane> listFlight = fligtService.searchFlight(searchDTO.getFromCity(), searchDTO.getToCity(),
				searchDTO.getDepartureDate());
		model.addAttribute(listFlight);
		return "Bookings";
	}

	@RequestMapping(value = "/searchFlighForm", method = RequestMethod.GET)
	public String searchfrm(@ModelAttribute("flightsearchDTO") FlightSearchDTO searchDTO) {

		return "Home";
	}

}
