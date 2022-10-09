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

import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.bookedHotel.model.BookedHotel;
import com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

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
	@NotEmpty(message = "First Name is mandatory")
	private String firstName;
	@NotEmpty(message = "Middle Name is mandatory")
	private String middleName;
	@NotEmpty(message = "Last Name is mandatory")
	private String lastName;
	@Pattern(regexp="/((\\\\+)((0[ -]*)*|((91 )*))((\\\\d{12})+|(\\\\d{10})+))|\\\\d{5}([- ]*)\\\\d{6}/gm")
	@NotEmpty(message = "Phone Number is Mandatory")
	private String mobileNumber;
	@Email(message = "Email is mandatory, and please enter a correctly formatted email.")
	@NotEmpty
	private String emailId;
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
	@NotEmpty(message = "Password must contain Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character")
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<BookedHotel> hotelBooking = new ArrayList<>();
	@OneToMany(mappedBy = "user")
	private List<BookedFlight> flightBooking = new ArrayList<>();
	
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

	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public List<BookedHotel> getHotelBooking() {
		return hotelBooking;
	}

	public void setHotelBooking(List<BookedHotel> hotelBooking) {
		this.hotelBooking = hotelBooking;
	}

	public List<BookedFlight> getFlightBooking() {
		return flightBooking;
	}

	public void setFlightBooking(List<BookedFlight> flightBooking) {
		this.flightBooking = flightBooking;
	}
	
	
}