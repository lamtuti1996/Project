package com.smartshopmodel.service;

import java.util.List;

import com.smartshopcommon.model.CategoriesProduct;





public interface CategoryProductService {

	List<CategoriesProduct> findAll();
	
  void	saveCategoryProduct(CategoriesProduct cp);
}
