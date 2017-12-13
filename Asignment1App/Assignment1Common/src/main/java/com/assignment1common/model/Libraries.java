package com.assignment1common.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Libraries")
public class Libraries implements java.io.Serializable {

	@Id
	@Column(name = "library_id")
	private int libraryID;

	@Column(name = "library_name")
	private String libraryName;

	@Column(name = "library_details")
	private String libraryDetails;

	@JsonBackReference
	@ManyToOne(optional = false)
	private Addresses addresses;

	public int getLibraryID() {
		return libraryID;
	}

	public void setLibraryID(int libraryID) {
		this.libraryID = libraryID;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryDetails() {
		return libraryDetails;
	}

	public void setLibraryDetails(String libraryDetails) {
		this.libraryDetails = libraryDetails;
	}

	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}

}
