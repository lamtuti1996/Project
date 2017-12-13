package com.springboot.model;

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

@Entity
@Table(name="CategoriesNews")
public class CategoriesNews {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORYNEWS_SEQ")
	@SequenceGenerator(name = "CATEGORYNEWS_SEQ", sequenceName = "CATEGORYNEWS_SEQ", allocationSize = 1)
	@Column(name = "CategoryID")
	private int categoryID;

	@Column(name = "CategoryName")
	private String categoryName;

	@OneToMany(mappedBy = "categoryNews", fetch = FetchType.EAGER)
	private List<News> newsList;

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

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

}
