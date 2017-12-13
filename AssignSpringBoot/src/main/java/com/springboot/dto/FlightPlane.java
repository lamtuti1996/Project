package com.springboot.dto;

import java.sql.Timestamp;
import java.util.Date;

public class FlightPlane {

	private int flightID;
	private String fromCity;
	private String toCity;
	private float duration;
	private String planeID;
	private float fare;
	private String departTime;
	private Date departDate;

	public FlightPlane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightPlane(int flightID, String fromCity, String toCity, float duration, String planeID, float fare,
			String departTime, Date departDate) {
		super();
		this.flightID = flightID;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.duration = duration;
		this.planeID = planeID;
		this.fare = fare;
		this.departTime = departTime;
		this.departDate = departDate;
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

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

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public String getPlaneID() {
		return planeID;
	}

	public void setPlaneID(String planeID) {
		this.planeID = planeID;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public Date getDepartDate() {
		return departDate;
	}

	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}

	
}
