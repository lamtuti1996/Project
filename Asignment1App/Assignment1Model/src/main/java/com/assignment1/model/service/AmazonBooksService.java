package com.assignment1.model.service;

import java.util.List;

import com.assignment1common.model.AmazonBooks;


public interface AmazonBooksService {
	
	List<AmazonBooks> getAllAmazonBook();
	
	AmazonBooksService getAmazonBookByID(int id);
	
	void saveAmazonBook(AmazonBooks ab);
  
	List<Integer> getAllIdAmazonBook();
	
	Integer deleteAllAmazonBook(List<Integer> list);
}
