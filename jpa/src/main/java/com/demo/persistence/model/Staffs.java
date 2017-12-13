package com.demo.persistence.model;

import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Staffs")
public class Staffs {

	@Id
	private String id;
	private String name;
	private String gender;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date birthday;
	private String photo;
	private String email;
	private String phone;
	private float salary;
	
	private String notes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DepartId")
	private Departs depart;

	@OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
	private Collection<Records> records;

	
	
	
	public Staffs() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}



	public Departs getDepart() {
		return depart;
	}

	public void setDepart(Departs depart) {
		this.depart = depart;
	}

	public Collection<Records> getRecords() {
		return records;
	}

	public void setRecords(Collection<Records> records) {
		this.records = records;
	}

	
}
