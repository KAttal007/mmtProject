package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.user.exceptions.UserNotUpdatedException;
import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class UpdateDetailsController {
	@Autowired
	private UserServiceInterface us;
	
	Logger logger = LoggerFactory.getLogger(UpdateDetailsController.class);
	
	@ExceptionHandler(value = {UserNotUpdatedException.class})
	public String userNotUpdatedDetailsExceptionHandler(Model m)
	{	
		m.addAttribute("message", "User Details Not Updated");
		logger.error("User Details Not Updated");
		return "redirect:/updateUserDetailsPage";
	}
	
	@RequestMapping("updateUserDetails")
	public String updateUserDetails(User user , HttpSession session, BindingResult br, Model m) throws UserNotUpdatedException {
		String userId = (String) session.getAttribute("userId");
		if(br.hasErrors())
		{
			throw new UserNotUpdatedException("Details Not Updated");
		}
		if(userId==null) return "redirect:/userLoginNav";
		us.updateUser(user , userId);
		return "userDetails";
	}

	
}
