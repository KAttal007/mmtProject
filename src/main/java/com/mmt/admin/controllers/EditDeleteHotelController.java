package com.mmt.admin.controllers;



import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.hotels.model.Hotel;

@Controller
public class EditDeleteHotelController {
	@Autowired
	private AdminServiceInterface as;
	
	Logger logger = LoggerFactory.getLogger(EditDeleteHotelController.class);

	
	@RequestMapping("updateHotel") //-- updateHotelPage
	public String updateHotel(@Valid @ModelAttribute("updateHotel") Hotel hotel ,BindingResult br ,Model m) {
		if(br.hasErrors()) return "updateHotelPage";
		if(as.updateHotel(hotel)) {
			m.addAttribute("message","hotel updated");
			return "adminHome";
		}
		m.addAttribute("message","hotel not found");
		return "updateHotelPage";
	}
	
	@RequestMapping("deleteHotel") //-- deleteHotelPage
	public String deleteHotel(@RequestParam("hotelId")String hotelId , Model m) {
		
		if(as.removeHotel(hotelId)) {
			m.addAttribute("message","hotel deleted");
			return "adminHome";
		}
		m.addAttribute("message","Wrong id");
		return "removeHotelPage";
	}
}
