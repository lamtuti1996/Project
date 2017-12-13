package com.springmvc.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="UsersTable")
public class Users {

	
	@Id
	@NotEmpty
	@Column(name="Username")
	private String username;
	
	@NotEmpty
	@Column(name="Password")
	private String password;
	
	@Column(name="Fullname")
	private String fullname;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Student> studentList;
	


	
	public Users(String username, String password, String fullname) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	
	}






	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}











	public List<Student> getStudentList() {
		return studentList;
	}






	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}






	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}




	
  	
	
}
