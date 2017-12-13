package com.demo.persistence.model;

import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name = "Departs")
public class Departs {

	@Id
	private String id;
	private String name;

	@OneToMany(mappedBy = "depart", fetch = FetchType.EAGER)
	private Collection<Staffs> staffs;



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

	
	
	public Collection<Staffs> getStaffs() {
		return staffs;
	}

	public void setStaffs(Collection<Staffs> staffs) {
		this.staffs = staffs;
	}

	public Departs() {
		super();
		// TODO Auto-generated constructor stub
	}



}
