package com.mmt.hotels.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mmt.hotels.model.Hotel;

public interface HotelDao extends JpaRepository<Hotel, String> {
	List<Hotel> findByHotelCity(String city);
	//@Query("from Hotel")
	List<Hotel> findByHotelCityAndIsAcTrue(String city);
	List<Hotel> findByHotelCityAndIsAcFalse(String city);
}
