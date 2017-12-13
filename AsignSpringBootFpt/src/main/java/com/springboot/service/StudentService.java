package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.entity.StudentDTO;
import com.springboot.entity.UserStudent;
import com.springboot.model.Student;

public interface StudentService {
	
	Page<UserStudent> findAllByName(String name,Pageable pageable);
	
	Page<Student> findAllByUserUsername(String name,Pageable pageable);
	
	Student findById(int id);
	
	void delete(int id);

	void add(Student s);
	
	void update(Student s);
	

}
