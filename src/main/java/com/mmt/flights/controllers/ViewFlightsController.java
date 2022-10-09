package com.mmt.flights.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.flights.model.Flight;
import com.mmt.flights.services.FlightServiceInterface;
@Controller
public class ViewFlightsController {
	
	@Autowired
	private FlightServiceInterface fs;
	
	
	@RequestMapping("viewFlightSourceToDestination")
	public String sourceToDestinationFlight(@RequestParam("source")String source , @RequestParam("destination")String destination,Model m) {
		List<Flight> list = fs.flightFromStartCityToDestinationCityInOrder(source, destination); 
		m.addAttribute("flightList" , list);
		return "resultFlightPage";
	}
	
	@RequestMapping("checkFlight")
	public String checkFlight(@RequestParam("flightId")String flightId , Model m) {
		Flight flight = fs.viewFlightDetails(flightId);
		m.addAttribute("flight" , flight);
		return "bookFlightPage";
	}
}
