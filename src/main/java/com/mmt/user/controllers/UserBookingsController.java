package com.mmt.user.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.flights.services.FlightServiceInterface;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class UserBookingsController {
	
	
	@Autowired
	private FlightServiceInterface fs;
	
//	@RequestMapping("bookFlight")
//	public String bookFlight(@RequestParam("flightId")String flight ,@RequestParam("noOfSeats")int noOfSeats, HttpSession session) {
//		String userId = (String) session.getAttribute("userId");
//		if(userId == null) {
//			return "userLoginpage";
//		}
//		fs.bookFlight(userId, flight, noOfSeats);
//		return "conformBooking";
//	}
	
}
