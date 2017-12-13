package com.demo.persistence.model;
import javax.persistence.*;

@Entity
@Table(name="Users1")
public class Users {
	
	@Id
	private String username;
	
	private String password;
	private String fullname;
	
	
	
	
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
	
	

}
