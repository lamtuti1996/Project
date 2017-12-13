package com.smartshopcommon.utils;

import javax.servlet.http.HttpServletRequest;

import com.smartshopcommon.entity.CartInfo;

public class Util {

	// Products in Cart, stored in Session.
	public static CartInfo getCartInSession(HttpServletRequest request) {

		// Get Cart from Session.
		CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");

		// If null, create it.
		if (cartInfo == null) {
			cartInfo = new CartInfo();

			// And store to Session.
			request.getSession().setAttribute("myCart", cartInfo);
		}

		return cartInfo;
	}
	public static String getOrderID(HttpServletRequest request) {
		return (String) request.getSession().getAttribute("orderID");

	}

	public static void setOrderID(HttpServletRequest request, String orderID) {
		request.getSession().setAttribute("orderID", orderID);

	}

	public static int getCategoryID(HttpServletRequest request) {
		return (int) request.getSession().getAttribute("categoryID");

	}

	public static void setCategoryID(HttpServletRequest request, int categoryID) {
		request.getSession().setAttribute("categoryID", categoryID);

	}

	public static void removeCartInSession(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}

	public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
		request.getSession().setAttribute("lastOrderedCart", cartInfo);
	}

	public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
		return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
	}
}
