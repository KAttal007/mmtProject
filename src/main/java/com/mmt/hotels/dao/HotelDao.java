package com.mmt.hotels.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.hotels.model.Hotel;

public interface HotelDao extends JpaRepository<Hotel, String> {
	List<Hotel> findByHotelCity(String city);
	List<Hotel> findByHotelCityAndisAcTrue(String city);
	List<Hotel> findByHotelCityAndisAcFalse(String city);
}
