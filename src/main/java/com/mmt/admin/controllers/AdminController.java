package com.mmt.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("adminLoginNav")
	public String adminLogin() {
		return "adminLoginPage";
	}
	
	@RequestMapping("adminHomePage")
	public String adminHomePage() {
		return "adminHome";
	}
	
	@RequestMapping("goAddFlights")
	public String goAddFlights() {
		return "addFlightPage";
	}
	
	@RequestMapping("goRemoveHotel")
	public String goRemoveHotel() {
		return "removeHotelPage";
	}
	
	@RequestMapping("goRemoveFlight")
	public String goRemoveFlight() {
		return "removeFlightPage";
	}
}
