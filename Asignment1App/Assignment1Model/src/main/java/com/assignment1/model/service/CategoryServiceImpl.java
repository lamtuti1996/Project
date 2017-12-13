package com.assignment1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment1.model.dao.DataDAO;
import com.assignment1common.model.Categories;



@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	DataDAO dao;

	@Override
	public void saveCategory(Categories c) {
		dao.addCategory(c);

	}

	@Override
	public List<Categories> getAllCategory() {
		// TODO Auto-generated method stub
		return dao.getAllCategory();
	}

	@Override
	public Categories getCategoryById(int id) {
		// TODO Auto-generated method stub
		return dao.getCategoryByID(id);
	}

}
