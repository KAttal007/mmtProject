package com.mmt.flights.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.flights.model.Flight;

@Controller
public class FlightsNavigationController {
	@RequestMapping("searchFlight")
	public String searchFlight() {
		return "searchFlightPage";
	}
	
	@RequestMapping("goUpdateFlight")
	public String goUpdateFlight(Model m) {
		m.addAttribute("updateFlight" , new Flight());
		return "updateFlightPage";
	}
	
}
