package com.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Bookings")
public class Bookings {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKING_SEQ")
//	@SequenceGenerator(name = "BOOKING_SEQ", sequenceName = "BOOKING_SEQ", allocationSize = 1)
	@Column(name="BookingID")
	private int bookingID;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username")
	private Users user;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "planeID")
	private Plane plane;
	
	
	@Column(name="BookingDate")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date BookingDate;
	
	
	@Column(name="BookingTime")
	private String BookingTime;
	
	
	@Column(name="ReservationCode")
    private String reservationCode;
	
	

	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}





	public int getBookingID() {
		return bookingID;
	}



	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}






	public Users getUser() {
		return user;
	}





	public void setUser(Users user) {
		this.user = user;
	}







	public Plane getPlane() {
		return plane;
	}





	public void setPlane(Plane plane) {
		this.plane = plane;
	}









	public Date getBookingDate() {
		return BookingDate;
	}





	public void setBookingDate(Date bookingDate) {
		BookingDate = bookingDate;
	}





	public String getBookingTime() {
		return BookingTime;
	}





	public void setBookingTime(String bookingTime) {
		BookingTime = bookingTime;
	}





	public String getReservationCode() {
		return reservationCode;
	}



	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}

	
	
	
	

}
