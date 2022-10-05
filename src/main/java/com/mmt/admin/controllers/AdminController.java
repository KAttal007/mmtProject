package com.mmt.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping("adminHomePage")
	public String getadminHomePage() {
		return "adminHomePage";
	}
	

}
