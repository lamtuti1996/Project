package com.assignment1.model.service;

import java.util.List;

import com.assignment1common.model.Authors;


public interface AuthorService {
	void saveAuthor(Authors a);

	Authors getAuthorByID(int id);

	List<Authors> getAllAuthors();
}
