package com.mmt.flights.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "flightdetails")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flights_seq")
	@GenericGenerator(name = "flights_seq", strategy = "com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Flight_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String flightId;
	@NotBlank(message = "Airline Name must not be empty!")
	private String airlineName;
	@NotBlank(message = "Airline Number must not be empty!")
	private String flightNumber;
	@NotBlank(message = "Airline Duration (Time) must not be empty!")
	private String flightDuration;
	@NotBlank(message = "Airline Departure (Time) must not be empty!")
	private String flightDeparture; // time
	@NotBlank(message = "Airline Arrival (Time) must not be empty!")
	private String flightArrival; // time
	@NotBlank(message = "Airline Source (City) must not be empty!")
	private String flightSource;
	@NotBlank(message = "Airline Destination (City) must not be empty!")
	private String flightDestination;
	@NotBlank(message = "Price Per Seat must not be empty")
	private int pricePerSeat;
	@NotBlank(message = "No. Of Available Seats must not be empty")
	@Size(max = 180, message = "Number of seats should not be more than 180")
	private int noOfAvilableSeats;
	@NotBlank(message = "No. Of Seats must not be empty")
	@Size(max = 180, message = "Number of seats should not be more than 180")
	private int noOfSeats;

	@OneToOne(mappedBy = "flight")
	private BookedFlight bookedflights;

	public BookedFlight getBookedflights() {
		return bookedflights;
	}

	public void setBookedflights(BookedFlight bookedflights) {
		this.bookedflights = bookedflights;
	}

	public int getPricePerSeat() {
		return pricePerSeat;
	}

	public void setPricePerSeat(int pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}

	public int getNoOfAvilableSeats() {
		return noOfAvilableSeats;
	}

	public void setNoOfAvilableSeats(int noOfAvilableSeats) {
		this.noOfAvilableSeats = noOfAvilableSeats;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}


	public String getFlightSource() {
		return flightSource;
	}

	public void setFlightSource(String flightSource) {
		this.flightSource = flightSource;
	}

	public String getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}

	public String getFlightDeparture() {
		return flightDeparture;
	}

	public void setFlightDeparture(String flightDeparture) {
		this.flightDeparture = flightDeparture;
	}

	public String getFlightArrival() {
		return flightArrival;
	}

	public void setFlightArrival(String flightArrival) {
		this.flightArrival = flightArrival;
	}

}
