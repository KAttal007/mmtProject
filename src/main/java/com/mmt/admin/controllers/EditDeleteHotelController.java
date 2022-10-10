package com.mmt.admin.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.hotels.model.Hotel;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@Validated
public class EditDeleteHotelController {
	@Autowired
	private AdminServiceInterface as;
	
	@RequestMapping("updateHotel") //-- updateHotelPage
	public String updateHotel(@Valid Hotel hotel , Model m, BindingResult br) {
		if(br.hasErrors())
		{
			m.addAttribute("message" , "Hotel details not entered properly");
			return "updateHotelPage";
		}
		if(as.updateHotel(hotel)) {
			m.addAttribute("message" , "Hotel updated");
			return "updateHotelPage";
		}
		m.addAttribute("message" , "Hotel not found");
		return "updateHotelPage";
	}
	
	@RequestMapping("deleteHotel") // -- deleteHotelpage
	public String deleteHotel(@RequestParam("hotelId")String hotelId , Model m) {
		if(as.removeHotel(hotelId)) {
			m.addAttribute("message" , "Hotel Deleted");
			return "removeHotelPage";
		}
		m.addAttribute("message" , "Hotel not found");
		return "removeHotelPage";
	}
}