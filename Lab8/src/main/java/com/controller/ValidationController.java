package com.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bean.Student2;
import com.bean.student1;

@Controller
public class ValidationController {

	@RequestMapping("/form")
	public String form1(ModelMap mm) {
		mm.addAttribute("student", new Student2());
		return "Student";
	}

	@RequestMapping(value = "/validate1", method = RequestMethod.POST)
	public String validate1(ModelMap model, @ModelAttribute("student") student1 student, BindingResult errors) {
		if(student.getName().trim().length() == 0){
			errors.rejectValue("name", "student",  "Vui lòng nhập họ tên !");
		}
		if(String.valueOf(student.getMark()) == null){
			errors.rejectValue("mark", "student",  "Vui lòng nhập điểm !");
		}
		else if(student.getMark() < 0 || student.getMark() > 10){
			errors.rejectValue("mark", "student",  "Điểm không hợp lệ  !");
		}
		if(student.getMajor() == null){
			errors.rejectValue("major", "student",  "Vui lòng chọn một chuyên ngành !");
		}
		if(errors.hasErrors()){
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
		}
		else{
			model.addAttribute("message", "Chúc mừng, bạn đã nhập đúng !");
		}

		return "Student";
	}
	/*
	 * : @Validated được thêm trước đối số student sẽ làm cho các annotation 
	 * kiểm lỗi được đính sẵn trong lớp Student2 hoạt động. Tất cả các thông báo lỗi được bổ sung một cách tự động vào errors.
	 * */
	@RequestMapping(value="validate2", method=RequestMethod.POST)
	public String validate2(ModelMap model,
	      @Validated @ModelAttribute("student") Student2 student,  BindingResult errors) {
		if(errors.hasErrors()){
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
		}
		else{
			model.addAttribute("message", "Chúc mừng, bạn đã nhập đúng !");
		}
		return "Student";
	}

	
	@RequestMapping("/")
	public String getIndex() {
		return "redirect:/form";
	}

}
