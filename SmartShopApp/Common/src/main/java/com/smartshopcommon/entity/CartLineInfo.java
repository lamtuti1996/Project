package com.smartshopcommon.entity;



public class CartLineInfo {
	private ProductInfo productInfo;
	private int quantity;
	private double totalPrice;

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public double getTotalPrice() {
		return this.productInfo.getPrice() * this.quantity;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CartLineInfo() {
		this.quantity = 0;
	}

	public ProductInfo getProducs() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo product) {
		this.productInfo = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return this.productInfo.getPrice() * this.quantity;
	}
}
