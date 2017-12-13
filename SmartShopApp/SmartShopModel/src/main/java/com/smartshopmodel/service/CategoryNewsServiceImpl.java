package com.smartshopmodel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartshopcommon.model.CategoriesNews;
import com.smartshopmodel.dao.CategoryNewsRespository;



@Service
public class CategoryNewsServiceImpl implements CategoryNewsService {

	@Autowired
	CategoryNewsRespository respository;

	@Override
	public void saveCategory(CategoriesNews cn) {
		respository.save(cn);

	}

	@Override
	public CategoriesNews findByID(int id) {
		// TODO Auto-generated method stub
		return respository.findOne(id);
	}

	@Override
	public List<CategoriesNews> findAll() {
		// TODO Auto-generated method stub
		return respository.findAll();
	}

}
