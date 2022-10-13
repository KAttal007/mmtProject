package com.mmt.admin.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.admin.model.Admin;
import com.mmt.admin.service.AdminServiceInterface;

@Controller
public class AdminSignUpController {
	@Autowired
	private AdminServiceInterface as;
	
	Logger logger = LoggerFactory.getLogger(AdminSignUpController.class);
	
	@RequestMapping("createAdmin")
	public String adminSignUp(@Valid @ModelAttribute("admin") Admin admin ,BindingResult br, HttpSession session) {
		String adminId = (String) session.getAttribute("adminId");
		if(adminId!=null) return "adminHomePage";
		if(br.hasErrors()) {
			logger.error("Admin SignUp Unsuccessful");
			return "adminSignUpPage";
		}
		as.createAdmin(admin);
		return "adminLoginPage";
	}
}