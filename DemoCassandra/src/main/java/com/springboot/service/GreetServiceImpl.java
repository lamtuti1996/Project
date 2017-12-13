package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.model.Greeting;
import com.springboot.repository.GreetRepository;

public class GreetServiceImpl implements GreetService{

	@Autowired
	GreetRepository repository;
	
	
	@Override
	public List<Greeting> findAll() {
		// TODO Auto-generated method stub
		return  (List<Greeting>) repository.findAll();
	}

}
