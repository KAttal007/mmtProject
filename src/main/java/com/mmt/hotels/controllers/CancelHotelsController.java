package com.mmt.hotels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.hotels.services.HotelServiceInterface;

@Controller
public class CancelHotelsController {
	
	@Autowired
	private HotelServiceInterface hs;
	
	@RequestMapping("cancelHotelBooking") //--------- cancelHotelBookingPage
	public String cancelHotelBooking(@RequestParam("bookingId")String bookingId) {
		hs.cancelHotelBooking(bookingId);
		return "cancelHotelBookingSuccessfully";
	}
}
