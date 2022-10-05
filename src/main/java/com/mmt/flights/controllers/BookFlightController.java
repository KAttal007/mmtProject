package com.mmt.flights.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.flights.model.Flight;
import com.mmt.flights.services.FlightService;
import com.mmt.user.model.User;


@Controller
public class BookFlightController {
	@Autowired
	private FlightService fs;
	
	
	@RequestMapping("bookFlight") //-- bookFlightPage
	public String bookFlight(Flight flight , @RequestParam("noOfSeats")int noOfSeats ,@RequestParam("flightId")String flightId ,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(fs.bookFlight(user, flightId, noOfSeats)) return "succesfullyBookedFlight";
		return "BookedFlightFailed";
	}
}
