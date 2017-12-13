package com.springmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmvc.model.Student;
import com.springmvc.model.Users;
import com.springmvc.service.StudentService;
import com.springmvc.service.UserService;

@Controller
public class MyController {



	private static final Logger log = LoggerFactory.getLogger(MyController.class);

	@Autowired
	UserService userService;

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String setLogin(ModelMap model) {

		Users u = new Users();
		model.addAttribute("Users", u);
		return "Login";
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public String checkLogin(@Valid @ModelAttribute("Users") Users u,BindingResult result, HttpSession session,
			Model model) {

		if (result.hasErrors()) {

			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");

			System.out.println(result.getAllErrors().toString());
			Users user = new Users();
			model.addAttribute("Users", u);
			return "Login";
		} else {
          
			List<Users> list = userService.findAll();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getUsername().equals(u.getUsername())
						&& list.get(i).getPassword().equals(u.getPassword())) {
					session.setAttribute("name", u.getUsername());

					return "redirect:/list";

				}

			}
		}

		return "Login";
	}

	@RequestMapping(value = "/list")
	public String list(Model model, Integer offset, Integer maxResults) {
		List<Student> list=studentService.list(offset, maxResults,"lamnn");
		//List<Student> list=studentService.listPaginatedProductsUsingQuery(offset, maxResults);
		Long count =studentService.count();
	
		System.out.println("size:"+list.size());
		System.out.println(count);
		model.addAttribute("listStudent", list);
		model.addAttribute("count", count);
		model.addAttribute("offset", offset);
		return "/ListStudent";
	}

	/*@RequestMapping(value = "/editStudent", method = RequestMethod.POST)
	public @ResponseBody boolean editStudent(@RequestBody String jsonInput, ModelMap model, HttpSession session)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String username = (String) session.getAttribute("name");

		try {
			TypeReference<List<Student>> mapType = new TypeReference<List<Student>>() {
			};
			List<Student> jsonToPersonList = mapper.readValue(jsonInput, mapType);
			Users u = userService.findByName(username);
			for (int i = 0; i < jsonToPersonList.size(); i++) {
				Student s = new Student(jsonToPersonList.get(i).getId(), jsonToPersonList.get(i).getNameMajor(),
						jsonToPersonList.get(i).getMark(), u);
				studentService.update(s);

			}

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
	public @ResponseBody boolean deleteStudent(@RequestBody String jsonInput, ModelMap model, HttpSession session)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		try {
			TypeReference<List<String>> mapType = new TypeReference<List<String>>() {
			};
			List<String> jsonToStringList = mapper.readValue(jsonInput, mapType);

			for (int i = 0; i < jsonToStringList.size(); i++) {

			}

			for (String item : jsonToStringList) {
				int id = Integer.parseInt(item);
				studentService.delete(id);
			}

		} catch (Exception e) {
			return false;
		}
		return true;
	}*/
}
