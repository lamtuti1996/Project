package com.assignment1common.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Addresses")
public class Addresses {

	@Id
	@Column(name = "address_id")
	private int addressID;

	@Column(name = "line_1_number_building")
	private String line1NumberBuilding;

	@Column(name = "line_2_number_street")
	private String line2NunberStreet;

	@Column(name = "line_3_area_locality")
	private String line3AreaLocality;

	@Column(name = "city")
	private String city;

	@Column(name = "zip_postcode")
	private String zipPostCode;

	@Column(name = "state_province_country")
	private String stateProvinceCountry;

	@Column(name = "country")
	private String country;

	@Column(name = "other_address_details")
	private String otherAddressDetails;

	@JsonManagedReference
	@OneToMany(mappedBy = "addresses", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Libraries> libraryList;

	@JsonManagedReference
	@OneToMany(mappedBy = "addresses", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Members> memberList;

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getLine1NumberBuilding() {
		return line1NumberBuilding;
	}

	public void setLine1NumberBuilding(String line1NumberBuilding) {
		this.line1NumberBuilding = line1NumberBuilding;
	}

	public String getLine2NunberStreet() {
		return line2NunberStreet;
	}

	public void setLine2NunberStreet(String line2NunberStreet) {
		this.line2NunberStreet = line2NunberStreet;
	}

	public String getLine3AreaLocality() {
		return line3AreaLocality;
	}

	public void setLine3AreaLocality(String line3AreaLocality) {
		this.line3AreaLocality = line3AreaLocality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipPostCode() {
		return zipPostCode;
	}

	public void setZipPostCode(String zipPostCode) {
		this.zipPostCode = zipPostCode;
	}

	public String getStateProvinceCountry() {
		return stateProvinceCountry;
	}

	public void setStateProvinceCountry(String stateProvinceCountry) {
		this.stateProvinceCountry = stateProvinceCountry;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOtherAddressDetails() {
		return otherAddressDetails;
	}

	public void setOtherAddressDetails(String otherAddressDetails) {
		this.otherAddressDetails = otherAddressDetails;
	}

	public List<Libraries> getLibraryList() {
		return libraryList;
	}

	public void setLibraryList(List<Libraries> libraryList) {
		this.libraryList = libraryList;
	}

	public List<Members> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Members> memberList) {
		this.memberList = memberList;
	}

}
