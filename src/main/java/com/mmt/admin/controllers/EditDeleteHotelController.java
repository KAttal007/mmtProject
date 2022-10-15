package com.mmt.admin.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.admin.exceptions.HotelIdNotFoundException;
import com.mmt.admin.exceptions.HotelNotDeletedException;
import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.hotels.model.Hotel;

@Controller
public class EditDeleteHotelController {
	@Autowired
	private AdminServiceInterface as;
	
	Logger logger = LoggerFactory.getLogger(EditDeleteHotelController.class);
	
	@ExceptionHandler(value = HotelIdNotFoundException.class)
	public String hotelIdNotFoundExceptionHandler(Model m) {
		m.addAttribute("message", "Hotel Not Found");
		logger.error("Hotel Not Found");
		return "hotelNotPresentAlert";
	}
	
	
	@ExceptionHandler(value = HotelNotDeletedException.class)
	public String HotelIdNotFoundDeleteExceptionHandler(Model m) {
		m.addAttribute("message", "Hotel Not Found");
		logger.error("Hotel Not Found");
		return "removeHotelPage";
	}
	
	@RequestMapping("updateHotel") //-- updateHotelPage
	public String updateHotel(@Valid @ModelAttribute("updateHotel") Hotel hotel ,BindingResult br ,Model m) throws HotelIdNotFoundException{
		if(br.hasErrors()) {
			logger.error("Hotel Not updated");
			return "updateHotelPage";}
		if(as.updateHotel(hotel)) {
			m.addAttribute("message","hotel updated");
			return "adminHome";
		}
		m.addAttribute("message","hotel not updated");
		logger.error("Hotel Not Updated");
		throw new HotelIdNotFoundException("Hotel not updated");
	}
	
	@RequestMapping("deleteHotel") //-- deleteHotelPage
	public String deleteHotel(@RequestParam("hotelId")String hotelId , Model m) throws HotelNotDeletedException{
		
		if(as.removeHotel(hotelId)) {
			m.addAttribute("message","hotel deleted");
			return "adminHome";
		}
		m.addAttribute("message","Wrong id");
		logger.error("Hotel Not Deleted");
		throw new HotelNotDeletedException("Hotel Not Deleted");
	}
}