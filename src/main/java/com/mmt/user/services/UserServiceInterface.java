package com.mmt.user.services;

import java.util.List;

import com.mmt.address.Address;
import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.bookedHotel.model.BookedHotel;


import com.mmt.user.model.User;

public interface UserServiceInterface{
	public List<User> allUsers();
	public boolean createuser(User user);
	public boolean userLogin(User user);
	public boolean userLogout();
	public boolean deleteUser(String userId);
	public boolean updateUser(User user);
	public List<User> userByNoOfBookings();
	public User viewUser(String userId);
	public BookedFlight viewLastFlightBooking(String bookingId);
	public BookedHotel viewLastHotelBooking(String bookingId);
	public boolean updateBookingFlight(BookedFlight booking);
	public List<BookedHotel> allBookedHotels(String userId);
	public List<BookedFlight> allBookedFlight(String userId);
	public boolean updateUserAddress(Address address,String userId);
}
