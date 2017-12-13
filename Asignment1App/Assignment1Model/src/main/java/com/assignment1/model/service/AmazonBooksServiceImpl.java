package com.assignment1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment1.model.dao.DataDAO;
import com.assignment1common.model.AmazonBooks;



@Service
public class AmazonBooksServiceImpl implements AmazonBooksService {

	@Autowired
	DataDAO dao;
	
	@Override
	public List<AmazonBooks> getAllAmazonBook() {
		// TODO Auto-generated method stub
		return dao.getAllAmazonBooks();
	}

	@Override
	public AmazonBooksService getAmazonBookByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAmazonBook(AmazonBooks ab) {
		dao.addAmazonBook(ab);
		
	}

	@Override
	public List<Integer> getAllIdAmazonBook() {
		// TODO Auto-generated method stub
		return dao.getAllIdAmazonBook();
	}

	@Override
	public Integer deleteAllAmazonBook(List<Integer> list) {
		// TODO Auto-generated method stub
		return dao.deleteAllAmazonBook(list);
	}

}
