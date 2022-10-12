package com.mmt.admin.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.flights.model.Flight;
import com.mmt.flights.services.FlightServiceInterface;

@Controller
public class EditDeleteFlightController {
	@Autowired
	private AdminServiceInterface as;
	
	@Autowired
	private FlightServiceInterface fs;
	
	Logger logger = LoggerFactory.getLogger(EditDeleteFlightController.class);

	
	@RequestMapping("updateFlight") //-- updateFlightPage
	public String updateFlight(@Valid @ModelAttribute("updateFlight") Flight  flight ,BindingResult br, Model m) {
		if(br.hasErrors()) { 
			logger.error("Flight Not updated");
			return "updateFlightPage";}
		if(!fs.isFlightPresent(flight.getFlightId())) {}
		if(as.updateFlight(flight)) {
			m.addAttribute("message" , "flight updated");
			return "updateFlightPage";
		}
		m.addAttribute("message" , "flight not found");
		logger.error("Flight Not found");
		return "updateFlightPage";
	}
	
	@RequestMapping("deleteFlight") // -- deleteFlightpage
	public String deleteFlight(@RequestParam("flightId")String flightId , Model m) {
		if(as.removeFlight(flightId)) {
			m.addAttribute("message" , "flight Deleted");
			return "removeFlightPage";
		}
		m.addAttribute("message" , "flight not found");
		logger.error("Flight Not Deleted");
		return "removeFlightPage";
	}
}
