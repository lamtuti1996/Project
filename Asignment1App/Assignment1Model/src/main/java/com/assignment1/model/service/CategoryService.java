package com.assignment1.model.service;

import java.util.List;

import com.assignment1common.model.Categories;



public interface CategoryService {

	void saveCategory(Categories c);

	Categories getCategoryById(int id);
	
	List<Categories> getAllCategory();

}
