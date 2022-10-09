package com.mmt.flights.controllers;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mmt.flights.model.Flight;
import com.mmt.flights.services.FlightServiceInterface;
import com.mmt.user.dao.UserDao;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class ViewFlightDetailsController {
	@Autowired
	private FlightServiceInterface fs;
	@Autowired
	private UserServiceInterface us;
	
	@RequestMapping("viewFlightOne")
	public String viewFlightOne(@RequestParam("flightId")String flightId , Model m) {
		Flight flight =fs.viewFlightDetails(flightId);
		m.addAttribute("FlightDetails" ,flight );
		return "viewOneFlightPage";
	}
	
	@RequestMapping("checkAvailabilty")
	public String checkAvailabilty(@RequestParam("flightId")String flightId , @RequestParam("noOfSeats")int noOfSeats , HttpSession session , Model m) {
		String userId = (String) session.getAttribute("userId");
		if(userId==null) return "userLoginPage";
		if(fs.isSeatsAvilable(flightId, noOfSeats)) {
			float price = fs.flightPrice(flightId, noOfSeats);
			m.addAttribute("noOfSeats" , noOfSeats).addAttribute("flightId" , flightId).addAttribute("price", price );
			return "flightPaymentPage";
		}
		m.addAttribute("message" , "No seat avilable");
		return "bookFlightPage";
	}
	
	@RequestMapping("viewMyFlightBooking")
	public String viewMyFlightBooking(Model m , HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if(userId== null) return "userLoginPage";
		m.addAttribute("list" , us.allBookedFlight(userId)).addAttribute("flightList" );
		return "viewMyBookingPage";
	}

}
