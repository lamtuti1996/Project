package com.demo.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.demo.struts.dao.ProductDAO;
import com.demo.struts.dao.UserDAO;
import com.demo.struts.entity.Product;
import com.demo.struts.entity.User;

import com.demo.struts.form.LoginForm;
import com.demo.struts.service.UserService;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		HttpSession session = request.getSession();
		UserDAO userDao = new UserDAO();

		User u = userDao.getUsers(loginForm.getUserName(), loginForm.getPassword());

		if (u == null) {
			return mapping.findForward("failure");
		} else {
			session.setAttribute("email", loginForm.getUserName());
			return mapping.findForward("success");
		}

	}

}
