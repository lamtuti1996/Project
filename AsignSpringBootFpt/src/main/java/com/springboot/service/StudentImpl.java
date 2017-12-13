package com.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.dao.StudentRespository;
import com.springboot.entity.UserStudent;
import com.springboot.model.Student;

import javassist.expr.NewArray;

@Service
public class StudentImpl implements StudentService {

	@Autowired
	private StudentRespository studentRespository;

	@Override
	public Page<UserStudent> findAllByName(String name,Pageable pageable) {
		Page<Object> list = studentRespository.findByName(name,pageable);
		List<UserStudent> listSearch = new ArrayList<UserStudent>();

		for (Iterator<Object> it = list.iterator(); it.hasNext();) {
			Object[] object = (Object[]) it.next();
			String fullName = (String) object[0];

			int id = Integer.parseInt(object[1].toString());
			String nameMajor = (String) object[2];
			float mark = Float.parseFloat(object[3].toString());
			String username = (String) object[4];

			UserStudent u = new UserStudent(fullName, id, nameMajor, mark, username);
			listSearch.add(u);
		}
		System.out.println("size:" + listSearch.size());
		
		Page<UserStudent> page = new PageImpl<>(listSearch);
		return page;
	}

	@Override
	public Student findById(int id) {

		return studentRespository.findOne(id);
	}

	@Override
	public void delete(int id) {

		studentRespository.delete(id);
	}

	@Override
	public void add(Student s) {
		studentRespository.save(s);
		
	}

	@Override
	public void update(Student s) {
		studentRespository.save(s);
		
	}

	@Override
	public Page<Student> findAllByUserUsername(String name, Pageable pageable) {
		Page<Student> page=	 studentRespository.findAllByUserUsername(name, pageable);
		return page;
	}




}
