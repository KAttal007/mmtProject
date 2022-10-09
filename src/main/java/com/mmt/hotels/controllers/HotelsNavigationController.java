package com.mmt.hotels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelsNavigationController {
	@RequestMapping("searchHotels")
	public String searchHotels() {
		return "searchHotelPage";
	}
	
	@RequestMapping("goUpdateHotel")
	public String goUpdateHotel() {
		return "updateHotelPage";
	}
}
