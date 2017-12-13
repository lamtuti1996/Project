package com.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.persistence.model.Users;
import com.demo.service.UsersService;

@Controller
public class UserController {
	
	@Autowired
	private UsersService usersSertvice;
	
	@GetMapping("/user")
	public String showUser(Model model) {
		model.addAttribute("users",usersSertvice.findAll());
		return "listUser";
	}
	@GetMapping("/user/addUser")
	public String addUser(Model model) {
		model.addAttribute("user",new Users());
		model.addAttribute("isPersisted",false);
		return "formUser";
	}
	
	@GetMapping("/user/EditUser")
	public String editUser(@RequestParam("username") String username,Model model) {
		model.addAttribute("user",usersSertvice.findOne(username));
		model.addAttribute("isPersisted",true);
		return "formUser";
	}
	@PostMapping("/user/save")
	public String saveUser(@Valid @ModelAttribute("user")  Users user,BindingResult result, Model model) {
		usersSertvice.SaveUser(user);
		return "redirect:/user";

	}
	@GetMapping("/user/Delete")
	public String deleteUser(@RequestParam("username") String username,Model model) {
		Users user=usersSertvice.findOne(username);
		usersSertvice.DeleteUser(user);
		model.addAttribute("users",usersSertvice.findAll());
		return "listUser";
	}
}
