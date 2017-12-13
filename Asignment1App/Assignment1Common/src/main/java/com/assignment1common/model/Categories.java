package com.assignment1common.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "Categories")
public class Categories {

	@Id
	@Column(name = "category_id")
	private int categoryID;

	@Column(name = "category_name")
	private String categoryName;

	@JsonBackReference
	@ManyToMany(mappedBy = "categories")
	private Set<Books> books;

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

	public Set<Books> getBooks() {
		return books;
	}

	public void setBooks(Set<Books> books) {
		this.books = books;
	}

}
