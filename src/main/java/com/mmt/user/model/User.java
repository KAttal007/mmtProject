package com.mmt.user.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mmt.address.Address;
import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.bookedHotel.model.BookedHotel;
import com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "userdetails")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@GenericGenerator(name = "users_seq", strategy = "com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "User_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String userId;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String middleName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String mobileNumber;
	@NotEmpty
	@Email
	private String mailID;
	@NotEmpty
	private String password;
	@OneToOne(mappedBy = "userd")
	private Address address;
	@OneToMany(mappedBy = "user")
	private List<BookedHotel> hotelBooking = new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<BookedFlight> flightBooking = new ArrayList<>();
	//sample comment
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getMailID() {
		return mailID;
	}

	public void setMailID(String mailID) {
		this.mailID = mailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<BookedHotel> getHotel() {
		return hotelBooking;
	}

	public void setHotel(List<BookedHotel> hotel) {
		this.hotelBooking = hotel;
	}

	public List<BookedFlight> getFlight() {
		return flightBooking;
	}

	public void setFlight(List<BookedFlight> flight) {
		this.flightBooking = flight;
	}

	

	
	
}