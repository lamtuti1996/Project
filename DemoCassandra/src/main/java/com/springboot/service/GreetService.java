package com.springboot.service;

import java.util.List;

import com.springboot.model.Greeting;

public interface GreetService {
   
	List<Greeting> findAll();
}
