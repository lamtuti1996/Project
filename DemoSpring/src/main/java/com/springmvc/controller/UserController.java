package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.Users;
import com.springmvc.service.UserService;



@Controller
public class UserController {

	
	@Autowired
	UserService userService;
	
	@RequestMapping(value ="/login" , method = RequestMethod.GET)
	public String login(ModelMap model) {

	Users user =new Users();
		model.addAttribute("user", user);
		return "Login";
	}
	
/*	@RequestMapping(value ="/list" , method = RequestMethod.POST)
	public String listEmployees(ModelMap model) {

		List<Users> user = userService.findAllUser();
		model.addAttribute("user", user);
		return "ListUser";
	}*/
	
	/*@RequestMapping(value ="/checkLogin" , method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("user") Users user, ModelMap model) {

		List<Users> userList = userService.findAllUser();
		for(int i=0;i<=userList.size();i++) {
			if(user.getUsername().equals(userList.get(i).getUsername())){
				return "Success";
			}
		}
		model.addAttribute("user", user);
		return "Login";
	}*/
	
	@RequestMapping("/")
	public String getIndex() {
		return "redirect:/login";
	}
}
