package com.assignment1common.entity;

import java.util.Date;

public class MemberMemberRequestBook {
	private int memberID;

	private String gender;

	private String memberFirstName;

	private String memberLastName;

	private String phoneNumber;

	private String emailAddress;

	private String otherMemberDetails;

	private int requestID;

	private Date dateRequested;

	private Date dateLocated;

	private String otherRequestDetails;

	private int isbn;

	private String bookTitle;

	private Date dateOfPublication;

	public MemberMemberRequestBook(int memberID, String gender, String memberFirstName, String memberLastName,
			String phoneNumber, String emailAddress, int requestID, String bookTitle) {
		super();
		this.memberID = memberID;
		this.gender = gender;
		this.memberFirstName = memberFirstName;
		this.memberLastName = memberLastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;

		this.requestID = requestID;
		this.dateRequested = dateRequested;
		this.dateLocated = dateLocated;

		this.bookTitle = bookTitle;
	}

	public MemberMemberRequestBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMemberFirstName() {
		return memberFirstName;
	}

	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}

	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getOtherMemberDetails() {
		return otherMemberDetails;
	}

	public void setOtherMemberDetails(String otherMemberDetails) {
		this.otherMemberDetails = otherMemberDetails;
	}

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

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

}
