package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.user.exceptions.UserNotDeletedException;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class DeleteUserController {
	@Autowired
	private UserServiceInterface us;
	
	Logger logger = LoggerFactory.getLogger(DeleteUserController.class);
	
	
	@ExceptionHandler(value = UserNotDeletedException.class)
	public String userNotDeletedExceptionHandler(Model m)
	{
		m.addAttribute("message", "user not found");
		logger.error("User Not Found");
		return "userHomePage";
	}
	
	
	@RequestMapping("deleteUserByUser")
	public String deleteUserByUser(HttpSession session, Model m) throws UserNotDeletedException {
		String userId = (String) session.getAttribute("userId");
		if (userId == null)
			return "redirect:/userLoginNav";
		if (us.deleteUser(userId)) {
			session.removeAttribute("userId");
			return "userHomePage";
		}
		throw new UserNotDeletedException("User Not Deleted");
	}
}
