package com.mmt.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.admin.services.AdminServiceInterface;
import com.mmt.flights.model.Flight;

@Controller
public class AddFlightController {
	@Autowired
	private AdminServiceInterface as;
	
	@RequestMapping("goAddFlights")
	public String goAddFlight()
	{
		return "addFlightPage";
	}
	
	@RequestMapping("addFlight") // -- addFFlightPage
	public String addHotel(Flight flight, Model m) {
		as.addFlight(flight);
		m.addAttribute("message", "Flight added succesfully");
		return "addFlightPage";
	}
}
