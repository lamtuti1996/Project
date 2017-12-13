package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OrderDetail")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERDETAIL_SEQ")
	@SequenceGenerator(name = "ORDERDETAIL_SEQ", sequenceName = "ORDERDETAIL_SEQ", allocationSize = 1)
	@Column(name = "OrderDetailID")
	private int orderDetailID;

	@ManyToOne(optional = false)
	private Products product;

	@ManyToOne(optional = false)
	private Orders order;

	@Column(name = "Quanity")
	private int quanity;

	@Column(name = "Price")
	private double price;

	@Column(name = "Amount")
	private double amount;

	
	
	public int getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
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
