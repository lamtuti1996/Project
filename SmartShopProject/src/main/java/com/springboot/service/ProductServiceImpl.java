package com.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.dao.ProductRespository;
import com.springboot.model.Products;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRespository respository;

	@Override
	public Page<Products> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return  respository.findAll(pageable);
	}

	@Override
	public Products findOneByID(int id) {
		// TODO Auto-generated method stub
		return respository.findOne(id);
	}

	@Override
	public Page<Products> findAddByCategoryID(int categoryID, Pageable pageable) {
		// TODO Auto-generated method stub
		return respository.findAllByCategoryProductCategoryID(categoryID, pageable);
	}

	@Override
	public void updateQualityProduct(Products p) {
		respository.save(p);
		
	}

	@Override
	public void saveProduct(Products p) {
		respository.save(p);
		
	}

}
