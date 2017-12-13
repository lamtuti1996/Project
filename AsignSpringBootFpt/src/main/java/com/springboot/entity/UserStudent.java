package com.springboot.entity;

public class UserStudent {

	private String fullName;
	private int id;
	private String nameMajor;
	private float mark;
	private String username;

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserStudent(String fullName, int id, String nameMajor, float mark, String username) {
		super();
		this.fullName = fullName;
		this.id = id;
		this.nameMajor = nameMajor;
		this.mark = mark;
		this.username = username;
	}

	public UserStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameMajor() {
		return nameMajor;
	}

	public void setNameMajor(String nameMajor) {
		this.nameMajor = nameMajor;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

}
