package com.entities;

import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name = "Departs")
public class Departs {

	@Id
	private String id;
	private String name;

	@OneToMany(mappedBy = "Departs", fetch = FetchType.EAGER)
	private Collection<Staffs> staff;

	public Departs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departs(String id, String name, Collection<Staffs> staff) {
		super();
		this.id = id;
		this.name = name;
		this.staff = staff;
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

	public Collection<Staffs> getStaff() {
		return staff;
	}

	public void setStaff(Collection<Staffs> staff) {
		this.staff = staff;
	}

}
