package com.mmt.admin.controllers;

import javax.validation.Valid;

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
	
//	@RequestMapping("addHotel") // -- addHotelPage
//	public String addHotel(Hotel hotel , Model m) {
//		as.addHotel(hotel);
//		m.addAttribute("message","hotel Added Successfully");
//		return "addHotelPage";
//	}
//	
//	@RequestMapping("addHotelValid")
//	public String display(Model m) {
//		m.addAttribute("hotel" , new Hotel());
//		return "addHotelPage";
//	}
	
	@RequestMapping("addHotel") // -- addHotelPage
	public String addHotel(@Valid @ModelAttribute("hotel") Hotel hotel,BindingResult br,Model m) {
		if(br.hasErrors()) {
			return "addHotelPage";
		}
		else {
			as.addHotel(hotel);
			m.addAttribute("message","hotel Added Successfully");
			return "addHotelPage";
		}
	}
	
	
}
