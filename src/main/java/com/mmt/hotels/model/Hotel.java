package com.mmt.hotels.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mmt.bookedHotel.model.BookedHotel;
import com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "hoteldetails")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotels_seq")
	@GenericGenerator(name = "hotels_seq", strategy = "com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "HotelID_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String hotelId;
	@NotEmpty(message = "Hotel Name should not be empty")
	private String hotelName;
	@NotEmpty(message = "Hotel Brand should not be empty")
	private String hotelBrand;
	@NotEmpty(message = "Price Of AC rooms should not be empty")
	@Size(min = 2000, max = 200000)
	private float priceAcRoom;
	@NotEmpty(message = "Price Of NON-AC rooms should not be empty")
	@Size(min = 1000, max = 2500)
	private float priceNonAcRoom;
	@NotEmpty(message = "Hotel City should not be empty")
	private String hotelCity;
	@NotEmpty(message = "No. Of AC rooms should not be empty")
	private int noOfAcRooms;
	@NotEmpty(message = "No. Of NON-AC rooms should not be empty")
	private int noOfNonAcRooms;
	@NotEmpty(message = "No. Of Avl AC rooms should not be empty")
	private int noOfAvilableAcRoom;
	@NotEmpty(message = "No. Of Avl NON-AC rooms should not be empty")
	private int noOfAvilableNonAcRoom;
	@NotEmpty(message = "Confirm whether hotel is AC or not")
	private Boolean isAc;
	
	@OneToOne(mappedBy="hotel")
	private BookedHotel bookedhotel;

	public Boolean getIsAc() {
		return isAc;
	}

	public void setIsAc(Boolean isAc) {
		this.isAc = isAc;
	}

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
