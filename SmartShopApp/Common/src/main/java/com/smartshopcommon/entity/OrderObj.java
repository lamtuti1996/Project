package com.smartshopcommon.entity;

import java.util.Date;

import javax.persistence.Column;

public class OrderObj {
	private String orderId;

	private int quatityOrder;

	private Double amount;

	private Date orderDate;

	private String status;

	private String notes;

	private String mobileCustomer;

	private String addressCustomer;

	private String nameCustomer;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getQuatityOrder() {
		return quatityOrder;
	}

	public void setQuatityOrder(int quatityOrder) {
		this.quatityOrder = quatityOrder;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getMobileCustomer() {
		return mobileCustomer;
	}

	public void setMobileCustomer(String mobileCustomer) {
		this.mobileCustomer = mobileCustomer;
	}

	public String getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

}
