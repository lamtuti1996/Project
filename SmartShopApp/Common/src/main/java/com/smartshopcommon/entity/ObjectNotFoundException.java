package com.smartshopcommon.entity;

public class ObjectNotFoundException extends RuntimeException{
	private String id;

	
	
	public ObjectNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ObjectNotFoundException(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
