package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class UpdateDetailsController {
	@Autowired
	private UserServiceInterface us;
	
	@RequestMapping("updateUserDetails")
	public String updateUserDetails(User user , HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if(userId==null) return "userLoginPage";
		us.updateUser(user , userId);
		return "userDetails";
	}
//	
//	@RequestMapping("updateUserAddress")
//	public String updateUserAddress(Address address,HttpSession session) {
//		String userId = (String) session.getAttribute("userId");
//		if(userId==null) return "userLoginPage";
//		us.updateUserAddress(address, userId);
//		return "userAddressDetails";
//	}
//	
//	@RequestMapping("addUserAddress")
//	public String addUserAddress(Address address,HttpSession session) {
//		String userId = (String) session.getAttribute("userId");
//		if(userId==null) return "userLoginPage";
//		us.addAddress(address, userId);
//		return "userAddressDetails";
//	}
	
}
