package com.springboot.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.common.Common;
import com.springboot.entity.NewsCreate;
import com.springboot.model.CategoriesNews;
import com.springboot.model.News;
import com.springboot.model.Products;
import com.springboot.service.CategoryNewsService;
import com.springboot.service.NewsService;
import com.springboot.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;
	
	@Autowired
	NewsService newsService;
	
	@Autowired
	private CategoryNewsService categoryNewsService;

	@GetMapping("setCreateProduct")
	public String setCreateProduct(ModelMap model) {
         Products p=new Products();
         model.addAttribute("product", p);
		return "CreateProduct";
	}

	@PostMapping("saveProduct")
	public String saveProduct(ModelMap model, @ModelAttribute("product") Products p) {
		productService.saveProduct(p);

		return null;
	}
	
	
	@GetMapping("editProduct")
	public String editProduct(ModelMap model,@RequestParam("productID") int productID) {
		Products p=productService.findOneByID(productID);
		model.addAttribute("product", p);
		
		return "EditProduct";
	}
	
	
	@GetMapping("/editNews")
	public String editNews(ModelMap model,@RequestParam("newsID") int newsID) {
		News n=newsService.findByID(newsID);
		model.addAttribute("news", n);
		return "EditNews";
	}

	@GetMapping("/setCreateNews")
	public String setCreateNews(ModelMap model) {
		List<CategoriesNews> cnList = categoryNewsService.findAll();
		NewsCreate nc = new NewsCreate();

		model.addAttribute("listCategory", cnList);
		model.addAttribute("nc", nc);
		return "CreateNews";

	}

	@PostMapping("/createNews")
	public String createNews(@Valid @ModelAttribute("newsCreate") NewsCreate newsCreate, ModelMap model)
			throws ParseException {
		News n = new News();
		CategoriesNews cn = categoryNewsService.findByID(newsCreate.getCategoriesID());
		n.setTitle(newsCreate.getTitle());
		n.setContent(newsCreate.getContent());
		n.setCreateDate(Common.CurrentDateTime());
		n.setCategoryNews(cn);

		newsService.saveNews(n);
		return "redirect:/listNews";
	}


}
