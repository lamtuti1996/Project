package com.demo.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.*;

public class LoginForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String userName = null;
	private String password = null;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.password = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (userName == null || userName.length() == 0) {
			errors.add("userName", new ActionMessage("userName.not.entered"));
		}else if(userName.length() <=2){
			errors.add("userName", new ActionMessage("userName.length"));
			
		}

		if (password == null || password.length() == 0) {
			errors.add("password", new ActionMessage("password.not.entered"));
		}

		return errors;

	}

}
