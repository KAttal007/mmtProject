package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class UserLoginController {
	@Autowired
	private UserServiceInterface us;
	
	Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	
	@RequestMapping("userLogin")
	public String userLogin(@ModelAttribute("user") User user ,BindingResult br, HttpSession session  ,Model m) {
		if(br.hasErrors()) {
			return "userLoginPage";
		}
		if(us.userLogin(user)) {
			String userId = us.userName(user.getMailID(), user.getPassword());
			session.setAttribute("userId", userId);
			return "userHome";
		}
		m.addAttribute("message" , "wrong userName or Password");
		return "userLoginPage";
	}
	
	@RequestMapping("userLogout")
	public String userLogout(HttpSession session ) {
		session.removeAttribute("userId");
		return "userHome";
	}
}
