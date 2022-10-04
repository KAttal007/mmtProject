package com.mmt.user.passengers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "user_saved_passengers")
public class Passengers {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "savedpass_seq")
	@GenericGenerator(name = "savedpass_seq", strategy = "com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "pass_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String passengerId;
	private int passengerAge;
	private String passengerName;
	private String passengerMobileNo;
	private String passengerEmergencyContactName;
	private String passengerEmergencyContactNo;
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerMobileNo() {
		return passengerMobileNo;
	}
	public void setPassengerMobileNo(String passengerMobileNo) {
		this.passengerMobileNo = passengerMobileNo;
	}
	public String getPassengerEmergencyContactName() {
		return passengerEmergencyContactName;
	}
	public void setPassengerEmergencyContactName(String passengerEmergencyContactName) {
		this.passengerEmergencyContactName = passengerEmergencyContactName;
	}
	public String getPassengerEmergencyContactNo() {
		return passengerEmergencyContactNo;
	}
	public void setPassengerEmergencyContactNo(String passengerEmergencyContactNo) {
		this.passengerEmergencyContactNo = passengerEmergencyContactNo;
	}
	
	

}
