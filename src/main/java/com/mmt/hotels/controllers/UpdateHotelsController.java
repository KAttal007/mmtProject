package com.mmt.hotels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.hotels.model.Hotel;


@Controller
public class UpdateHotelsController {
	@Autowired
	private AdminServiceInterface as;
	
//	@RequestMapping("updateHotel") // --- updateHotelPage
//	public String updateHotel(Hotel hotel) {
//		as.updateHoetl(hotel);
//		return "hotelUpdatedSuccesfully";
//	}
}
