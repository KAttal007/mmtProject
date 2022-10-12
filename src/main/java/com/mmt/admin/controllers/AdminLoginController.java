package com.mmt.admin.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(AdminLoginController.class);
	
	@RequestMapping("adminLogin" )//adminLoginPage -- jsp
	public String adminLogin(Admin admin , Model m) {
		if(as.login(admin)) return "adminHomePage";
		m.addAttribute("message" , "wrong username or password");
		return "adminLoginPage";
	}
	
	@RequestMapping("adminLogout")
	public String userLogout() {
		return "LandingHomePage";
	}
	
}
