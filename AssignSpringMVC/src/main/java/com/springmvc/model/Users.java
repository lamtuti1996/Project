package com.springmvc.model;

import java.util.Collection;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;





@Entity
@Table(name="Users")
public class Users {
         
	

	
	
	@Id
	@NotEmpty
	@Column(name="Username")
	private String username;
	
	@NotEmpty
	@Column(name="Password")
	private String password;
	
	@Column(name="Fullname")
	private String fullname;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Collection<Bookings> bookings;
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public Collection<Bookings> getBookings() {
		return bookings;
	}


	public void setBookings(Collection<Bookings> bookings) {
		this.bookings = bookings;
	}


	
  	
	
}
