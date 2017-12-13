package com.springboot.service;

import java.util.List;

import com.springboot.model.CategoriesNews;
import com.springboot.model.News;



public interface CategoryNewsService {

	void saveCategory(CategoriesNews cn);
	
	CategoriesNews findByID(int id);
	
	List<CategoriesNews> findAll();
}
