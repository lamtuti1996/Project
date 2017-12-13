package com.smartshopcommon.entity;


import java.util.Date;
import java.util.List;



public class OrderInfo {

	private int orderID;
	private Date orderDate;
	private int orderNum;
	private double amount;

	private String email;

	private List<OrderDetailInfo> details;

	public OrderInfo() {

	}

	public OrderInfo(int orderID, Date orderDate, int orderNum, double amount, String email,
			List<OrderDetailInfo> details) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.orderNum = orderNum;
		this.amount = amount;
		this.email = email;
		this.details = details;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<OrderDetailInfo> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetailInfo> details) {
		this.details = details;
	}
}
