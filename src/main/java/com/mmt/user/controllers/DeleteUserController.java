package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.user.services.UserServiceInterface;

@Controller
public class DeleteUserController {
	@Autowired
	private UserServiceInterface us;
	
	@RequestMapping("deleteUserByUser")
	public String deleteUserByUser(HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if(us.deleteUser(userId)) {
			session.removeAttribute("userId");
			return "homePage";
		}
		return "";//to be implemented
	}
}
