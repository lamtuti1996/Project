package com.smartshop.views.controller;

import java.net.URI;
import java.security.Principal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.junit.experimental.categories.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.smartshopcommon.entity.CartInfo;
import com.smartshopcommon.entity.CategoryNewsObj;
import com.smartshopcommon.entity.CategoryProductObj;
import com.smartshopcommon.entity.Customer;
import com.smartshopcommon.entity.NewsObj;
import com.smartshopcommon.entity.OrderCustomize;
import com.smartshopcommon.entity.OrderDetailObj;
import com.smartshopcommon.entity.OrderObj;
import com.smartshopcommon.entity.OrderSave;
import com.smartshopcommon.entity.PageWrapper;
import com.smartshopcommon.entity.ProductInfo;
import com.smartshopcommon.entity.ProductObj;
import com.smartshopcommon.entity.RegisterUser;
import com.smartshopcommon.entity.RestResponsePage;
import com.smartshopcommon.model.CategoriesNews;
import com.smartshopcommon.model.News;
import com.smartshopcommon.model.OrderDetail;
import com.smartshopcommon.model.Orders;
import com.smartshopcommon.model.Products;
import com.smartshopcommon.model.Users;
import com.smartshopcommon.utils.Util;

@Controller
public class ViewsController {
	private static final String URL = "http://localhost:8082/";

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String setLogin() {

		return "login";

	}

	@GetMapping("/setRegister")
	public String setRegister(ModelMap model) {
		RegisterUser ru = new RegisterUser();
		model.addAttribute("rUser", ru);

		return "Register";
	}

	@GetMapping("/getProductByID")
	public String getProductByID(ModelMap model, @RequestParam("id") int id) {
		String url = URL + "getProductByID/{id}";
		RestTemplate restTemplate = new RestTemplate();
		ProductObj p = restTemplate.getForObject(url, ProductObj.class, id);
		model.addAttribute("product", p);
		return "ProductDetail";
	}

	@GetMapping("/setHome")
	public String setHome(ModelMap model, Pageable pageable) {
		RestTemplate restTemplate = new RestTemplate();
		ParameterizedTypeReference<RestResponsePage<ProductObj>> ptr = new ParameterizedTypeReference<RestResponsePage<ProductObj>>() {
		};
		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("getAllProduct")
				.queryParam("page", pageable.getPageNumber()).queryParam("size", pageable.getPageSize()).build()
				.toUri();

		Page<ProductObj> listProduct = restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();
		PageWrapper<ProductObj> page = new PageWrapper<ProductObj>(listProduct, "/setHome");

		String url = URL + "getAllCategoryProduct";
		List<Categories> listC = restTemplate.getForObject(url, List.class);

		model.addAttribute("listProduct", page.getContent());
		model.addAttribute("page", page);
		model.addAttribute("categoryProduct", listC);

		return "Home";
	}

	@GetMapping("/searchCategoryProduct")
	public String searchCategoryProduct(HttpServletRequest request, ModelMap model, Pageable pageable,
			@RequestParam(value = "categoryID", required = false, defaultValue = "-1") int id) {
		RestTemplate restTemplate = new RestTemplate();
		int categoryID = id;
		if (categoryID == -1) {
			categoryID = Util.getCategoryID(request);
		} else {
			Util.setCategoryID(request, categoryID);
		}
		ParameterizedTypeReference<RestResponsePage<ProductObj>> ptr = new ParameterizedTypeReference<RestResponsePage<ProductObj>>() {
		};
		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("getAllProductByCategory")
				.queryParam("categoryID", categoryID).queryParam("page", pageable.getPageNumber())
				.queryParam("size", pageable.getPageSize()).build().toUri();

		Page<ProductObj> listProduct = restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();

		PageWrapper<ProductObj> page = new PageWrapper<ProductObj>(listProduct, "/searchCategoryProduct");

		String url = URL + "getAllCategoryProduct";
		List<CategoryProductObj> listC = restTemplate.getForObject(url, List.class);

		model.addAttribute("listProduct", page.getContent());
		model.addAttribute("page", page);
		model.addAttribute("categoryProduct", listC);

		return "Home";
	}

