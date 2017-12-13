package com.demo.struts.entity;

import java.util.List;



public class Orders {
	private String orderID;

	private String addressCustomer;

	private double amount;

	private String mobileCustomer;

	private String nameCustomer;

	private String notes;

	private String orderDate;

	private int quatityOrder;

	private String status;

	private List<OrderDetail> orderDetailList;
	
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMobileCustomer() {
		return mobileCustomer;
	}

	public void setMobileCustomer(String mobileCustomer) {
		this.mobileCustomer = mobileCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuatityOrder() {
		return quatityOrder;
	}

	public void setQuatityOrder(int quatityOrder) {
		this.quatityOrder = quatityOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	
	

}
