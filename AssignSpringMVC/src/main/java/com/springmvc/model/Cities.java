package com.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cities")
public class Cities {

	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_SEQ")
//	@SequenceGenerator(name = "CITY_SEQ", sequenceName = "CITY_SEQ", allocationSize = 1)
	@Id	
	@Column(name = "CityID")
	private int cityID;

	@Column(name = "CityName")
	private String cityName;

	public Cities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
