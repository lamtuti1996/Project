package com.demo.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.demo.struts.dao.OrderDAO;
import com.demo.struts.dao.OrderDetailDAO;
import com.demo.struts.entity.Orders;
import com.demo.struts.model.OrderCustomize;

public class OrderDetailAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
	//	String orderID = (String) request.getAttribute("orderID");
		String orderID	=request.getParameter("orderID");
		OrderDetailDAO orderDetaildao = new OrderDetailDAO();
		List<OrderCustomize> list = orderDetaildao.findAllOrderDetailByOrderID(orderID);

		if (list.size() > 0) {

			request.setAttribute("listOrderDetail", list);
			
			return mapping.findForward("success");
		} else {
			return mapping.findForward("success");
		}

	}

}
