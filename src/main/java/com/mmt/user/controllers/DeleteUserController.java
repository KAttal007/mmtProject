package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class DeleteUserController {
	@Autowired
	private UserServiceInterface us;
	
	Logger logger = LoggerFactory.getLogger(DeleteUserController.class);
	
	@RequestMapping("deleteUserByUser")
	public String deleteUserByUser(HttpSession session , Model m) {
		String userId = (String) session.getAttribute("userId");
		if(userId==null) return "redirect:/userLoginNav";
		if(us.deleteUser(userId )) {
			session.removeAttribute("userId");
			return "userHomePage";
		}
		m.addAttribute("message" , "user not found");
		return "userHomePage";
	}
}
