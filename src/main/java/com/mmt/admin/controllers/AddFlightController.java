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

import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.flights.model.Flight;

@Controller
public class AddFlightController {
    @Autowired
    private AdminServiceInterface as;
    
    Logger logger = LoggerFactory.getLogger(AddFlightController.class);

    @RequestMapping("addFlight") // -- addFFlightPage
    public String addFlight(@Valid @ModelAttribute("flight")Flight flight ,BindingResult br ,Model m) {
    	if(br.hasErrors()) {
    		  m.addAttribute("message" , "There is Some error");
    	    	logger.error("Flight Not added");
    	        return "addFlightPage"; //throw new exception
    	}else {
    		as.addFlight(flight);
            m.addAttribute("message" , "Flight added");
            return "addFlightPage";
    	}
    }
}
