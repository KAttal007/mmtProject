package com.mmt.admin.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.admin.service.AdminServiceInterface;
import com.mmt.flights.model.Flight;

@Controller
public class AddFlightController {
    @Autowired
    private AdminServiceInterface as;

    @RequestMapping("addFlight") // -- addFFlightPage
    public String addFlight(@Valid Flight flight , Model m, BindingResult br) {
    	if(br.hasErrors())
    	{
    		m.addAttribute("message", "enter flight details correctly");
    		return "addFlightPage";
    	}
    	as.addFlight(flight);
        m.addAttribute("message" , "Flight added");
        return "addFlightPage";
    }
}
