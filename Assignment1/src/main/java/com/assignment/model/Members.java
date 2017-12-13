package com.assignment.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "Members")
public class Members {

	@Id
	@Column(name = "member_id")
	private int memberID;

	@Column(name = "gender")
	private String gender;

	@Column(name = "member_first_name")
	private String memberFirstName;

	@Column(name = "member_last_name")
	private String memberLastName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "other_member_details")
	private String otherMemberDetails;

	@ManyToOne(optional = false)
	private Addresses addresses;

	@OneToMany(mappedBy = "members", fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<MemberRequests> memberRequestList;

	public List<MemberRequests> getMemberRequestList() {
		return memberRequestList;
	}

	public void setMemberRequestList(List<MemberRequests> memberRequestList) {
		this.memberRequestList = memberRequestList;
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

	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}
	

}
