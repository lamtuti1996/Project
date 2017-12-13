package com.springboot.controller;

import java.security.Principal;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.common.Common;
import com.springboot.dao.CategoryProductRespository;
import com.springboot.dao.OrderRespository;
import com.springboot.entity.CartInfo;
import com.springboot.entity.CartLineInfo;
import com.springboot.entity.CartShow;
import com.springboot.entity.Customer;
import com.springboot.entity.NewsCreate;
import com.springboot.entity.ProductInfo;
import com.springboot.entity.RegisterUser;
import com.springboot.model.CategoriesNews;
import com.springboot.model.CategoriesProduct;
import com.springboot.model.News;
import com.springboot.model.OrderDetail;
import com.springboot.model.Orders;
import com.springboot.model.Products;
import com.springboot.model.Role;
import com.springboot.model.Users;
import com.springboot.utils.Util;
import com.springboot.service.CategoryNewsService;
import com.springboot.service.CategoryProductService;
import com.springboot.service.NewsService;
import com.springboot.service.OrderDetailService;
import com.springboot.service.OrderService;
import com.springboot.service.ProductService;
import com.springboot.service.RoleService;
import com.springboot.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private NewsService newsService;

	@Autowired
	private CategoryNewsService categoryNewsService;

	@Autowired
	private CategoryProductService categoryProductService;

	@Autowired
	private UserDetailsService userDetailService;

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String setLogin() {

		return "login";

	}

	@PostMapping("/test1")
	public String test1(ModelMap model, @RequestParam("email") String email,
			@RequestParam("password") String password) {
		UserDetails u = userDetailService.loadUserByUsername(email);
		if (u.getPassword().equals(password)) {
			return "redirect:/listProduct";

		} else {
			return "login";
		}

	}

	@GetMapping("/setRegister")
	public String setRegister(ModelMap model) {
		RegisterUser ru = new RegisterUser();
		model.addAttribute("rUser", ru);

		return "Register";
	}

	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("rUser") RegisterUser ru, BindingResult result, ModelMap model)
			throws ParseException {
		if (result.hasErrors()) {

			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");

			System.out.println(result.getAllErrors().toString());

			return "redirect:/setRegister";
		} else {

			Users u = new Users();

			HashSet<Role> roles = new HashSet<>();
			roles.add(roleService.findRoleByName("ROLE_MEMBER"));

			u.setEmail(ru.getEmail());
			u.setPassword(ru.getPassword());
			u.setCreatedTime(Common.CurrentDateTime());
			u.setRoles(roles);
		 userService.saveUser(u);
			return "redirect:/";

		}

	}

	/*
	 * @PostMapping("/checkLogin") public String
	 * checkLogin(@Valid @ModelAttribute("user") Users u, BindingResult result,
	 * ModelMap model) throws ParseException { if (result.hasErrors()) {
	 * 
	 * model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
	 * 
	 * System.out.println(result.getAllErrors().toString()); Users user = new
	 * Users(); model.addAttribute("user", u); return "Login"; } else { // Users
	 * check = userService.findByEmailAndPass(u.getEmail(), u.getPassword()); // if
	 * (check != null) { if (true) { //
	 * check.setLastAccess(Common.CurrentDateTime()); //
	 * userService.saveUser(check); return "redirect:/listProduct";
	 * 
	 * } else {
	 * 
	 * Users user = new Users(); model.addAttribute("user", u);
	 * model.addAttribute("message", "Email and Password is not  !"); return
	 * "Login";
	 * 
	 * } }
	 * 
	 * }
	 */

	@GetMapping("/listProduct")
	public String listProduct(ModelMap model, Pageable pageable) {

		List<CategoriesProduct> categoryProduct = categoryProductService.findAll();

		Page<Products> listProduct = productService.findAll(pageable);

		PageWrapper<Products> page = new PageWrapper<Products>(listProduct, "/listProduct");
		model.addAttribute("listProduct", page.getContent());
		model.addAttribute("page", page);
		
		model.addAttribute("categoryProduct", categoryProduct);
		return "Home";

	}

	@GetMapping("/searchCategoryProduct")
	public String searchProductByCategoryID(ModelMap model, Pageable pageable, @RequestParam("categoryID") int id) {
		List<CategoriesProduct> categoryProduct = categoryProductService.findAll();
		Page<Products> listProduct = productService.findAddByCategoryID(id, pageable);
		PageWrapper<Products> page = new PageWrapper<Products>(listProduct, "/listProduct");
		model.addAttribute("listProduct", page.getContent());
		model.addAttribute("page", page);
		model.addAttribute("categoryProduct", categoryProduct);
		return "Home";
	}

	@GetMapping("/searcProduct/{id}")
	public String searchProduct(@PathVariable("id") int id, ModelMap model) {
		Products p = productService.findOneByID(id);
		model.addAttribute("product", p);

		return "ProductDetail";

	}

	@GetMapping("/checkQuanity")
	@ResponseBody
	public boolean checkQuanity(@RequestParam("productID") int id, @RequestParam("quanity") int quanity) {
		Products p = productService.findOneByID(id);
		if (p.getQuality() < quanity) {

			return false;
		} else {

			return true;
		}

	}

	@GetMapping("/buyProduct")
	public String buyProduct(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "productID", defaultValue = "-1") int id,
			@RequestParam(value = "quanityField", defaultValue = "-1") int quanity) {

		Products p = null;
		if (id >= 0) {
			p = productService.findOneByID(id);

		}
		if (p != null) {

			CartInfo cartInfo = Util.getCartInSession(request);
			ProductInfo pInfo = new ProductInfo(p);
			cartInfo.addProduct(pInfo, quanity);
		}

		return "redirect:/showCart";
	}

	@GetMapping("/showCart")
	public String getCart(ModelMap model, HttpServletRequest request) {
		CartInfo cartInfo = Util.getCartInSession(request);

		model.addAttribute("cartInfo", cartInfo);
		model.addAttribute("totalAmount", cartInfo.getAmountTotal());
		model.addAttribute("totalQuantity", cartInfo.getQuantityTotal());
		return "ShowCart";
	}

	@GetMapping("/removeProduct")
	public String removeProduct(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "id", defaultValue = "-1") int id) {
		Products p = null;
		if (id >= 0) {
			p = productService.findOneByID(id);

		}
		if (p != null) {

			CartInfo cartInfo = Util.getCartInSession(request);
			ProductInfo pInfo = new ProductInfo(p);
			cartInfo.removeProduct(pInfo);
		}
		return "redirect:/showCart";
	}

	@GetMapping("/decreaseQuanity")
	public String decreaseQuanity(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "id", defaultValue = "-1") int id) {
		if (id > 0) {
			CartInfo cartInfo = Util.getCartInSession(request);
			cartInfo.updateDecreaseQuality(id);
		}
		return "redirect:/showCart";
	}

	@GetMapping("/increaseQuanity")
	public String increaseQuanity(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "id", defaultValue = "-1") int id) {
		if (id > 0) {
			CartInfo cartInfo = Util.getCartInSession(request);
			cartInfo.updateIncreaseQuality(id);
		}
		return "redirect:/showCart";
	}

	@GetMapping("/listOrder")
	public String listOrder(HttpServletRequest request, ModelMap model, Pageable pageable) {

		Principal principal = request.getUserPrincipal();
		Page<Orders> listOrder = orderService.findAllOrder(principal.getName(), pageable);
		PageWrapper<Orders> page = new PageWrapper<Orders>(listOrder, "/listOrder");
		model.addAttribute("listOrder", page.getContent());
		model.addAttribute("page", page);
		return "ListOrder";
	}

	@SuppressWarnings("unused")
	@GetMapping("/listOrderDetail")
	public String listOrderDetail(HttpServletRequest request, ModelMap model, Pageable pageable,
			@RequestParam("orderID") String orderID) {
		//Page<OrderDetail> listOrderDetail=null;
		Principal principal = request.getUserPrincipal();
		Page<Orders> listOrder = orderService.findAllOrder(principal.getName(), pageable);
	/*	for (int i = 0; i < listOrder.getSize(); i++) {
			if(listOrder.getContent().get(i).getOrderId().equals(orderID)) {
			 listOrderDetail=listOrder.getContent().get(i).getOrderDetailList();
				
			}
		}*/
		// Orders listOrder = orderService.findById(orderID);
		
	

		Page<OrderDetail> listOrderDetail = orderDetailService.findAllByID(orderID, pageable);

		PageWrapper<OrderDetail> page = new PageWrapper<OrderDetail>( listOrderDetail, "/listOrderDetail");
		model.addAttribute("listOrderDetail", page.getContent());
		model.addAttribute("page", page);

		return "OrderDetail";
	}
	/*
	 * @GetMapping("updateProduct") public String updateProduct(HttpServletRequest
	 * request, ModelMap model,
	 * 
	 * @RequestParam(value = "id", defaultValue = "-1") int id) { Products p = null;
	 * if (id >= 0) { p = prodcutService.findOneByID(id);
	 * 
	 * } if (p != null) {
	 * 
	 * CartInfo cartInfo = Util.getCartInSession(request); ProductInfo pInfo = new
	 * ProductInfo(p); cartInfo.updateProduct(id, quantity);
	 * 
	 * } return null; }
	 */

	// GET: Show Cart

	@GetMapping("/setCustomerInfo")
	public String setCustumerInfo(ModelMap model) {

		Customer c = new Customer();
		model.addAttribute("customer", c);
		return "CustomerInfo";
	}

	@PostMapping("/saveCart")
	public String saveCart(HttpServletRequest request, @ModelAttribute("customer") Customer c)
			throws ParseException {
		Principal principal = request.getUserPrincipal();
		CartInfo myCart = Util.getCartInSession(request);
		String email = principal.getName();

		Users u = userService.findByEmail(email);

		Orders order = new Orders();
		order.setOrderId(Common.genRand());
		order.setUser(u);
		order.setOrderDate(Common.CurrentDateTime());
		order.setAmount(myCart.getAmountTotal());
		order.setNameCustomer(c.getName());
		order.setMobileCustomer(c.getMobile());
		order.setAddressCustomer(c.getAddress());

		order.setStatus("Successfully");
		order.setNotes("no comment");

		orderService.saveOrder(order);

		List<CartLineInfo> lines = myCart.getCartLines();
		for (CartLineInfo line : lines) {
			Products p = productService.findOneByID(line.getProducs().getProductID());
			OrderDetail oDetail = new OrderDetail();

			oDetail.setOrder(order);
			oDetail.setProduct(p);
			oDetail.setQuanity(line.getQuantity());
			oDetail.setPrice(line.getProducs().getPrice());
			oDetail.setAmount(line.getAmount());

			orderDetailService.saveOrderDetail(oDetail);

			p.setQuality(p.getQuality() - line.getQuantity());
			if (p.getQuality() == 0) {
				p.setStatus("Het Hang");
				productService.updateQualityProduct(p);
			} else {

				productService.updateQualityProduct(p);
			}

		}

		Util.removeCartInSession(request);

		return "redirect:/listProduct";
	}

	@GetMapping("/updateOrder/{idOrder}")
	public String updateOrder(ModelMap model, @PathVariable("idOrder") String idOrder) {

		Orders o = orderService.findById(idOrder);
		o.setStatus("Cancel");
		orderService.saveOrder(o);

		return null;
	}

	@GetMapping("/listNews")
	public String listNews(ModelMap model, Pageable pageable) {

		Page<News> listNews = newsService.findAll(pageable);

		PageWrapper<News> page = new PageWrapper<News>(listNews, "/listNews");
		model.addAttribute("listNews", page.getContent());
		model.addAttribute("page", page);

		return "News";

	}

	@GetMapping("/admin")
	public String test(ModelMap model) {
		return "test";

	}

	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

}
