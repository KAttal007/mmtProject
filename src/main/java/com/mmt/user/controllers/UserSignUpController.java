package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class UserSignUpController {
	@Autowired
	private UserServiceInterface us;
	
	@RequestMapping("createUser")
	public String userSignUp(@Valid @ModelAttribute("user") User user ,BindingResult br, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if(userId!=null) return "userHome";
		if(br.hasErrors()) {
			return "userSignUpPage";
		}
		us.createuser(user);
		return "userLoginPage";
	}
}
