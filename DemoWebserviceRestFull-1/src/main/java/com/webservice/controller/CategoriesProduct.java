package com.webservice.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table
@Entity(name="CategoriesProduct")
public class CategoriesProduct {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="CategoryID")
	private int categoryID;
	
	@Column(name="CategoryName")
	private String categoryName;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "categoryProduct", fetch = FetchType.EAGER)
	private List<Products> productList;

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Products> getProductList() {
		return productList;
	}

	public void setProductList(List<Products> productList) {
		this.productList = productList;
	}
	
	
	
}
