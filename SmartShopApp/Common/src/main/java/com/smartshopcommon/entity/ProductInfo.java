package com.smartshopcommon.entity;



public class ProductInfo {

	private int productID;

	private String productName;

	private float price;

	private String description;

	private String imageURL;

	private int quality;

	private String status;

	public ProductInfo(ProductObj p) {
		super();
		this.productID = p.getProductID();
		this.productName = p.getProductName();
		this.price = p.getPrice();
		this.description = p.getDescription();
		this.imageURL = p.getImageURL();
		this.quality = p.getQuality();
		this.status = p.getStatus();
	}

	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
