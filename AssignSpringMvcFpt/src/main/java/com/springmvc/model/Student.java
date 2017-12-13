package com.springmvc.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "StudentTable")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTTBL_SEQ")
	@SequenceGenerator(name = "STUDENTTBL_SEQ", sequenceName = "STUDENTTBL_SEQ", allocationSize = 1)
	@Column(name = "Id")
	private int id;

	@Column(name = "Major")
	private String nameMajor;

	@Column(name = "Mark")
	private float mark;
	

/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Username")
	private Users user;*/
	

	@ManyToOne(optional = false)
	private Users user;

	@JsonCreator
	public Student(@JsonProperty("id") int id, @JsonProperty("nameMajor") String nameMajor,
			@JsonProperty("mark") float mark) {
		super();
		this.id = id;
		this.nameMajor = nameMajor;
		this.mark = mark;

	}
	
	

	public Student( String nameMajor, float mark, Users user) {
		
		this.id = id;
		this.nameMajor = nameMajor;
		this.mark = mark;
		this.user = user;
	}



	public Student(int id, String nameMajor, float mark, Users user) {
		super();
		this.id = id;
		this.nameMajor = nameMajor;
		this.mark = mark;
		this.user = user;
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
