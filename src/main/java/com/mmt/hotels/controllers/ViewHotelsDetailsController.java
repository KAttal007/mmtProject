package com.mmt.hotels.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.hotels.services.HotelServiceInterface;
import com.mmt.payment.CardDetails;

@Controller
public class ViewHotelsDetailsController {
	
	@Autowired
	private HotelServiceInterface hs;
	
	@RequestMapping("viewHotelDetails") //-- viewHotelPage
	public String viewHotelDetails(@RequestParam("hotelId")String hoetlId , Model m) {
		m.addAttribute("hotelDetails" , hs.viewHotel(hoetlId));
		return "viewHotelPage";
	}
	
	@RequestMapping("checkHotelAvailabilty")
	public String checkHotelAvailabilty(@RequestParam("hotelId")String hoetlId ,@RequestParam("isAc")boolean isAc, @RequestParam("noOfRooms")int noOfRooms, HttpSession session,Model m) {
		String userId = (String) session.getAttribute("userId");
		if(userId==null) return "redirect:/userLoginNav";
		if(hs.isRoomAvilable(hoetlId, noOfRooms, isAc)){
			session.setAttribute("hotelId", hoetlId);
			session.setAttribute("noOfRooms" , noOfRooms);
			session.setAttribute("isAc" , isAc);
			return "redirect:/hotelPaymentValidation";
		}
		m.addAttribute("message" , "Rooms not aviliable");
		return "bookHotelPage";
	}
	
	
	@RequestMapping("hotelPaymentValidation")
	public String hotelPaymentValidation(Model m) {
		m.addAttribute("cardHotel", new CardDetails());
		return "hotelPaymentPage";
	}
}
