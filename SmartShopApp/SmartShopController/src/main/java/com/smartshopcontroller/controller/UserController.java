
package com.smartshopcontroller.controller;

import java.net.URI;
import java.security.Principal;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.smartshopcommon.entity.Error;
import com.smartshopcommom.common.Common;
import com.smartshopcommon.entity.CartInfo;
import com.smartshopcommon.entity.CartLineInfo;
import com.smartshopcommon.entity.ObjectNotFoundException;
import com.smartshopcommon.entity.OrderCustomize;
import com.smartshopcommon.entity.OrderSave;
import com.smartshopcommon.entity.PageWrapper;
import com.smartshopcommon.entity.ProductInfo;
import com.smartshopcommon.entity.RegisterUser;
import com.smartshopcommon.entity.RestResponsePage;
import com.smartshopcommon.model.CategoriesNews;
import com.smartshopcommon.model.CategoriesProduct;
import com.smartshopcommon.model.News;
import com.smartshopcommon.model.OrderDetail;
import com.smartshopcommon.model.Orders;
import com.smartshopcommon.model.Products;
import com.smartshopcommon.model.Role;
import com.smartshopcommon.model.Users;
import com.smartshopcommon.utils.Util;
import com.smartshopmodel.service.CategoryNewsService;
import com.smartshopmodel.service.CategoryProductService;
import com.smartshopmodel.service.NewsService;
import com.smartshopmodel.service.OrderDetailService;
import com.smartshopmodel.service.OrderService;
import com.smartshopmodel.service.ProductService;
import com.smartshopmodel.service.RoleService;
import com.smartshopmodel.service.UserService;

