package com.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;







@Controller
@RequestMapping("/controller")
public class MyController {
	
	@Autowired
	ServletContext context;
	

    
	@RequestMapping("/apply")
	public String upload(ModelMap model,
		@RequestParam("fullname") String fullname,
		@RequestParam("cv") MultipartFile cv,
		@RequestParam("photo") MultipartFile photo) {
		
		
			if(photo.isEmpty() || cv.isEmpty()){
				model.addAttribute("message", "Vui lòng chọn file !");
				}
				else{
				try {
				String photoPath = context.getRealPath("/files/"+photo.getOriginalFilename());
			
				
				photo.transferTo(new File(photoPath));
				String cvPath = context.getRealPath("/files/"+cv.getOriginalFilename());
				cv.transferTo(new File(cvPath));
				model.addAttribute("photo_name", photo.getOriginalFilename());
				model.addAttribute("cv_name", cv.getOriginalFilename());
				model.addAttribute("cv_type", cv.getContentType());
				model.addAttribute("cv_size", cv.getSize());
				return "apply";
				}
				catch (Exception e) {
				model.addAttribute("message", "Lỗi lưu file !");
				}
				}
				return "form";
		
	}
	@RequestMapping("/up")
	public String form1(ModelMap mm) {
	
		return "form";
	}
	
	
	@RequestMapping("/")
	public String getIndex() {
		return "redirect:/up";
	}

}
