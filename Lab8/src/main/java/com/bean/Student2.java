package com.bean;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;

public class Student2 {
	@NotBlank(message="Không được để trống họ và tên !")
	 private String name;
	
	@NotNull(message="Không được để trống điểm !")
	@DecimalMin(value="0", message="Điểm không hợp lệ !")
	@DecimalMax(value="10", message="Điểm không hợp lệ !")
	   private double mark;
	
	@NotNull(message="Vui lòng chọn chuyên ngành !")
	   private String major;
	public Student2(String name, double mark, String major) {
		super();
		this.name = name;
		this.mark = mark;
		this.major = major;
	}
	public Student2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	   
	   
}
