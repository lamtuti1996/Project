package com.springboot.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="PlaneTBL")
public class Plane {

	@Id
	@Column(name="PlaneID")
	private String planeID;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FlightID")
	private Flight flight;
	
	@Column(name="Fare")
	private float fare;
	
	@Column(name="DepartureTime")
	private String departureTime;
	
    
	@Column(name="DepartureDate")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date departureDate;
	
	
	@OneToMany(mappedBy = "plane", fetch = FetchType.EAGER)
	private Collection<Bookings> bookings;

	

	public Plane() {
		super();
		// TODO Auto-generated constructor stub
	}






	public String getPlaneID() {
		return planeID;
	}



	public void setPlaneID(String planeID) {
		this.planeID = planeID;
	}






	public Flight getFlight() {
		return flight;
	}






	public void setFlight(Flight flight) {
		this.flight = flight;
	}






	public float getFare() {
		return fare;
	}



	public void setFare(float fare) {
		this.fare = fare;
	}



	public String getDepartureTime() {
		return departureTime;
	}



	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}



	public Date getDepartureDate() {
		return departureDate;
	}



	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}



	public Collection<Bookings> getBookings() {
		return bookings;
	}



	public void setBookings(Collection<Bookings> bookings) {
		this.bookings = bookings;
	}

	
	
	
	
	
}
