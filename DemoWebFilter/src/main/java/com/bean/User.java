package com.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

	private int userId;

	@NotNull
	@NotEmpty(message = "Tên bạn không được để trống.")
	private String name;
	@NotNull
	@Size(min = 6, message = "Mật khẩu bạn cần nhập ít nhất 6 ký tự.")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String password, int userId) {
		this.name = name;
		this.password = password;
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setStudentId(int userId) {
		this.userId = userId;
	}
	
	public static void main(String[] args) {
		String s="abc";
		String s2="abcdfe";
		System.out.println(s2.contains(s));
	}
}
