package com.mmt.hotels.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mmt.address.Address;
import com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "hoteldetails")
public class Hotels {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	@GenericGenerator(name = "address_seq", strategy = "com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Address_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String hotelId;
	private String hotelName;
	private String hotelBrand;

	private List<Room> typesOfRooms;
	private float priceAccToRoom;

	private Address hotelAdd;

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

	public List<Room> getTypesOfRooms() {
		return typesOfRooms;
	}

	public void setTypesOfRooms(List<Room> typesOfRooms) {
		this.typesOfRooms = typesOfRooms;
	}

	public float getPriceAccToRoom() {
		return priceAccToRoom;
	}

	public void setPriceAccToRoom(float priceAccToRoom) {
		this.priceAccToRoom = priceAccToRoom;
	}

	public Address getHotelAdd() {
		return hotelAdd;
	}

	public void setHotelAdd(Address hotelAdd) {
		this.hotelAdd = hotelAdd;
	}

}
