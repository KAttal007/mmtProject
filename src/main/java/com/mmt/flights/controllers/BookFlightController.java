package com.mmt.flights.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.flights.model.Flight;

import com.mmt.flights.services.FlightServiceInterface;




@Controller
public class BookFlightController {
	@Autowired
	private FlightServiceInterface fs;
	
	
	@RequestMapping("bookFlight") //-- bookFlightPage
	public String bookFlight(Flight flight , @RequestParam("noOfSeats")int noOfSeats ,@RequestParam("flightId")String flightId ,HttpSession session,Model m) {
		String userId = (String) session.getAttribute("userId");
		if(userId== null) return "userLoginPage";
	
			if(fs.bookFlight(userId, flightId, noOfSeats))
			return "userHome";
		
		m.addAttribute("message" , "not enough seats");
		return "bookFlightPage";
	}
}
