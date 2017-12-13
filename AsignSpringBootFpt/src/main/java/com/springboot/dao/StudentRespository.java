package com.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.model.Student;

public interface StudentRespository extends PagingAndSortingRepository<Student ,Integer> {
	public final static String QUERY = " select u.fullname ,s.id , s.nameMajor , s.mark , u.username " 
                        + " from Users u , Student s where u.username = s.user and u.username = :name ";

	
	@Query(QUERY)
	 Page<Object> findByName(@Param("name") String name,Pageable pageable);
	
	
	Page<Student> findAllByUserUsername(String name,Pageable pageable);
	/*Page<Student> findByUserUsername(String Username,Pageable pageable);*/
}
  