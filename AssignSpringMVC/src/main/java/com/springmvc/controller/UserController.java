package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.dto.FlightSearchDTO;
import com.springmvc.model.Cities;
import com.springmvc.model.Users;
import com.springmvc.service.CityService;
import com.springmvc.service.UserService;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	CityService cityService;

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

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public String checkLogin(@Valid @ModelAttribute("user") Users user,BindingResult result, Model model ) {
	
		if (result.hasErrors()) {
		
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
				
			System.out.println(result.getAllErrors().toString());
			return "Login";
		} else {
				
			List<Users> listUser = service.findAllUser();
			System.out.println("size:"+listUser.size());
			for (int i = 0; i < listUser.size(); i++) {
				if (listUser.get(i).getUsername().equals(user.getUsername())) {
					if (listUser.get(i).getPassword().equals(user.getPassword())) {

						model.addAttribute("user", listUser);
						return "ListUser";
					}
				}
			}
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
	public String edit(ModelMap model,@PathVariable String name) {

		Users user = service.findUserByName(name);
		model.addAttribute("user", user);
		return "EditUser";
	}
	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model  model) {

	List<Cities> listCity = cityService.findAllCity();
	System.out.println("size:"+listCity.size());
		/*List<Cities> listCity =new ArrayList<Cities>();
		listCity.add(new Cities(1,"bb"));
		listCity.add(new Cities(2,"bb"));
		listCity.add(new Cities(3,"bb"));
		listCity.add(new Cities(4,"bb"));
		listCity.add(new Cities(5,"bb"));
		listCity.add(new Cities(6,"bb"));
		listCity.add(new Cities(7,"bb"));
		//System.out.println(listCity.size());
*/		model.addAttribute("city", listCity);
		model.addAttribute("flightsearchDTO", new FlightSearchDTO());
		return "Home";
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(ModelMap model) {
		Cities city=new Cities();
				city.setCityName("Hai Phong");
       cityService.addCity(city);
		
	}
	

	/*@RequestMapping("/")
	public String getIndex() {
		return "redirect:/test";
	}
	*/
	
}
