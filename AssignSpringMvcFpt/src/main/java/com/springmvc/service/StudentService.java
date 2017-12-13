package com.springmvc.service;


import java.util.List;



import com.springmvc.model.Student;


public interface StudentService {
	

	
	Student findById(int id);
	
	void delete(int id);

	void add(Student s);
	
	void update(Student s);
	
	List<Student> listPaginatedProductsUsingQuery(Integer firstResult,Integer maxResults);
	
	 Long count();
	 List<Student> list(Integer offset, Integer maxResults,String name);

}
