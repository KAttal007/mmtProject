package com.mmt.hotels.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.hotels.model.Hotel;
import com.mmt.hotels.services.HotelServiceInterface;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class ViewHotelsController {
	@Autowired
	private HotelServiceInterface hs;
	@Autowired
	private UserServiceInterface us;
	
	@RequestMapping("viewHotel") //-- viewHotelpage
	public String viewHotel(Model m) {
		m.addAttribute("hotelList" ,hs.allHotels() );
		return "hotelView";
	}
	@RequestMapping("viewHotelAtDestination") //-- viewHotelpage
	public String viewHotelAtDestination(@RequestParam("search")String destination,Model m) {
		m.addAttribute("hotelList" ,hs.hotelAtDestinationCity(destination) );
		return "resultHotelPage";
	}
	
	@RequestMapping("viewMyHotelBooking")
	public String viewMyHotelBooking(HttpSession session,Model m) {
		String userId = (String) session.getAttribute("userId" );
		if(userId== null) return "userLoginPage";
		m.addAttribute("hotelList" , us.allBookedHotels(userId));
		return "viewMyHotelBookingPage";
	}
	
	@RequestMapping("checkHotel")
	public String checkHotel(@RequestParam("hotelId")String hotelId , Model m) {
		Hotel hotel = hs.viewHotel(hotelId);
		m.addAttribute("hotel" , hotel);
		return "bookHotelPage";
	}
	
}
