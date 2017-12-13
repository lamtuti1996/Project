package com.smartshopcommon.entity;

public class OrderSave {
	private String email;
	private CartInfo myCart;
	private Customer customer;

	public OrderSave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CartInfo getMyCart() {
		return myCart;
	}

	public void setMyCart(CartInfo myCart) {
		this.myCart = myCart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
