package com.mmt.admin.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.flights.model.Flight;

@Controller
@Validated
public class EditDeleteFlightController {
	@Autowired
	private AdminServiceInterface as;
	
	@RequestMapping("updateFlight") //-- updateFlightPage
	public String updateFlight(@Valid Flight flight , Model m, BindingResult br) {
		if(br.hasErrors())
		{
			m.addAttribute("message" , "flight details not entered properly");
			return "updateFlightPage";
		}
		if(as.updateFlight(flight)) {
			m.addAttribute("message" , "flight updated");
			return "updateFlightPage";
		}
		m.addAttribute("message" , "flight not found");
		return "updateFlightPage";
	}
	
	@RequestMapping("deleteFlight") // -- deleteFlightpage
	public String deleteFlight(@RequestParam("flightId")String flightId , Model m) {
		if(as.removeFlight(flightId)) {
			m.addAttribute("message" , "flight Deleted");
			return "removeFlightPage";
		}
		m.addAttribute("message" , "flight not found");
		return "removeFlightPage";
	}
}