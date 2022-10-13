package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.user.exceptions.EmailAlreadyExistsException;
import com.mmt.user.model.User;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class UserSignUpController {
	@Autowired
	private UserServiceInterface us;
	
	Logger logger = LoggerFactory.getLogger(UserSignUpController.class);
	
	@ExceptionHandler(value = {EmailAlreadyExistsException.class})
	public String EmailAlreadyExistExceptionHandler(Model m) {
		logger.error("Email ID alredy in use");
		// return "redirect:/userLoginNav";
		return "emailAlreadyExist";
	}

	@RequestMapping("createUser")
	public String userSignUp(@Valid @ModelAttribute("user") User user ,BindingResult br, HttpSession session) throws EmailAlreadyExistsException {
		String userId = (String) session.getAttribute("userId");
		if (userId != null)
			return "userHome";
		if (br.hasErrors()) {
			return "userSignUpPage";
		}
		if (us.createuser(user)) {
			return "userLoginPage";
		}
		throw new EmailAlreadyExistsException("Email Alredy exist");
	}
}
