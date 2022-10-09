package com.mmt.flights.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FlightsNavigationController {
	@RequestMapping("searchFlight")
	public String searchFlight() {
		return "searchFlightPage";
	}
	
	@RequestMapping("goUpdateFlight")
	public String goUpdateFlight() {
		return "updateFlightPage";
	}
	
}
