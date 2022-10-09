package com.mmt.flights.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.flights.model.Flight;
import com.mmt.flights.service.FlightServiceInterface;

@Controller
public class ViewFlightDetailsController {
	@Autowired
	private FlightServiceInterface fs;
	
	@RequestMapping("viewFlightOne")
	public String viewFlightOne(@RequestParam("flightId")String flightId , Model m) {
		Flight flight =fs.viewFlightDetails(flightId);
		m.addAttribute("FlightDetails" ,flight );
		return "viewOneFlightPage";
	}
	

}
