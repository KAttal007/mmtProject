package com.mmt.admin.service;

import com.mmt.admin.model.Admin;
import com.mmt.flights.model.Flight;
import com.mmt.hotels.model.Hotel;

public interface AdminServiceInterface {
	public boolean login(Admin admin);
	public boolean logout();// to be implemented
	public boolean removeUser(String userId);
	public boolean addHotel(Hotel hotel);
	public boolean removeHotel(String hotelId);
	public boolean updateHoetl(Hotel hotel);
	public boolean addFlight(Flight flight);
	public boolean removeFlight(String flightId);
	public boolean updateFlight(Flight flight);
}
