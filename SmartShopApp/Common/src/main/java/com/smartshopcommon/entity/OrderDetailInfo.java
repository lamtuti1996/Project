package com.smartshopcommon.entity;

public class OrderDetailInfo {
	private String id;

	private String productID;
	private String productName;

	private int quanity;
	private double price;
	private double amount;

	public OrderDetailInfo() {

	}

	public OrderDetailInfo(String id, String productID, String productName, int quanity, double price, double amount) {
		super();
		this.id = id;
		this.productID = productID;
		this.productName = productName;
		this.quanity = quanity;
		this.price = price;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
