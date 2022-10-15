package com.mmt.flights.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.flights.exceptions.FlightSeatsNotAvailableException;
import com.mmt.flights.model.Flight;
import com.mmt.flights.services.FlightServiceInterface;
import com.mmt.user.exceptions.NoFlightBookingException;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class ViewFlightDetailsController {
	@Autowired
	private FlightServiceInterface fs;
	@Autowired
	private UserServiceInterface us;
	
	Logger logger = LoggerFactory.getLogger(ViewFlightDetailsController.class);

	@ExceptionHandler(value = NoFlightBookingException.class)
	public String flightFoundExceptionHandler(Model m) {
		m.addAttribute("message", "No flight Found ");
		logger.error("No flight booked");
		return "resultFlightPage";
	}
	
	@ExceptionHandler(value = FlightSeatsNotAvailableException.class)
	public String flightSeatsNAExceptionHandler(Model m)
	{
		m.addAttribute("message" , "No seat avilable");
		
		return "bookFlightPage";
	}
	
	
	@RequestMapping("viewFlightOne")
	public String viewFlightOne(@RequestParam("flightId")String flightId , Model m) {
		Flight flight =fs.viewFlightDetails(flightId);
		m.addAttribute("FlightDetails" ,flight );
		return "viewOneFlightPage";
	}
	@RequestMapping("checkAvailabilty")
	public String checkAvailabilty(@RequestParam("flightId")String flightId , @RequestParam("noOfSeats")int noOfSeats, 
			HttpSession session , Model m) throws FlightSeatsNotAvailableException{
		String userId = (String) session.getAttribute("userId");
		if(userId==null) return "redirect:/userLoginNav";
		if(fs.isSeatsAvilable(flightId, noOfSeats)) {
			float price = fs.flightPrice(flightId, noOfSeats);
			session.setAttribute("noOfSeats" , noOfSeats);
			session.setAttribute("flightId" , flightId);
			session.setAttribute("price", price );
			return "redirect:/flightPaymentValidation";
		}
		logger.error("Seats "+noOfSeats+" wanting to be booked are more than seats currently available");
		throw new FlightSeatsNotAvailableException("Seats wanting to be booked are more than seats currently available");
	}
	@RequestMapping("viewMyFlightBooking")
	public String viewMyFlightBooking(Model m , HttpSession session) throws NoFlightBookingException {
		String userId = (String) session.getAttribute("userId");
		if (userId == null)
			return "userLoginPage";
		List<BookedFlight> flight = us.allBookedFlight(userId);
		if (flight.size() > 0) {
			m.addAttribute("list", flight);
			return "viewMyBookingPage";
		}
		logger.error("No Flights booked by user "+userId);
		throw new NoFlightBookingException("No Flight Booking by user ");
	}
}