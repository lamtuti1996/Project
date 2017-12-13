package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.CategoryProductRespository;
import com.springboot.model.CategoriesProduct;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {

	@Autowired
	CategoryProductRespository repository;
	
	@Override
	public List<CategoriesProduct> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
