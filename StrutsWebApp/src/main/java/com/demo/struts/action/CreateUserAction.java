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
import com.demo.struts.form.CreateUserForm;
import com.demo.struts.form.LoginForm;

public class CreateUserAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CreateUserForm createForm = (CreateUserForm) form;

		UserDAO userDao = new UserDAO();
		User u = new User();
		u.setEmail(createForm.getEmail());
		u.setPassword(createForm.getPassword());
        boolean check=userDao.createUser(u);
		if (check== false) {
			return mapping.findForward("failure");
		} else {
			
			return mapping.findForward("success");
		}

	}

}
