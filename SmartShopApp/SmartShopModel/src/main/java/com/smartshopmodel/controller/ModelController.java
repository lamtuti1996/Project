package com.smartshopmodel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.smartshopcommon.model.CategoriesNews;
import com.smartshopcommon.model.CategoriesProduct;
import com.smartshopcommon.model.News;
import com.smartshopcommon.model.OrderDetail;
import com.smartshopcommon.model.Orders;
import com.smartshopcommon.model.Products;
import com.smartshopcommon.model.Role;
import com.smartshopcommon.model.Users;
import com.smartshopmodel.service.CategoryNewsService;
import com.smartshopmodel.service.CategoryProductService;
import com.smartshopmodel.service.NewsService;
import com.smartshopmodel.service.OrderDetailService;
import com.smartshopmodel.service.OrderService;
import com.smartshopmodel.service.ProductService;
import com.smartshopmodel.service.RoleService;
import com.smartshopmodel.service.UserService;

//@RestController
public class ModelController {

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

	@PostMapping("/getAllProduct")
	public ResponseEntity<Page<Products>> listAllProduct(@RequestBody Pageable pageable) {
		Page<Products> listProduct = productService.findAll(pageable);
		if (listProduct.getSize() == 0) {
			return new ResponseEntity<Page<Products>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<Page<Products>>(listProduct, HttpStatus.OK);
	}

	@PostMapping("/getAllProductByCategory")
	public ResponseEntity<Page<Products>> listAllProductByCategory(@RequestBody Pageable pageable, int id) {
		Page<Products> listProduct = productService.findAddByCategoryID(id, pageable);
		if (listProduct.getSize() == 0) {
			return new ResponseEntity<Page<Products>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<Page<Products>>(listProduct, HttpStatus.OK);
	}

	@GetMapping("/getProductByID")
	public ResponseEntity<Products> getProductById(@RequestParam("id") int id) {
		Products p = productService.findOneByID(id);
		if (p == null) {
			return new ResponseEntity<Products>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Products>(p, HttpStatus.OK);

	}

	@GetMapping("/findRoleByName")
	public ResponseEntity<Role> getRoleByName(@RequestParam("name") String name) {
		Role r = roleService.findRoleByName(name);
		if (r == null) {

			return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Role>(r, HttpStatus.OK);

	}

	@PostMapping("/saveUser")
	public ResponseEntity<Void> saveUser(@RequestBody Users u) {
		Users check = userService.findByEmail(u.getEmail());
		if (check != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
		userService.saveUser(u);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/getAllOrder")
	public ResponseEntity<Page<Orders>> getAllOrder(@RequestBody Pageable pageable, String email) {
		Page<Orders> listOrder = orderService.findAllOrder(email, pageable);
		if (listOrder.getSize() == 0) {
			return new ResponseEntity<Page<Orders>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<Page<Orders>>(listOrder, HttpStatus.OK);
	}

	@PostMapping("/saveOrder")
	public ResponseEntity<Void> saveOrder(@RequestBody Orders o) {
		Orders check = orderService.findById(o.getOrderId());
		if (check != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
		orderService.saveOrder(o);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/saveOrderDetail")
	public ResponseEntity<Void> saveOrderDetail(@RequestBody OrderDetail od) {
		orderDetailService.saveOrderDetail(od);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/updateQuanityProduct")
	public ResponseEntity<Void> updateQuanityProduct(@RequestBody Products p) {

		productService.saveProduct(p);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/updateOrder")
	public ResponseEntity<Void> updateOrder(@RequestBody Orders o) {

		orderService.saveOrder(o);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/getAllNews")
	public ResponseEntity<Page<News>> getAllNews(@RequestBody Pageable pageable) {

		Page<News> listNews = newsService.findAll(pageable);
		if (listNews.getSize() == 0) {
			return new ResponseEntity<Page<News>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<Page<News>>(listNews, HttpStatus.OK);
	}

	@PostMapping("/saveProduct")
	public ResponseEntity<Void> saveProduct(@RequestBody Products p) {

		productService.saveProduct(p);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/saveNews")
	public ResponseEntity<Void> saveNews(@RequestBody News n) {

		newsService.saveNews(n);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/getNewsByID")
	public ResponseEntity<News> getNewsByID(@RequestParam("id") int id) {
		News n = newsService.findByID(id);
		if (n == null) {

			return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<News>(n, HttpStatus.OK);

	}

	@GetMapping("/getNewsByCategory")
	public ResponseEntity<Page<News>> getNewsByCategory(@RequestBody Pageable pageable) {
		Page<News> listNews = newsService.findAll(pageable);
		if (listNews.getSize() == 0) {

			return new ResponseEntity<Page<News>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<News>>(listNews, HttpStatus.OK);
	}

	@GetMapping("/getAllCategoryProduct")
	public ResponseEntity<List<CategoriesProduct>> getAllCategoryProduct() {
		List<CategoriesProduct> listCategory = categoryProductService.findAll();
		if (listCategory.size() == 0) {

			return new ResponseEntity<List<CategoriesProduct>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CategoriesProduct>>(listCategory, HttpStatus.OK);
	}

	@GetMapping("/getAllCategoryNews")
	public ResponseEntity<List<CategoriesNews>> getAllCategoryNews() {
		List<CategoriesNews> listCategory = categoryNewsService.findAll();
		if (listCategory.size() == 0) {

			return new ResponseEntity<List<CategoriesNews>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CategoriesNews>>(listCategory, HttpStatus.OK);
	}
}
