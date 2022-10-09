package com.mmt.hotels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.hotels.services.HotelServiceInterface;

@Controller
public class ViewHotelsDetailsController {
	
	@Autowired
	private HotelServiceInterface hs;
	
	@RequestMapping("viewHotelDetails") //-- viewHotelPage
	public String viewHotelDetails(@RequestParam("hotelId")String hoetlId , Model m) {
		m.addAttribute("hotelDetails" , hs.viewHotel(hoetlId));
		return "viewHotelPage";
	}
}