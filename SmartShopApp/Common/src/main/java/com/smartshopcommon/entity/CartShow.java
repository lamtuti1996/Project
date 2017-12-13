package com.smartshopcommon.entity;

public class CartShow {
	private String image;
	private String name;
	private int quality;
	private float price;
	private float totalPrice;

	public CartShow(String image, String name, int quality, float price, float totalPrice) {
		super();
		this.image = image;
		this.name = name;
		this.quality = quality;
		this.price = price;
		this.totalPrice = totalPrice;
	}

	public CartShow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
