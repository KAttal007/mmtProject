package com.mmt.hotels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.hotels.model.Hotel;

@Controller
public class HotelsNavigationController {
	@RequestMapping("searchHotels")
	public String searchHotels() {
		return "searchHotelPage";
	}
	
	@RequestMapping("goUpdateHotel")
	public String goUpdateHotel(Model m) {
		m.addAttribute("updateHotel" , new Hotel());
		return "updateHotelPage";
	}
}
