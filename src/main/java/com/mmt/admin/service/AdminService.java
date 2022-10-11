package com.mmt.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.admin.dao.AdminDao;
import com.mmt.admin.model.Admin;
import com.mmt.flights.dao.FlightDao;
import com.mmt.flights.model.Flight;
import com.mmt.hotels.dao.HotelDao;
import com.mmt.hotels.model.Hotel;
import com.mmt.user.dao.UserDao;

@Service

public class AdminService implements AdminServiceInterface {
	@Autowired
	private AdminDao ad;

	@Autowired
	private UserDao ud;

	@Autowired
	private HotelDao hd;

	@Autowired
	private FlightDao fd;

	@Override
	public boolean login(Admin admin) {

		Admin existAdmin = ad.findById(admin.getAdminId()).get();
		if (existAdmin == null)
			return false;
		else {
			if (existAdmin.getAdminPassword().equals(admin.getAdminPassword()))
				return true;
		}
		return false;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeUser(String userId) {

		if (ud.findById(userId) == null)
			return false;
		ud.deleteById(userId);
		return true;
	}

	@Override
	public boolean addHotel(Hotel hotel) {
		if (hotel.getNoOfAcRooms() > 0)
			hotel.setIsAc(true);
		else
			hotel.setIsAc(false);
		hotel.setNoOfAvilableAcRoom(hotel.getNoOfAcRooms());
		hotel.setNoOfAvilableNonAcRoom(hotel.getNoOfNonAcRooms());
		hd.save(hotel);
		return true;
	}

	@Override
	public boolean removeHotel(String hotelId) {

		if (hd.findById(hotelId) != null) {
			hd.deleteById(hotelId);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateHotel(Hotel hotel) {
		Hotel existHotel = hd.findById(hotel.getHotelId()).get();
		if (existHotel == null)
			return false;
		if (hotel.getHotelBrand().isBlank())
			hotel.setHotelBrand(existHotel.getHotelBrand());
		if (hotel.getHotelCity().isBlank())
			hotel.setHotelCity(existHotel.getHotelCity());
		if (hotel.getHotelName().isBlank())
			hotel.setHotelName(existHotel.getHotelName());
		if (hotel.getNoOfAcRooms() == 0)
			hotel.setNoOfAcRooms(existHotel.getNoOfAcRooms());
		if (hotel.getNoOfNonAcRooms() == 0)
			hotel.setNoOfNonAcRooms(existHotel.getNoOfNonAcRooms());
		if (hotel.getPriceAcRoom() != existHotel.getPriceAcRoom())
			hotel.setPriceAcRoom(existHotel.getPriceAcRoom());
		if (hotel.getPriceNonAcRoom() != existHotel.getPriceAcRoom())
			hotel.setPriceNonAcRoom(existHotel.getPriceNonAcRoom());
		if (hotel.getNoOfAcRooms() > 0)
			hotel.setIsAc(true);
		if (hotel.getNoOfAcRooms() <= 0)
			hotel.setIsAc(false);
		hotel.setNoOfAvilableAcRoom(hotel.getNoOfAcRooms());
		hotel.setNoOfAvilableNonAcRoom(hotel.getNoOfNonAcRooms());
		hd.save(hotel);
		return true;
	}

	@Override
	public boolean addFlight(Flight flight) {
		flight.setNoOfAvilableSeats(flight.getNoOfSeats());
		fd.save(flight);
		return true;
	}

	@Override
	public boolean removeFlight(String flightId) {
		if (fd.findById(flightId) != null) {
			fd.deleteById(flightId);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateFlight(Flight flight) {
		if (fd.findById(flight.getFlightId()) == null) {
			return false;
		}

		return true;

	}

	@Override
	public boolean createadmin(Admin admin) {
		ad.save(admin);
		return false;
	}
}
