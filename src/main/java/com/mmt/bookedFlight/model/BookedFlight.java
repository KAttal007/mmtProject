package com.mmt.bookedFlight.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mmt.flights.model.Flight;
import com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator;
import com.mmt.user.model.User;

@Entity
@Table(name = "bookedflights")
public class BookedFlight {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookedflight_seq")
	@GenericGenerator(name = "bookedflight_seq", strategy = "com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "BFID_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String bookedFlightId;
	private int noOfSeats;
	private int price;
	@OneToOne
	private Flight flight;
	@ManyToOne
	private User user;
	public String getBookedFlightId() {
		return bookedFlightId;
	}
	public void setBookedFlightId(String bookedFlightId) {
		this.bookedFlightId = bookedFlightId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	/*
	 * public List<Passengers> getPassengers() { return passengers; } public void
	 * setPassengers(List<Passengers> passengers) { this.passengers = passengers; }
	 */
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}