package com.mmt.hotels.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.hotels.services.HotelServiceInterface;
import com.mmt.payment.CardDetails;


@Controller
public class BookHotelsController {
	@Autowired 
	private HotelServiceInterface hs;
	
	
//	@RequestMapping("bookHotel") //--------bookHotelForm
//	public String bookHotel(@Valid @ModelAttribute("card")CardDetails c,BindingResult br ,@RequestParam("hotelId")String hotelId , @RequestParam("noOfRooms")int noOfRooms,@RequestParam("isAc")boolean isAc, HttpSession session,Model m) {
//		String userId = (String) session.getAttribute("userId");
//		m.addAttribute("login", new CardDetails());
//		if(br.hasErrors()) return "hotelPaymentPage";
//		if(userId==null) return "userLogin";
//		hs.bookHotel(hotelId,userId, noOfRooms, isAc);
//		return "userHome";
//	}
	
		
	
	@RequestMapping("bookHotel") //--------bookHotelForm
	public String bookHotel(@Valid @ModelAttribute("cardHotel")CardDetails cardHotel, BindingResult br ,HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if(br.hasErrors()) return "hotelPaymentPage";
		if(userId==null) return "redirect:/userLoginNav";
		String hotelId = (String) session.getAttribute("hotelId");
		boolean isAc = (boolean) session.getAttribute("isAc");
		int noOfRooms = (int) session.getAttribute("noOfRooms");
		System.out.println(hotelId+" "+isAc+" "+noOfRooms);
		hs.bookHotel(hotelId,userId, noOfRooms, isAc);
		return "userHome";
	}
}
