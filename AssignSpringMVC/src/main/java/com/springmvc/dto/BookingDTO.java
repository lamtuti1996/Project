package com.springmvc.dto;

public class BookingDTO {
	private String bookingID;
   private String username;
	private String planeID;
	private String bookingDate;
	private String bookingTime;
	private String reservationCode;

	private String fullName;

	private int flightID;
	private float fare;
	private String departureDate;
	private String departureTime;
	private String fromCity;
	private String toCity;
	private float duration;

	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingDTO(String bookingID, String username, String planeID, String bookingDate, String bookingTime,
			String reservationCode, String fullName, int flightID, float fare, String departureDate,
			String departureTime, String fromCity, String toCity, float duration) {
		super();
		this.bookingID = bookingID;
		this.username = username;
		this.planeID = planeID;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.reservationCode = reservationCode;
		this.fullName = fullName;
		this.flightID = flightID;
		this.fare = fare;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.duration = duration;
	}

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPlaneID() {
		return planeID;
	}

	public void setPlaneID(String planeID) {
		this.planeID = planeID;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getReservationCode() {
		return reservationCode;
	}

	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
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

	
}
