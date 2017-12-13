package com.myfilter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Role;

public class AuthorizationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		boolean studentRequest = req.getRequestURI().contains(req.getContextPath() + "/page_student");
		boolean teacherRequest = req.getRequestURI().contains(req.getContextPath() + "/page_teacher");
		boolean adminRequest = req.getRequestURI().contains(req.getContextPath() + "/page_admin");

		if (studentRequest) {
			Set<Role> listRole = (Set<Role>) session.getAttribute("listRole");
			for (Role role : listRole) {
				if (role.getRoleName().equals("Student")) {
					chain.doFilter(request, response);
					return;
				}
			}
			res.sendRedirect(req.getContextPath() + "/page_error");
		} else if (teacherRequest) {
			Set<Role> listRole = (Set<Role>) session.getAttribute("listRole");
			for (Role role : listRole) {
				if (role.getRoleName().equals("Teacher")) {
					chain.doFilter(request, response);
					return;
				}
			}
			res.sendRedirect(req.getContextPath() + "/page_error");
		} else if (adminRequest) {
			Set<Role> listRole = (Set<Role>) session.getAttribute("listRole");
			for (Role role : listRole) {
				if (role.getRoleName().equals("Admin")) {
					chain.doFilter(request, response);
					return;
				}
			}
			res.sendRedirect(req.getContextPath() + "/page_error");
		}
	}

	@Override
	public void destroy() {

	}

}
