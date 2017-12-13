package com.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "News")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEWS_SEQ")
	@SequenceGenerator(name = "NEWS_SEQ", sequenceName = "NEWS_SEQ", allocationSize = 1)
	@Column(name = "NewsID")
	private int newsID;

	@Column(name = "Title")
	private String title;

	@Column(name = "Content")
	private String content;

	@Column(name = "CreateDate")
	private Date createDate;

	@ManyToOne(optional = false)
	private CategoriesNews categoryNews;

	public CategoriesNews getCategoryNews() {
		return categoryNews;
	}

	public void setCategoryNews(CategoriesNews categoryNews) {
		this.categoryNews = categoryNews;
	}

	public int getNewsID() {
		return newsID;
	}

	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
