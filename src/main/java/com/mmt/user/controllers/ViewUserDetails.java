package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class ViewUserDetails {
	@Autowired
	private UserServiceInterface us;
	
	Logger logger = LoggerFactory.getLogger(ViewUserDetails.class);

	
	@RequestMapping("printUserDetails")
	public RedirectView printUserDetailsRedirect(HttpSession session , Model m) {
		String userId = (String) session.getAttribute("userId");
		if(userId==null) {
			return new RedirectView("userLoginNav");
		}
		User user = us.viewUser(userId);
		m.addAttribute("user", user);
		return new RedirectView("printUserDetailsDone");
	}
	
	@RequestMapping("printUserDetailsDone")
	public String printUserDetailsDone(HttpSession session ,Model m) {
		String userId = (String) session.getAttribute("userId");
		User user = us.viewUser(userId);
		m.addAttribute("user", user);
		return "userDetails";
	}
	
}
