package com.mmt.hotels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.hotels.services.HotelServiceInterface;

@Controller
public class ViewHotelsController {
	@Autowired
	private HotelServiceInterface hs;
	
	@RequestMapping("viewHotel") //-- viewHotelpage
	public String viewHotel(Model m) {
		m.addAttribute("hotelList" ,hs.allHotels() );
		return "hotelView";
	}
	@RequestMapping("viewHotelAtDestination") //-- viewHotelpage
	public String viewHotelAtDestination(@RequestParam("destination")String destination,Model m) {
		m.addAttribute("hotelList" ,hs.hotelAtDestinationCity(destination) );
		return "resultHotelPage";
	}
}