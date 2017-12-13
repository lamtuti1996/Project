package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.persistence.model.Users;
import com.demo.service.UsersService;

@Controller
public class demoController {
	
	@Autowired
	private UsersService usersSertvice;
	
	@GetMapping("/demo")
	@ResponseBody
	public String showDemo() {
		
		Users u=new Users();
		u.setUsername("hyhy");
		u.setPassword("passhhyhy");
		u.setFullname("fullhyhy");
		
		Users u2=new Users();
		u2.setUsername("hyhy222");
		u2.setPassword("passhhyhy222");
		u2.setFullname("fullhyhy222");
		usersSertvice.SaveUser(u);
		usersSertvice.SaveUser(u2);
		
		return "<h1>Demo spring boot app!!!!</h1>";
	}
}
