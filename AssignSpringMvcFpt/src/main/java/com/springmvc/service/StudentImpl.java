package com.springmvc.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.StudentDAO;
import com.springmvc.model.Student;



@Service
public class StudentImpl implements StudentService {

	@Autowired
	private StudentDAO dao;

	public Student findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public void add(Student s) {
		// TODO Auto-generated method stub
		
	}

	public void update(Student s) {
		// TODO Auto-generated method stub
		
	}

	public List<Student> listPaginatedProductsUsingQuery(Integer firstResult, Integer maxResults) {
		// TODO Auto-generated method stub
		return dao.listPaginatedProductsUsingQuery(firstResult, maxResults);
	}

	public Long count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	public List<Student> list(Integer offset, Integer maxResults,String name) {
		// TODO Auto-generated method stub
		return dao.list(offset, maxResults, name);
	}






}
