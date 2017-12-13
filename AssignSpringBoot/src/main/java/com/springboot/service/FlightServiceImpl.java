package com.springboot.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.FlightRespository;
import com.springboot.dto.FlightPlane;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRespository flightRespository;

	@Override
	public List<FlightPlane> searchFlight(String fromCity, String toCity, Date departure) {

		return flightRespository.findAllByFromCityAndToCityAndPlaneDepartureDate(fromCity, toCity, departure);
	}

	/*
	 * @Override public List<FlightPlane> searchTest(String xfromCity, String
	 * xtoCity, String time) { List<Object> list =
	 * flightRespository.findByFromCityAndToCityAndPlaneDepartureTime(xfromCity,
	 * xtoCity, time); List<FlightPlane> listSearch = new ArrayList<FlightPlane>();
	 * 
	 * for (Object obj : list) { HashMap<?, ?> map = (HashMap<?, ?>) obj;
	 * 
	 * int flightID = Integer.valueOf(map.get("flightID").toString());
	 * 
	 * String fromCity = String.valueOf(map.get("fromCity"));
	 * 
	 * String toCity = String.valueOf(map.get("toCity"));
	 * 
	 * float duration = Integer.valueOf(map.get("duration").toString());
	 * 
	 * String planeID = String.valueOf(map.get("planeID"));
	 * 
	 * float fare = Float.valueOf(map.get("fare").toString());
	 * 
	 * String departTime = String.valueOf(map.get("departTime"));
	 * 
	 * String departDate = String.valueOf(map.get("departDate"));
	 * 
	 * FlightPlane fp = new FlightPlane(flightID, fromCity, toCity, duration,
	 * planeID, fare, departTime, departDate); listSearch.add(fp);
	 * 
	 * }; return listSearch; }
	 */
	@Override
	public List<FlightPlane> searchTest(String xfromCity, String xtoCity, Timestamp date) {
		List<Object> list = flightRespository.findByFromCityAndToCityAndPlaneDepartureTime(xfromCity, xtoCity, date);
		List<FlightPlane> listSearch = new ArrayList<FlightPlane>();

		for (Iterator<Object> it = list.iterator(); it.hasNext();) {
			Object[] object = (Object[]) it.next();

			int flightID = Integer.parseInt(object[0].toString());

			String fromCity = (String) object[1];
			String toCity = (String) object[2];
			float duration = Float.parseFloat(object[3].toString());
			String planeID = (String) object[4];
			float fare = Float.parseFloat(object[5].toString());
			String departTime = (String) object[6];
			
			String temp =object[7].toString();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			Date startDate = null;
			try {
				startDate = df.parse(temp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			Date departDate =startDate;
			System.out.println("1"+departDate);
			FlightPlane fp = new FlightPlane(flightID, fromCity, toCity, duration, planeID, fare, departTime,
					departDate);
			listSearch.add(fp);
		}
		
		return listSearch;
	}

}
