package com.mmt.user.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserNavigationsController {
	
	@RequestMapping("updateUserDetailsPage")
	public String updateUserDetailsPage() {
		return "userUpdateDetails";
	}
	
	@RequestMapping("userSignUp")
	public String userSignUpPage() {
		return "userSignUpPage";
	}
	
	@RequestMapping("userLoginNav")
	public String userLoginNav() {
		return "userLoginPage";
	}
	
//	@RequestMapping("updateUserAddressPage")
//	public String updateUserAddressPage() {
//		return "userUpdateAddress";
//	}
//	
//	@RequestMapping("addAddressToUser")
//	public String addAddressToUser() {
//		return "addAddressUser";
//	}
}
