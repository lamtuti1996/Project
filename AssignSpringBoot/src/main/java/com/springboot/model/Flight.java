package com.springboot.model;
import java.util.Collection;

import javax.persistence.*;



@Entity
@Table(name="FlightTBL")
public class Flight {
	
	

//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLIGHT_SEQ")
//	@SequenceGenerator(name = "FLIGHT_SEQ", sequenceName = "FLIGHT_SEQ", allocationSize = 1)
	@Id
	@Column(name="FlightID")
	private int flightID;
	
	
	@Column(name="FromCity")
	private String fromCity;
	
	@Column(name="ToCity")
	private String toCity;
	
	
	@Column(name="Duration")
	private float duration;

	@OneToMany(mappedBy = "flight", fetch = FetchType.EAGER)
	private Collection<Plane> plane;

	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Flight(int flightID, String fromCity, String toCity, float duration, Collection<Plane> plane) {
		super();
		this.flightID = flightID;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.duration = duration;
		this.plane = plane;
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


	public Collection<Plane> getPlane() {
		return plane;
	}


	public void setPlane(Collection<Plane> plane) {
		this.plane = plane;
	}


	
	
}