@RestController
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

	@GetMapping(value = "/ping")
	public ResponseEntity<String> list() {

		return new ResponseEntity<String>("pong", HttpStatus.OK);
	}

	@RequestMapping(value = "/checkLogin")
	public ResponseEntity<UserDetails> checkLogin(@RequestParam("name") String name) {

		UserDetails user = userDetailService.loadUserByUsername(name);

		if (user == null) {
			throw new ObjectNotFoundException();
		}
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllProduct")
	public ResponseEntity<Page<Products>> listAllProduct(@RequestParam("page") int page,
			@RequestParam("size") int size) {

		PageRequest request = new PageRequest(page, size);

		Page<Products> listProduct = productService.findAll(request);

		if (listProduct.getSize() == 0) {
			throw new ObjectNotFoundException();
		}
		return new ResponseEntity<Page<Products>>(listProduct, HttpStatus.OK);
	}

	@RequestMapping(value = "/addCategoryProduct", method = RequestMethod.POST)
	public ResponseEntity<CategoriesProduct> addCategoryProduct(@RequestBody CategoriesProduct cp,
			UriComponentsBuilder ucb) {

		categoryProductService.saveCategoryProduct(cp);
		HttpHeaders header = new HttpHeaders();
		URI locationUri = ucb.path("").path(String.valueOf(cp.getCategoryID())).build().toUri();
		header.setLocation(locationUri);

		ResponseEntity<CategoriesProduct> responseEntity = new ResponseEntity<CategoriesProduct>(cp, header,
				HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/getAllCategoryProduct")
	public ResponseEntity<List<CategoriesProduct>> getAllCategoryProduct() {
		List<CategoriesProduct> listCategory = categoryProductService.findAll();
		if (listCategory.size() == 0) {

			throw new ObjectNotFoundException();
		}
		return new ResponseEntity<List<CategoriesProduct>>(listCategory, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllProductByCategory", headers = "Accept=application/json")
	public ResponseEntity<Page<Products>> listAllProductByCategory(Pageable pageable,
			@RequestParam("categoryID") int id) {
		Page<Products> listProduct = productService.findAddByCategoryID(id, pageable);

		if (listProduct.getSize() == 0 || listProduct == null) {
			throw new ObjectNotFoundException(String.valueOf(id));

		}
		return new ResponseEntity<Page<Products>>(listProduct, HttpStatus.OK);
	}

	@GetMapping("/getProductByID/{id}")
	public ResponseEntity<Products> getProductById(@PathVariable("id") int id) {
		Products p = productService.findOneByID(id);
		if (p == null) {
			throw new ObjectNotFoundException(String.valueOf(id));

		}
		return new ResponseEntity<Products>(p, HttpStatus.OK);

	}

	@GetMapping("/checkQuanity")
	public ResponseEntity<Boolean> checkQuanity(@RequestParam("productID") int id,
			@RequestParam("quanity") int quanity) {
		Products p = productService.findOneByID(id);
		if (p == null) {
			throw new ObjectNotFoundException(String.valueOf(id));

		}

		if (p.getQuality() < quanity) {

			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		} else {

			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}

	}

	@GetMapping(value = "/getAllOrder", headers = "Accept=application/json")
	public ResponseEntity<Page<Orders>> getAllOrder(@RequestParam("email") String email, Pageable pageable) {

		Page<Orders> listOrder = orderService.findAllOrder(email, pageable);

		if (listOrder.getSize() == 0) {
			throw new ObjectNotFoundException(email);

		}

		return new ResponseEntity<Page<Orders>>(listOrder, HttpStatus.OK);

	}

	@GetMapping("/getAllOrderDetail")
	public ResponseEntity<RestResponsePage<OrderCustomize>> getAllOrderDetail(@RequestParam("orderID") String orderID,
			@RequestParam("page") int page, @RequestParam("size") int size) {
		/*
		 * int page = 0; int size = 3;
		 */
		PageRequest request = new PageRequest(page, size);
		int pageSize = size;
		int currentPage = page;
		// int pageSize = pageable.getPageSize();
		// currentPage = pageable.getPageNumber();
		long n = orderDetailService.getCountAllOrderDetailByOrderID(orderID);
		int totalRow = Integer.parseInt(String.valueOf(n));
		int totalPage = totalRow / pageSize + 1;
		int startingIndex = pageSize * currentPage;// from row
		if (startingIndex < 0) {
			startingIndex = 0;
		}
		int endingIndex = startingIndex + pageSize;
		if (endingIndex > totalRow) {
			endingIndex = totalRow;
		}

 		List<OrderCustomize> listOrderDetail = orderDetailService.findAllOrderDetailByOrderID(orderID, startingIndex,
				endingIndex);

		boolean first = true;
		boolean last = true;

		if (currentPage == 0 && currentPage != (totalPage - 1) && (totalPage - 1) != 1) {
			first = true;
			last = false;
		} else if (currentPage != 0 && currentPage == (totalPage - 1)) {
			first = false;
			last = true;
		} else if (currentPage != 0 && currentPage != (totalPage - 1)) {

			first = false;
			last = false;
		}

		RestResponsePage<OrderCustomize> test = new RestResponsePage<>(listOrderDetail, currentPage, pageSize,
				totalPage, listOrderDetail.size(), n, first, last);
		test.setContent(listOrderDetail);
		/*
		 * test.setContent(listOrderDetail);
		 * test.setNumberOfElements(listOrderDetail.size()); test.setTotalElements(n);
		 * test.setSize(pageSize); test.setNumber(currentPage);
		 */
		/*
		 * if (currentPage == 0) { test.setFirst(true); test.setLast(false); } else if
		 * (currentPage == totalPage) { test.setFirst(false); test.setLast(true); } else
		 * {
		 * 
		 * test.setFirst(false); test.setLast(false); }
		 */

		if (listOrderDetail.size() == 0) {
			throw new ObjectNotFoundException(orderID);

		}
		return new ResponseEntity<RestResponsePage<OrderCustomize>>(test, HttpStatus.OK);
	}

	@PostMapping("/saveCart")
	public ResponseEntity<Void> saveCart(HttpServletRequest request, UriComponentsBuilder ucBuilder,
			@RequestBody OrderSave os) throws ParseException {

		Users u = userService.findByEmail(os.getEmail());

		Orders order = new Orders();
		order.setOrderId(Common.genRand());
		order.setUser(u);
		order.setOrderDate(Common.CurrentDateTime());
		order.setAmount(os.getMyCart().getAmountTotal());
		order.setNameCustomer(os.getCustomer().getName());
		order.setMobileCustomer(os.getCustomer().getMobile());
		order.setAddressCustomer(os.getCustomer().getAddress());

		order.setStatus("Successfully");
		order.setNotes("no comment");

		orderService.saveOrder(order);

		List<CartLineInfo> lines = os.getMyCart().getCartLines();
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

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/getAllProduct").buildAndExpand().toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/updateOrder/{idOrder}")
	public ResponseEntity<Void> updateOrder(UriComponentsBuilder ucBuilder, @PathVariable("idOrder") String idOrder) {

		Orders o = orderService.findById(idOrder);
		o.setStatus("Cancel");
		orderService.saveOrder(o);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/").buildAndExpand().toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getAllNews")
	public ResponseEntity<Page<News>> getAllNews(Pageable pageable) {
		Page<News> listNews = newsService.findAll(pageable);

		if (listNews.getSize() == 0) {
			throw new ObjectNotFoundException();

		}
		return new ResponseEntity<Page<News>>(listNews, HttpStatus.OK);
	}

	@GetMapping("/searchNewsByID")
	public ResponseEntity<News> searchNewsByID(@RequestParam("newsID") int id) {
		News n = newsService.findByID(id);

		if (n == null) {
			throw new ObjectNotFoundException(String.valueOf(id));
		}
		return new ResponseEntity<News>(n, HttpStatus.OK);
	}

	@GetMapping("/editNews")
	public ResponseEntity<Void> editNews(@RequestBody News n) {
		newsService.saveNews(n);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Void> registerUser(@RequestBody RegisterUser ru, UriComponentsBuilder ucBuilder)
			throws ParseException {

		Users u = new Users();

		HashSet<Role> roles = new HashSet<>();
		roles.add(roleService.findRoleByName("ROLE_MEMBER"));

		u.setEmail(ru.getEmail());
		u.setPassword(ru.getPassword());
		u.setCreatedTime(Common.CurrentDateTime());
		u.setRoles(roles);
		userService.saveUser(u);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/").buildAndExpand().toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);

	}

	@PutMapping("insertTimeLogin")
	public ResponseEntity<Void> insertTimeLogin(@RequestParam("name") String name) throws ParseException {

		Users user = userService.findByEmail(name);
		user.setLastAccess(Common.CurrentDateTime());
		userService.saveUser(user);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getAllCategoryNews")
	public ResponseEntity<List<CategoriesNews>> getAllCategoryNews() {
		List<CategoriesNews> listCategory = categoryNewsService.findAll();
		if (listCategory.size() == 0) {

			throw new ObjectNotFoundException();
		}
		return new ResponseEntity<List<CategoriesNews>>(listCategory, HttpStatus.OK);
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error objectNotFound(ObjectNotFoundException e) {
		Error error = new Error();
		int code = -1;
		String id = "";
		id = e.getId();
		if (id.equals("") || id == null) {
			error.setCode(code);
			error.setMessage(" not found");
		} else {
			error.setCode(code);
			error.setMessage(id + " not found");
		}

		return error;
	}

}
