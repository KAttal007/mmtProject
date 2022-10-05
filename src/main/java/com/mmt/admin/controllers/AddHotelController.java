package com.mmt.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.admin.services.AdminServiceInterface;
import com.mmt.hotels.model.Hotel;

@Controller
public class AddHotelController {
	@Autowired
	private AdminServiceInterface as;
	
	@RequestMapping("addHotel") // -- addHotelPage
	public String addHotel(Hotel hotel) {
		as.addHotel(hotel);
		return "hotelAddedSuccessfully";
	}
}
