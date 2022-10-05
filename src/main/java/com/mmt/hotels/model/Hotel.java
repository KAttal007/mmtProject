package com.mmt.hotels.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "hoteldetails")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	@GenericGenerator(name = "address_seq", strategy = "com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Address_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String hotelId;
	private String hotelName;
	private String hotelBrand;
	private float priceAcRoom;
	private float priceNonAcRoom;
	private String hotelCity;
	private int noOfAcRooms;
	private int noOfNonAcRooms;
	private int noOfAvilableAcRoom;
	private int noOfAvilableNonAcRoom;

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelBrand() {
		return hotelBrand;
	}

	public void setHotelBrand(String hotelBrand) {
		this.hotelBrand = hotelBrand;
	}

	public int getNoOfAvilableAcRoom() {
		return noOfAvilableAcRoom;
	}

	public void setNoOfAvilableAcRoom(int noOfAvilableAcRoom) {
		this.noOfAvilableAcRoom = noOfAvilableAcRoom;
	}

	public int getNoOfAvilableNonAcRoom() {
		return noOfAvilableNonAcRoom;
	}

	public void setNoOfAvilableNonAcRoom(int noOfAvilableNonAcRoom) {
		this.noOfAvilableNonAcRoom = noOfAvilableNonAcRoom;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public float getPriceAcRoom() {
		return priceAcRoom;
	}

	public void setPriceAcRoom(float priceAcRoom) {
		this.priceAcRoom = priceAcRoom;
	}

	public float getPriceNonAcRoom() {
		return priceNonAcRoom;
	}

	public void setPriceNonAcRoom(float priceNonAcRoom) {
		this.priceNonAcRoom = priceNonAcRoom;
	}

	public int getNoOfAcRooms() {
		return noOfAcRooms;
	}

	public void setNoOfAcRooms(int noOfAcRooms) {
		this.noOfAcRooms = noOfAcRooms;
	}

	public int getNoOfNonAcRooms() {
		return noOfNonAcRooms;
	}

	public void setNoOfNonAcRooms(int noOfNonAcRooms) {
		this.noOfNonAcRooms = noOfNonAcRooms;
	}

}
