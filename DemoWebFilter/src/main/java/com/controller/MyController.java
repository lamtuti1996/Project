package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.User;
import com.dao.RoleDAO;
import com.dao.UserDAO;

@Controller
public class MyController {

	@Autowired
	UserDAO userDAO;

	@Autowired
	RoleDAO roleDAO;
	
	@RequestMapping(value = "/error500", method = RequestMethod.GET)
	public String getPage_Erorr500() {
		return "page_error500";
	}

	@RequestMapping(value = "/error404", method = RequestMethod.GET)
	public String getPage_Erorr404() {
		return "page_error404";
	}
	
	@RequestMapping(value = "/page_error", method = RequestMethod.GET)
	public String getPage_Erorr() {
		return "page_error";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkLogin(Model model, @Valid @ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors())
			return "login";
		if (userDAO.check(user)) {
			user = userDAO.getUser(user.getName(), user.getPassword());
			HttpSession session = request.getSession();
			session.setAttribute("listRole", roleDAO.getRole(user));
			session.setAttribute("user", user);
			return "redirect:/welcome";
		}
		model.addAttribute("msg", "Tài khoản hoặc mật khẩu không đúng !");
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex() {
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/page_student/*", method = RequestMethod.GET)
	public String getPage_Student() {
		return "page_student";
	}

	@RequestMapping(value = "/page_teacher/*", method = RequestMethod.GET)
	public String getPage_Teacher() {
		return "page_teacher";
	}

	@RequestMapping(value = "/page_admin/*", method = RequestMethod.GET)
	public String getPage_Admin() {
		return "page_admin";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String getWelcome() {
		return "welcome";
	}
}
