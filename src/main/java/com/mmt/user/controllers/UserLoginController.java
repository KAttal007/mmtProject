package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class UserLoginController {
	@Autowired
	private UserServiceInterface us;
	
	@RequestMapping("userLogin")
	public String userLogin(@ModelAttribute("user") User user , HttpSession session  ,Model m, BindingResult br) {
		if(br.hasFieldErrors("emailId")||br.hasFieldErrors("password")) {
			m.addAttribute("message", "Login failed. Enter Details correctly");
			return "userLoginPage";
		}
		if(us.userLogin(user)) {
			String userId = us.userName(user.getEmailId(), user.getPassword());
			session.setAttribute("userId", userId);
			return "userHome";
		}
		else {
			m.addAttribute("message", "Login failed. Enter Details correctly");
			return "userLoginPage";
		}	
	}
	
	@RequestMapping("userLogout")
	public String userLogot(HttpSession session ) {
		session.removeAttribute("userId");
		return "LandingHomePage";
	}
}
