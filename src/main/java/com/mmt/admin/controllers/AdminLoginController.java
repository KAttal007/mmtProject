package com.mmt.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.admin.model.Admin;
import com.mmt.admin.service.AdminServiceInterface;

@Controller
public class AdminLoginController {
	@Autowired
	private AdminServiceInterface as;
	
	@RequestMapping("adminLogin" )//adminLoginForm -- jsp
	public String adminLogin(Admin admin , Model m) {
		if(as.login(admin)) return "adminHome";
		m.addAttribute("message" , "wrong username or password");
		return "adminLoginForm";
	}
	
	@RequestMapping("goAddHotel")
	public String addHotelNav() {
		return "addHotelPage";
	}
}
