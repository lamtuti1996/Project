package com.springmvc.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Users")
public class Users {
         
	
	@Id
	@Column(name="UserID")
	private int userId;
	
	@NotEmpty
	@Column(name="Username")
	private String username;
	
	@NotEmpty
	@Column(name="Password")
	private String password;
	
	@Column(name="Fullname")
	private String fullname;
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Users(int userId, String username, String password, String fullname) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
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
	
	
  	
	
}
