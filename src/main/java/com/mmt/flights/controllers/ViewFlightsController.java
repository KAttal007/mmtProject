package com.mmt.flights.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.flights.exceptions.FlightNotFoundForSourceToDestinationException;
import com.mmt.flights.model.Flight;
import com.mmt.flights.services.FlightServiceInterface;
@Controller
public class ViewFlightsController {
	
	@Autowired
	private FlightServiceInterface fs;
	
	Logger logger = LoggerFactory.getLogger(ViewFlightsController.class);

	@ExceptionHandler(value = FlightNotFoundForSourceToDestinationException.class)
	public String FlightNotFoundForSourceToDestinationException(Model m) {
		return "resultFlightPage";
	}

	@RequestMapping("viewFlightSourceToDestination")
	public String sourceToDestinationFlight(@RequestParam("source") String source,
			@RequestParam("destination") String destination, Model m)
			throws FlightNotFoundForSourceToDestinationException {
		List<Flight> list = fs.flightFromStartCityToDestinationCityInOrder(source, destination);
		if (list.size() > 0) {
			m.addAttribute("flightList", list);
			return "resultFlightPage";
		}
		logger.error("No Flight from source "+source+ " to destination "+destination);
		throw new FlightNotFoundForSourceToDestinationException("Error 404. No Flight Found");
	}

	@RequestMapping("checkFlight")
	public String checkFlight(@RequestParam("flightId") String flightId, Model m) {
		Flight flight = fs.viewFlightDetails(flightId);
		m.addAttribute("flight", flight);
		return "bookFlightPage";
	}
}
