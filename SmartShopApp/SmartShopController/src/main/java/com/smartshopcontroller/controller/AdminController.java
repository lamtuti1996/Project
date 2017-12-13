package com.smartshopcontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.smartshopcommon.model.News;
import com.smartshopcommon.model.Orders;
import com.smartshopcommon.model.Products;
import com.smartshopmodel.service.CategoryNewsService;
import com.smartshopmodel.service.CategoryProductService;
import com.smartshopmodel.service.NewsService;
import com.smartshopmodel.service.OrderDetailService;
import com.smartshopmodel.service.OrderService;
import com.smartshopmodel.service.ProductService;
import com.smartshopmodel.service.RoleService;
import com.smartshopmodel.service.UserService;

@RestController
public class AdminController {
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

	@PostMapping("/saveProduct")
	public ResponseEntity<Void> saveProduct(@RequestBody Products p, UriComponentsBuilder ucBuilder) {
		productService.saveProduct(p);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand().toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PostMapping("/editProduct")
	public ResponseEntity<Void> updateOrder(UriComponentsBuilder ucBuilder, @RequestBody Products p) {

		productService.saveProduct(p);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/").buildAndExpand().toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getNewsByID")
	public ResponseEntity<News> getProductById(@RequestParam("newsID") int newsID) {
		News n=newsService.findByID(newsID);
		if (n == null) {
			return new ResponseEntity<News>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<News>(n, HttpStatus.OK);

	}
	
	
	@PostMapping("/editNews")
	public ResponseEntity<Void> editNews(UriComponentsBuilder ucBuilder, @RequestBody News n) {
		
		newsService.saveNews(n);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/").buildAndExpand().toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
	}
	
	
	
	

}
