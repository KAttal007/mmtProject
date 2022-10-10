package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.user.services.UserServiceInterface;

@Controller
public class DeleteUserController {
	@Autowired
	private UserServiceInterface us;
	
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
