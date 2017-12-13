package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="CitiesTBL")
public class Cities {
	
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_SEQ")
//	@SequenceGenerator(name = "CITY_SEQ", sequenceName = "CITY_SEQ", allocationSize = 1)
	@Id
	@Column(name="CityID")
	private int cityID;
	
	
	@Column(name="CityName")
	private String cityName;


	public Cities() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cities(int cityID, String cityName) {
		super();
		this.cityID = cityID;
		this.cityName = cityName;
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
