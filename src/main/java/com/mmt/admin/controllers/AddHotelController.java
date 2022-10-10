package com.mmt.admin.controllers;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.hotels.model.Hotel;

@Controller
public class AddHotelController {
	@Autowired
	private AdminServiceInterface as;

	@RequestMapping("addHotel") // -- addHotelPage
	public String addHotel(@Valid @ModelAttribute("hotel") Hotel hotel, BindingResult br,Model m) {
		if(br.hasErrors()) {
			m.addAttribute("message" , "There is Some error");
		}
		else {
			as.addHotel(hotel);
			m.addAttribute("message","hotel Added Successfully");
			
		}
		return "addHotelPage";
	}
	
	
}
