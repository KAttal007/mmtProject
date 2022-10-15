package com.mmt.admin.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.admin.exceptions.AdminNotFoundException;
import com.mmt.admin.model.Admin;
import com.mmt.admin.service.AdminServiceInterface;

@Controller
public class AdminLoginController {
	@Autowired
	private AdminServiceInterface as;
	
	Logger logger = LoggerFactory.getLogger(AdminLoginController.class);
	
	@ExceptionHandler(value = AdminNotFoundException.class)
	public String adminNotFoundExceptionHandler(Model m) {
		m.addAttribute("message", "wrong username or password");
		logger.error("Wrong Username or Password");
		return "adminLoginPage";
	}
	
	@RequestMapping("adminLogin" )//adminLoginPage -- jsp
	public String adminLogin(Admin admin , Model m) throws AdminNotFoundException{
		if(as.login(admin)) return "adminHomePage";
		m.addAttribute("message" , "wrong username or password");
		throw new AdminNotFoundException("Admin Not Found");
	}
	
	@RequestMapping("adminLogout")
	public String userLogout() {
		return "LandingHomePage";
	}
	
}
