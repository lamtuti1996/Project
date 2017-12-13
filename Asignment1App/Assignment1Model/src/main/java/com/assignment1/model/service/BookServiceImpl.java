package com.assignment1.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment1.model.dao.DataDAO;
import com.assignment1common.model.Books;



@Service
public class BookServiceImpl implements BookService {

	@Autowired
	DataDAO dao;
	
	@Override
	public void saveBook(Books b) {
		dao.addBook(b);
		
	}
   
}
