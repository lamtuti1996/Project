package com.smartshopmodel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartshopcommon.model.CategoriesProduct;
import com.smartshopmodel.dao.CategoryProductRespository;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {

	@Autowired
	CategoryProductRespository repository;

	@Override
	public List<CategoriesProduct> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void saveCategoryProduct(CategoriesProduct cp) {
		repository.save(cp);

	}

}
