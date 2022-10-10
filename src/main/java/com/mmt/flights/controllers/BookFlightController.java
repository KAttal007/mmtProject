package com.mmt.flights.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import com.mmt.flights.services.FlightServiceInterface;
import com.mmt.payment.CardDetails;




@Controller
public class BookFlightController {
	@Autowired
	private FlightServiceInterface fs;
	
	@RequestMapping("flightPaymentValidation")
	public String flightPaymentValidation(Model m) {
		m.addAttribute("card" , new CardDetails());
		return "flightPaymentPage";
	}
	
	
	@RequestMapping("bookFlight") //-- bookFlightPage
	public String bookFlight(@Valid @ModelAttribute("card")CardDetails card   ,BindingResult br,HttpSession session ) {
		String userId = (String) session.getAttribute("userId");
		if(userId== null) return "redirect:/userLoginNav";
		if(br.hasErrors()) {
			System.out.println(br.getAllErrors());
			return "flightPaymentPage";
		}else {
			String flightId = (String) session.getAttribute("flightId");
			int noOfSeats = (int) session.getAttribute("noOfSeats");
			if(fs.bookFlight(userId, flightId, noOfSeats)) {
				session.removeAttribute("flightId");
				session.removeAttribute("noOfSeats");
				return "userHome";
			}
		}
		return "flightPaymentPage";
	}
}
