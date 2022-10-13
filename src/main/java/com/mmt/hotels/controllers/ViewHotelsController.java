package com.mmt.hotels.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.bookedHotel.model.BookedHotel;
import com.mmt.hotels.exceptions.HotelNotFoundException;
import com.mmt.hotels.model.Hotel;
import com.mmt.hotels.services.HotelServiceInterface;
import com.mmt.user.exceptions.NoHotelBookingFoundException;
import com.mmt.user.services.UserServiceInterface;

@Controller
public class ViewHotelsController {
	@Autowired
	private HotelServiceInterface hs;
	@Autowired
	private UserServiceInterface us;
	
	Logger logger = LoggerFactory.getLogger(ViewHotelsController.class);

	@ExceptionHandler(value = HotelNotFoundException.class)
	public String hotelFoundExceptionHandler(Model m) {
		m.addAttribute("message", "No Hotel Found At Destination");
		logger.error("No Hotel Found At Destination");
		return "resultHotelPage";
	}
	
	@ExceptionHandler(value =NoHotelBookingFoundException.class)
	public String noHotelBookingByUserExceptionHandler(Model m) {
		m.addAttribute("message", "No Booking Found");
		logger.error("No Hotel Booked by user");
		return "viewMyHotelBookingPage";
	}
	
	@RequestMapping("viewHotel") //-- viewHotelpage
	public String viewHotel(Model m) {
		m.addAttribute("hotelList" ,hs.allHotels() );
		return "hotelView";
	}
	@RequestMapping("viewHotelAtDestination") //-- viewHotelpage
	public String viewHotelAtDestination(@RequestParam("search")String destination,Model m) throws HotelNotFoundException {
		List<Hotel> hotel = hs.hotelAtDestinationCity(destination);
		if(hotel.size()>0) {
			m.addAttribute("hotelList" ,hs.hotelAtDestinationCity(destination) );
			return "resultHotelPage";
		}else {
			throw new HotelNotFoundException("No Hotel Found At Destination");
		}
	}
	
	@RequestMapping("viewMyHotelBooking")
	public String viewMyHotelBooking(HttpSession session,Model m) throws NoHotelBookingFoundException {
		String userId = (String) session.getAttribute("userId" );
		if(userId== null) return "redirect:/userLoginNav";
		List<BookedHotel> hotel = us.allBookedHotels(userId);
		if(hotel.size()>0) {
			m.addAttribute("hotelList" , hotel);
			return "viewMyHotelBookingPage";
		}
		throw new NoHotelBookingFoundException("No booking Done by user");
	}
	
	@RequestMapping("checkHotel")
	public String checkHotel(@RequestParam("hotelId")String hotelId , Model m) {
		Hotel hotel = hs.viewHotel(hotelId);
		m.addAttribute("hotel" , hotel);
		return "bookHotelPage";
	}
	
}
