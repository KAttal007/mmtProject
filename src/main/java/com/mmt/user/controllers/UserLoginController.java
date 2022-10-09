package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class UserLoginController {
	@Autowired
	private UserServiceInterface us;
	
	@RequestMapping("userLogin")
	public String userLogin(User user , HttpSession session  ,Model m) {
		if(us.userLogin(user)) {
			String userId = us.userName(user.getMailID(), user.getPassword());
			session.setAttribute("userId", userId);
			return "userHome";
		}
		m.addAttribute("message" , "wrong userName or Password");
		return "userLoginPage";
	}
	
	@RequestMapping("userLogout")
	public String userLogot(HttpSession session ) {
		session.removeAttribute("userId");
		return "userHome";
	}
}
