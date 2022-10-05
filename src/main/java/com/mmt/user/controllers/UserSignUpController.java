package com.mmt.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class UserSignUpController {
	@Autowired
	private UserServiceInterface us;
	
	@RequestMapping("userSignup")
	public String userSignUp(User user) {
		us.createuser(user);
		return "userLoginPage";
	}

}
