package com.assignment1.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment1.model.dao.DataDAO;
import com.assignment1common.model.Libraries;



@Service
public class LibraryServiceImpl  implements LibraryService{

	@Autowired
	DataDAO dao;
	
	@Override
	public void saveLibrary(Libraries l) {
		dao.addLibrary(l);
		
	}

}
