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
	public String deleteUserByUser(@RequestParam("password")String password ,HttpSession session , Model m) {
		String userId = (String) session.getAttribute("userId");
		if(userId==null) return "userLoginPage";
		if(us.deleteUser(userId , password)) {
			session.removeAttribute("userId");
			return "homePage";
		}
		m.addAttribute("message" , "wrong password");
		return "userDeletePage";
	}
}
