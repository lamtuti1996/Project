package com.smartshopmodel.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.smartshopcommon.model.Products;





public interface ProductService {
	Page<Products> findAll(Pageable pageable);

	Products findOneByID(int id);

	Page<Products> findAddByCategoryID(int categoryID, Pageable pageable);
	
	void updateQualityProduct(Products p);
	
	void saveProduct(Products p);
}
