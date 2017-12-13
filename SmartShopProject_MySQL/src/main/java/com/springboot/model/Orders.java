package com.springboot.model;

import java.util.Date;
import java.util.List;


import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {

	@Id
	@Column(name = "OrderID")
	private String orderId;

	@Column(name = "QuatityOrder")
	private int quatityOrder;

	@Column(name = "Amount")
	private Double amount;

	@Column(name = "OrderDate")
	private Date orderDate;

	@Column(name = "Status")
	private String status;

	@Column(name = "Notes")
	private String notes;

	@Column(name = "MobileCustomer")
	private String mobileCustomer;

	@Column(name = "AddressCustomer")
	private String addressCustomer;

	@Column(name = "NameCustomer")
	private String nameCustomer;


	@ManyToOne(optional = false)
	private Users user;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
	private List<OrderDetail> orderDetailList;

	public String getOrderId() {
		return orderId;
	}

	
	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}


	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}


	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
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


	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
