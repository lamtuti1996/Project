package com.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.model.Users;
import com.springboot.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	/// *
	// @Autowired
	// CityService cityService;*/

	@Autowired
	UserService service;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<Users> user = service.findAllUser();

		model.addAttribute("user", user);
		return "ListUser";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		Users user = new Users();
		model.addAttribute("user", user);
		return "Login";
	}

	@PostMapping(value = "/checkLogin")
	public String checkLogin(@Valid @ModelAttribute("user") Users user, BindingResult result, Model model) {

		if (result.hasErrors()) {

			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");

			System.out.println(result.getAllErrors().toString());
			return "Login";
		} else {

			//List<Users> checkUser = service.findAllUser();
			Users checkUser=service.findUserByName(user.getUsername());
			System.out.println("size:"+checkUser);
		/*	if (checkUser.getUsername().equals(user.getUsername())) {
				if (checkUser.getPassword().equals(user.getPassword())) {
					return "redirect:/list";
				}
			}*/
			model.addAttribute("user", user);
			return "Login";

		}

	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String name) {

		service.deleteUserByName(name);
		;
		return "redirect:/list";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") Users user) {
		service.saveUser(user);
		return "redirect:/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap model) {

		Users user = new Users();
		model.addAttribute("user", user);
		return "AddUser";
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("user") Users user) {
		service.updateUser(user);
		return "redirect:/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(ModelMap model, @PathVariable String name) {

		Users user = service.findUserByName(name);
		model.addAttribute("user", user);
		return "EditUser";
	}


}
