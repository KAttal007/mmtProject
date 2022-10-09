package com.mmt.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.flights.model.Flight;

@Controller
public class EditDeleteFlightController {
	@Autowired
	private AdminServiceInterface as;
	
	@RequestMapping("updateFlight") //-- updateFlightPage
	public String updateFlight(Flight  flight , Model m) {
		as.updateFlight(flight);
		m.addAttribute("message" , "flight added");
		return "updateFlightPage";
	}
	
	@RequestMapping("deleteFlight") // -- deleteFlightpage
	public String deleteFlight(@RequestParam("flightId")String flightId) {
		as.removeFlight(flightId);
		return "deleteFlightSuccessfully";
	}
}
