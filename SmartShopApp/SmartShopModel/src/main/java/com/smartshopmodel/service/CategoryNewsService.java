package com.smartshopmodel.service;

import java.util.List;

import com.smartshopcommon.model.CategoriesNews;





public interface CategoryNewsService {

	void saveCategory(CategoriesNews cn);
	
	CategoriesNews findByID(int id);
	
	List<CategoriesNews> findAll();
}
