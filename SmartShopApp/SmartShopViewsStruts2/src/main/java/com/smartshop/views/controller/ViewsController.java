package com.smartshop.views.controller;

import java.net.URI;
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.opensymphony.xwork2.ActionSupport;
import com.smartshopcommon.entity.CartInfo;
import com.smartshopcommon.entity.CartLineInfo;
import com.smartshopcommon.entity.CategoryProductObj;
import com.smartshopcommon.entity.Customer;
import com.smartshopcommon.entity.OrderCustomize;
import com.smartshopcommon.entity.OrderObj;
import com.smartshopcommon.entity.OrderSave;
import com.smartshopcommon.entity.PageItem;
import com.smartshopcommon.entity.PageWrapper;
import com.smartshopcommon.entity.ProductInfo;
import com.smartshopcommon.entity.ProductObj;
import com.smartshopcommon.entity.RestResponsePage;
import com.smartshopcommon.model.CategoriesProduct;
import com.smartshopcommon.utils.Util;

public class ViewsController extends ActionSupport {

	private static final String URL = "http://localhost:8082/";
	private String page = "";
	private String size;
	private List<ProductObj> listProduct = new ArrayList<ProductObj>();
	private List<OrderObj> listOrder = new ArrayList<OrderObj>();
	private List<OrderCustomize> listOrderDetail = new ArrayList<OrderCustomize>();
	private List<CategoriesProduct> categoryProduct = new ArrayList<CategoriesProduct>();
	private PageWrapper<ProductObj> pages;
	private PageWrapper<OrderObj> pageOrder;
	private List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();
	PageWrapper<OrderCustomize> pageOrderCustomize;
	private List<PageItem> items = new ArrayList<PageItem>();
	CartInfo cartInfo = new CartInfo();
	private String id;
	private int categoryID;
	private ProductObj product = new ProductObj();
	private int productID;
	private int quanity;
	private double totalAmount;
	private double totalQuantity;
	private String orderID;
	private Customer c = new Customer();
	private String username;
	private String password;



	public String setHome() {
		RestTemplate restTemplate = new RestTemplate();
		ParameterizedTypeReference<RestResponsePage<ProductObj>> ptr = new ParameterizedTypeReference<RestResponsePage<ProductObj>>() {
		};

		if (this.page == null || this.page.equals("")) {
			this.page = "0";
		}
		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("getAllProduct").queryParam("page", page)
				.queryParam("size", 3).build().toUri();

		RestResponsePage<ProductObj> list = restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();
		pages = new PageWrapper<ProductObj>(list, "setHome");
		listProduct = pages.getContent();
		items = pages.getItems();

		String url = URL + "getAllCategoryProduct";
		categoryProduct = restTemplate.getForObject(url, List.class);

		return "success";
	}

	public String getProductById() {
		String url = URL + "getProductByID/{id}";
		RestTemplate restTemplate = new RestTemplate();
		product = restTemplate.getForObject(url, ProductObj.class, productID);

		return "success";
	}

	public String searchCategoryProduct() {
		RestTemplate restTemplate = new RestTemplate();
		HttpServletRequest request = ServletActionContext.getRequest();
		if (categoryID == -1) {
			categoryID = Util.getCategoryID(request);
		} else {
			Util.setCategoryID(request, categoryID);
		}
		ParameterizedTypeReference<RestResponsePage<ProductObj>> ptr = new ParameterizedTypeReference<RestResponsePage<ProductObj>>() {
		};
		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("getAllProductByCategory")
				.queryParam("categoryID", categoryID).queryParam("page", page).queryParam("size", 3).build().toUri();

		RestResponsePage<ProductObj> list = restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();
		pages = new PageWrapper<ProductObj>(list, "/searchCategoryProduct");
		listProduct = pages.getContent();
		items = pages.getItems();

		String url = URL + "getAllCategoryProduct";
		categoryProduct = restTemplate.getForObject(url, List.class);

		return "success";
	}

	public String addProductCart() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String url = URL + "getProductByID/{id}";
		RestTemplate restTemplate = new RestTemplate();
		ProductObj p = null;
		if (productID >= 0) {
			p = restTemplate.getForObject(url, ProductObj.class, productID);

		}
		if (p != null) {

			cartInfo = Util.getCartInSession(request);
			ProductInfo pInfo = new ProductInfo(p);
			cartInfo.addProduct(pInfo, quanity);
		}

