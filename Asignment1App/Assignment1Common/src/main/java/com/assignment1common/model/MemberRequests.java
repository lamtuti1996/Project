package com.assignment1common.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Member_Requests")
public class MemberRequests {

	@Id
	@Column(name = "request_id")
	private int requestID;

	@Column(name = "date_requested")
	private Date dateRequested;

	@Column(name = "date_located")
	private Date dateLocated;

	@Column(name = "other_request_details")
	private String otherRequestDetails;

	@JsonBackReference
	@ManyToOne(optional = false)
	private Members members;

	@JsonBackReference
	@ManyToOne(optional = false)
	private Books books;

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public Date getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}

	public Date getDateLocated() {
		return dateLocated;
	}

	public void setDateLocated(Date dateLocated) {
		this.dateLocated = dateLocated;
	}

	public String getOtherRequestDetails() {
		return otherRequestDetails;
	}

	public void setOtherRequestDetails(String otherRequestDetails) {
		this.otherRequestDetails = otherRequestDetails;
	}

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

}
