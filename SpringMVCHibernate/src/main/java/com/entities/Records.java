package com.entities;

import java.util.Date;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Records")
public class Records {
       
	
	@Id
	@GeneratedValue
	private int id;
	private String type;
	
	@Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern="dd/MM/yyyy") 
	private Date date;
	private String staffID;
	
	
	@ManyToOne
	   @JoinColumn(name="Staffs")
	   private Staffs staff;


	public Records() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Records(int id, String type, Date date, String staffID, Staffs staff) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
		this.staffID = staffID;
		this.staff = staff;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getStaffID() {
		return staffID;
	}


	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}


	public Staffs getStaff() {
		return staff;
	}


	public void setStaff(Staffs staff) {
		this.staff = staff;
	}
	
	
}
