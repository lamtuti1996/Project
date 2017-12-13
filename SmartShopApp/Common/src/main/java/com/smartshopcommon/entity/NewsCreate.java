package com.smartshopcommon.entity;

public class NewsCreate {
	private String title;
	private String content;
	private int categoriesID;

	public NewsCreate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsCreate(String title, String content, int categoriesID) {
		super();
		this.title = title;
		this.content = content;
		this.categoriesID = categoriesID;
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

	public int getCategoriesID() {
		return categoriesID;
	}

	public void setCategoriesID(int categoriesID) {
		this.categoriesID = categoriesID;
	}

}
