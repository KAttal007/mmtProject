package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class ViewUserDetails {
	@Autowired
	private UserServiceInterface us;
	
	@RequestMapping("printUserDetails")
	public String printUserDetails(HttpSession session , Model m) {
		String userId = (String) session.getAttribute("userId");
		if(userId==null) {
			return "userLoginPage";
		}
		User user = us.viewUser(userId);
		m.addAttribute("user", user);
		return "userDetails";
	}
	
}
