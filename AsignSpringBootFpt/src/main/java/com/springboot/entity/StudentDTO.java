package com.springboot.entity;

public class StudentDTO {
	
	private int id;
	
	private String nameMajor;
	
	private float mark;
	
	private String username;

	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public StudentDTO(int id, String nameMajor, float mark, String username) {
		super();
		this.id = id;
		this.nameMajor = nameMajor;
		this.mark = mark;
		this.username = username;
	}

	public StudentDTO(String nameMajor, float mark) {
		super();
		this.nameMajor = nameMajor;
		this.mark = mark;
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
