package com.mmt.flights.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mmt.flights.services.FlightService;
@Controller
public class CancelFlightController {
	@Autowired
	private FlightService fs;
	
	
}