		return "success";
	}

	public String getCart() {
		HttpServletRequest request = ServletActionContext.getRequest();
		cartInfo = Util.getCartInSession(request);
		totalQuantity = cartInfo.getQuantityTotal();
		totalAmount = cartInfo.getAmountTotal();
		cartLines = cartInfo.getCartLines();
		return "success";
	}

	public String removeProduct() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String url = URL + "getProductByID/{id}";
		RestTemplate restTemplate = new RestTemplate();
		ProductObj p = null;
		if (productID >= 0) {
			p = restTemplate.getForObject(url, ProductObj.class, productID);

		}
		if (p != null) {

			cartInfo = Util.getCartInSession(request);
			ProductInfo pInfo = new ProductInfo(p);
			cartInfo.removeProduct(pInfo);
		}
		return "success";
	}

	public String decreaseQuanity() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (productID > 0) {
			cartInfo = Util.getCartInSession(request);
			cartInfo.updateDecreaseQuality(productID);
		}
		return "success";
	}

	public String increaseQuanity() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (productID > 0) {
			cartInfo = Util.getCartInSession(request);
			cartInfo.updateIncreaseQuality(productID);
		}
		return "success";
	}

	public String listOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		RestTemplate restTemplate = new RestTemplate();
		// Principal principal = request.getUserPrincipal();
		ParameterizedTypeReference<RestResponsePage<OrderObj>> ptr = new ParameterizedTypeReference<RestResponsePage<OrderObj>>() {
		};
		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("getAllOrder").queryParam("email", "lam")
				.queryParam("page", page).queryParam("size", 3).build().toUri();

		RestResponsePage<OrderObj> list = restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();
		pageOrder = new PageWrapper<OrderObj>(list, "/listOrder");
		listOrder = pageOrder.getContent();
		items = pageOrder.getItems();

		return "success";
	}

	public String listOrderDetail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (orderID.equals("-1")) {
			orderID = Util.getOrderID(request);
		} else {
			Util.setOrderID(request, orderID);
		}
		if (this.page == null || this.page.equals("")) {
			this.page = "0";
		}
		RestTemplate restTemplate = new RestTemplate();

		ParameterizedTypeReference<RestResponsePage<OrderCustomize>> ptr = new ParameterizedTypeReference<RestResponsePage<OrderCustomize>>() {
		};
		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("getAllOrderDetail").queryParam("orderID", orderID)
				.queryParam("page", page).queryParam("size", 3).build().toUri();

		RestResponsePage<OrderCustomize> list = restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();

		pageOrderCustomize = new PageWrapper<OrderCustomize>(list, "/listOrderDetail");
		listOrderDetail = pageOrderCustomize.getContent();
		items = pageOrderCustomize.getItems();

		return "success";
	}

	public String saveCart() throws ParseException {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			RestTemplate restTemplate = new RestTemplate();
			// Principal principal = request.getUserPrincipal();
			CartInfo myCart = Util.getCartInSession(request);
			String email = "lam";

			OrderSave os = new OrderSave();
			os.setEmail(email);
			os.setMyCart(myCart);
			os.setCustomer(c);

			String url = URL + "saveCart";

			URI uri = restTemplate.postForLocation(url, os, OrderSave.class);
			Util.removeCartInSession(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String setCustomerInfo() {
		return "success";

	}

	public String getPage() {
		return page;
	}

	public List<OrderObj> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<OrderObj> listOrder) {
		this.listOrder = listOrder;
	}

	public PageWrapper<OrderObj> getPageOrder() {
		return pageOrder;
	}

	public void setPageOrder(PageWrapper<OrderObj> pageOrder) {
		this.pageOrder = pageOrder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public ProductObj getProduct() {
		return product;
	}

	public void setProduct(ProductObj product) {
		this.product = product;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<ProductObj> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<ProductObj> listProduct) {
		this.listProduct = listProduct;
	}

	public List<CategoriesProduct> getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(List<CategoriesProduct> categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public PageWrapper<ProductObj> getPages() {
		return pages;
	}

	public void setPages(PageWrapper<ProductObj> pages) {
		this.pages = pages;
	}

	public List<PageItem> getItems() {
		return items;
	}

	public void setItems(List<PageItem> items) {
		this.items = items;
	}

	public List<OrderCustomize> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(List<OrderCustomize> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}

	public PageWrapper<OrderCustomize> getPageOrderCustomize() {
		return pageOrderCustomize;
	}

	public void setPageOrderCustomize(PageWrapper<OrderCustomize> pageOrderCustomize) {
		this.pageOrderCustomize = pageOrderCustomize;
	}

	public CartInfo getCartInfo() {
		return cartInfo;
	}

	public void setCartInfo(CartInfo cartInfo) {
		this.cartInfo = cartInfo;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public List<CartLineInfo> getCartLines() {
		return cartLines;
	}

	public void setCartLines(List<CartLineInfo> cartLines) {
		this.cartLines = cartLines;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

}
