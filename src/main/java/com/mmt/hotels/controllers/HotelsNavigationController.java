package com.mmt.hotels.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.flights.controllers.BookFlightController;
import com.mmt.hotels.model.Hotel;

@Controller
public class HotelsNavigationController {
	
	Logger logger = LoggerFactory.getLogger(HotelsNavigationController.class);

	
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