	@GetMapping("/checkQuanity")
	@ResponseBody
	public boolean checkQuanity(@RequestParam("productID") int id, @RequestParam("quanity") int quanity) {
		String url = URL + "getProductByID/{id}";
		RestTemplate restTemplate = new RestTemplate();
		ProductObj p = restTemplate.getForObject(url, ProductObj.class, id);
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
		String url = URL + "getProductByID/{id}";
		RestTemplate restTemplate = new RestTemplate();
		ProductObj p = null;
		if (id >= 0) {
			p = restTemplate.getForObject(url, ProductObj.class, id);

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
		String url = URL + "getProductByID/{id}";
		RestTemplate restTemplate = new RestTemplate();
		ProductObj p = null;
		if (id >= 0) {
			p = restTemplate.getForObject(url, ProductObj.class, id);

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

		RestTemplate restTemplate = new RestTemplate();
		Principal principal = request.getUserPrincipal();
		ParameterizedTypeReference<RestResponsePage<OrderObj>> ptr = new ParameterizedTypeReference<RestResponsePage<OrderObj>>() {
		};
		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("getAllOrder")
				.queryParam("email", principal.getName()).queryParam("page", pageable.getPageNumber())
				.queryParam("size", pageable.getPageSize()).build().toUri();

		Page<OrderObj> listOrder = restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();
		PageWrapper<OrderObj> page = new PageWrapper<OrderObj>(listOrder, "/listOrder");

		model.addAttribute("listOrder", page.getContent());
		model.addAttribute("page", page);
		return "ListOrder";
	}

	@PostMapping("/saveCart")
	public String saveCart(HttpServletRequest request, ModelMap model, @ModelAttribute("customer") Customer c)
			throws ParseException {
		try {

			RestTemplate restTemplate = new RestTemplate();
			Principal principal = request.getUserPrincipal();
			CartInfo myCart = Util.getCartInSession(request);
			String email = principal.getName();

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
		return "redirect:/setHome";
	}

	@GetMapping("/setCustomerInfo")
	public String setCustumerInfo(ModelMap model) {

		Customer c = new Customer();
		model.addAttribute("customer", c);
		return "CustomerInfo";
	}

	@GetMapping("/listOrderDetail")
	public String listOrderDetail(HttpServletRequest request, ModelMap model, Pageable pageable,
			@RequestParam(value = "orderID", required = false, defaultValue = "-1") String id) {
		String orderID = id;
		if (orderID.equals("-1")) {
			orderID = Util.getOrderID(request);
		} else {
			Util.setOrderID(request, orderID);
		}
		RestTemplate restTemplate = new RestTemplate();

		ParameterizedTypeReference<RestResponsePage<OrderCustomize>> ptr = new ParameterizedTypeReference<RestResponsePage<OrderCustomize>>() {
		};
		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("getAllOrderDetail").queryParam("orderID", orderID)
				.queryParam("page", pageable.getPageNumber()).queryParam("size", pageable.getPageSize()).build()
				.toUri();

		Page<OrderCustomize> listOrderDetail = restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();

		PageWrapper<OrderCustomize> page = new PageWrapper<OrderCustomize>(listOrderDetail, "/listOrderDetail");

		model.addAttribute("listOrderDetail", page.getContent());
		model.addAttribute("page", page);

		return "OrderDetail";
	}

	@GetMapping("/getAllNews")
	public String pageNews(Pageable pageable, ModelMap model) {
		RestTemplate restTemplate = new RestTemplate();
		ParameterizedTypeReference<RestResponsePage<NewsObj>> ptr = new ParameterizedTypeReference<RestResponsePage<NewsObj>>() {
		};
		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("getAllNews")
				.queryParam("page", pageable.getPageNumber()).queryParam("size", pageable.getPageSize()).build()
				.toUri();

		Page<NewsObj> listNews = restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();
		PageWrapper<NewsObj> page = new PageWrapper<NewsObj>(listNews, "/getAllNews");

		String url = URL + "getAllCategoryProduct";
		List<CategoryNewsObj> listC = restTemplate.getForObject(url, List.class);

		model.addAttribute("listNews", page.getContent());
		model.addAttribute("page", page);
		model.addAttribute("categoryProduct", listC);

		return "News";
	}

	@GetMapping("/searchNewsByID")
	public String searchNewsByID(@RequestParam("newsID") int newsID, ModelMap model) {
		RestTemplate restTemplate = new RestTemplate();

		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("searchNewsByID").queryParam("newsID", newsID)
				.build().toUri();

		NewsObj n = restTemplate.exchange(targetUrl, HttpMethod.GET, null, NewsObj.class).getBody();

		String url = URL + "getAllCategoryProduct";
		List<CategoryNewsObj> listC = restTemplate.getForObject(url, List.class);

		model.addAttribute("news", n);
		model.addAttribute("categoryProduct", listC);

		return "NewsDetail";
	}

	@GetMapping("/setEditNews")
	public String setEditNews(@RequestParam("newsID") int newsID, ModelMap model) {
		RestTemplate restTemplate = new RestTemplate();

		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("searchNewsByID").queryParam("newsID", newsID)
				.build().toUri();

		NewsObj n = restTemplate.exchange(targetUrl, HttpMethod.GET, null, NewsObj.class).getBody();

		String url = URL + "getAllCategoryNews";
		List<CategoryNewsObj> listN = restTemplate.getForObject(url, List.class);

		model.addAttribute("news", n);
		model.addAttribute("categoryNews", listN);

		return "NewsDetail";
	}

	@GetMapping("/editNews")
	public String editNews(ModelMap model, @RequestBody News n) {
		RestTemplate restTemplate = new RestTemplate();

		String url = URL + "editNews";

		restTemplate.put(url, n);

		return "redirect:/getAllNews";
	}

}
