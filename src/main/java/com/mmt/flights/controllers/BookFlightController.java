package com.mmt.flights.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.flights.model.Flight;
import com.mmt.flights.service.FlightService;
import com.mmt.flights.service.FlightServiceInterface;
import com.mmt.user.model.User;

@Controller
public class BookFlightController {
	@Autowired
	private FlightServiceInterface fs;
	
	
	@RequestMapping("bookFlight") //-- bookFlightPage
	public String bookFlight(Flight flight , @RequestParam("noOfSeats")int noOfSeats ,@PathVariable String flightId ,HttpSession session) {
		String userId = (String) session.getAttribute("user");
		if(userId== null) return "userLoginPage";
		if(fs.bookFlight(userId, flightId, noOfSeats)) return "succesfullyBookedFlight";
		return "BookedFlightFailed";
	}
}
