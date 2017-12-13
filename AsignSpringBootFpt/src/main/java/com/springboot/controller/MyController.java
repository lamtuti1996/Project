package com.springboot.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.springboot.entity.StudentDTO;
import com.springboot.entity.UserStudent;
import com.springboot.model.Student;
import com.springboot.model.Users;
import com.springboot.service.StudentService;
import com.springboot.service.UserService;

@Controller
public class MyController {
	private static final Logger log = LoggerFactory.getLogger(MyController.class);

	@Autowired
	UserService userService;

	@Autowired
	StudentService studentService;

	@GetMapping("login")
	public String setLogin(ModelMap model) {

		Users u = new Users();
		model.addAttribute("Users", u);
		return "Login";
	}

	@GetMapping("/setUpdate/{id}")
	public String setUpdate(ModelMap model, @PathVariable int id) {
		Student s = studentService.findById(id);
		StudentDTO st = new StudentDTO();
		model.addAttribute("studentID", s.getId());
		model.addAttribute("studentMark", s.getMark());
		model.addAttribute("studentMajor", s.getNameMajor());
		model.addAttribute("studentDTO", st);

		return "UpdateStudent";

	}

	@PostMapping("/updateStudent")
	public String updateStudent(ModelMap model, @ModelAttribute("user") StudentDTO st, HttpSession session) {
		String username = (String) session.getAttribute("name");
		Users u = userService.findByName(username);
		Student s = new Student(st.getId(), st.getNameMajor(), st.getMark(), u);

		studentService.update(s);

		return "redirect:/changePage";
	}

	@PostMapping("/checkLogin")
	public String checkLogin(@Valid @ModelAttribute("Users") Users u, BindingResult result, HttpSession session,
			Pageable pageable, Model model) {

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

					return "redirect:/changePage";

				}

			}
		}

		return null;
	}

	@PostMapping(value = "/editStudent")
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

	@PostMapping(value = "/deleteStudent")
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
	}

	@GetMapping("/changePage")
	public String changePage(Pageable pageable, ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("name");

		Page<Student> studentPage = studentService.findAllByUserUsername(username, pageable);
		PageWrapper<Student> page = new PageWrapper<Student>(studentPage, "/changePage");
		model.addAttribute("listStudent", page.getContent());
		model.addAttribute("page", page);
	
		return "ListUser";

	}

	@GetMapping("/setAddStudent")
	public String setAdd(ModelMap model) {

		StudentDTO s = new StudentDTO();
		model.addAttribute("studentDTO", s);
		return "AddStudent";
	}

	@PostMapping("/addStudent")
	public String addStudent(ModelMap model, @ModelAttribute StudentDTO st, HttpSession session) {
		String username = (String) session.getAttribute("name");
		// Users u = userService.findByName(username);
		Users u = new Users("lamnn", "123", "lamnn");
		Student s = new Student(st.getNameMajor(), st.getMark(), u);

		studentService.add(s);

		return "redirect:/changePage";
	}

	@GetMapping("/test")
	public String tesst() {
		return "bootstrap_1";
	}

}
