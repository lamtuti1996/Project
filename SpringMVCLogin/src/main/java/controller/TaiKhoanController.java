package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import entities.Taikhoan;

@Controller
@RequestMapping(value="/taikhoan")
public class TaiKhoanController {


	
	@RequestMapping(value="/login" ,method = RequestMethod.POST)
	public String login(@ModelAttribute(value="tk") Taikhoan tk, ModelMap mm ,HttpSession session) {
		if(tk.getUsername().equals("lam") &&tk.getPassword().equals("123")) {
			session.setAttribute("username", tk.getUsername());
			return "welcome";
		}else {
			mm.put("message", "Tk khong hop le");
			return "login";
		}
		
	}
	
	@RequestMapping(value="/logout" ,method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "login";
		
	}
}
