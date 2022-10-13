package com.mmt.hotels.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mmt.hotels.services.HotelServiceInterface;
import com.mmt.payment.CardDetails;


@Controller
public class BookHotelsController {
	@Autowired 
	private HotelServiceInterface hs;
	Logger logger = LoggerFactory.getLogger(BookHotelsController.class);

	
	
	@RequestMapping("bookHotel") // --------bookHotelForm
	public String bookHotel(@Valid @ModelAttribute("cardHotel") CardDetails cardHotel, BindingResult br,
			HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if (br.hasErrors())
			return "hotelPaymentPage";
		if (userId == null)
			return "redirect:/userLoginNav";
		String hotelId = (String) session.getAttribute("hotelId");
		boolean isAc = (boolean) session.getAttribute("isAc");
		int noOfRooms = (int) session.getAttribute("noOfRooms");
		hs.bookHotel(hotelId, userId, noOfRooms, isAc);
		return "userHome";
	}
}
