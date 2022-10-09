package com.mmt.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.hotels.model.Hotel;

@Controller
public class EditDeleteHotelController {
	@Autowired
	private AdminServiceInterface as;
	
	@RequestMapping("updateHotel") //-- updateHotelPage
	public String updateHotel(Hotel hotel , Model m) {
		as.updateHoetl(hotel);
		m.addAttribute("message","hotel updated");
		return "updateHotelSuccessfully";
	}
	
	@RequestMapping("deleteHotel") //-- deleteHotelPage
	public String deleteHotel(@RequestParam("hotelId")String hotelId) {
		as.removeHotel(hotelId);
		return "removedHotelSuccessfully";
	}
}
