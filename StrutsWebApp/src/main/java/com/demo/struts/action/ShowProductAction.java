package com.demo.struts.action;

import java.util.ArrayList;
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
import com.demo.struts.form.PaginationForm;
import com.demo.struts.form.ShowProductForm;
import com.demo.struts.model.EmployeeData;

public class ShowProductAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ProductDAO productDao = new ProductDAO();

		 ShowProductForm listProduct = (ShowProductForm) form;
		 listProduct.setListProduct(productDao.getAllProduct(0, 4));
//		PaginationForm paging = (PaginationForm) form;
//		int pageSize = 3;
//		int currentPage = 0;
//		/*
//		 * if (paging.getRange() != null || !paging.getRange().equals("")) { pageSize =
//		 * Integer.parseInt(paging.getRange()); } if (paging.getStart() != null ||
//		 * !paging.getStart().equals("")) { currentPage =
//		 * Integer.parseInt(paging.getStart()); }
//		 */
//		long n = productDao.getCountProduct();
//		int totalRow = Integer.parseInt(String.valueOf(n));
//		int totalPage = totalRow / pageSize + 1;
//		int startingIndex = pageSize * currentPage;// from row
//		if (startingIndex < 0) {
//			startingIndex = 0;
//		}
//		int endingIndex = startingIndex + pageSize;
//		if (endingIndex > totalRow) {
//			endingIndex = totalRow;
//		}
//
//		List<Product> list = productDao.getAllProduct(startingIndex, endingIndex);
//
//		paging.setListProduct(list);
//		paging.setResults(String.valueOf(totalRow));

		return mapping.findForward("success");

	}
}
