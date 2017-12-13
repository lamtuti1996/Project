package com.assignment1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment1.model.dao.DataDAO;
import com.assignment1common.model.Authors;



@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	DataDAO dao;

	@Override
	public void saveAuthor(Authors a) {
		dao.addAuthors(a);

	}

	@Override
	public Authors getAuthorByID(int id) {
		// TODO Auto-generated method stub
		return dao.getAuthorByID(id);
	}

	@Override
	public List<Authors> getAllAuthors() {
		// TODO Auto-generated method stub
		return dao.getAllAuthor();
	}

}
