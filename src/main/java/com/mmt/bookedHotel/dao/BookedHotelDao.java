package com.mmt.bookedHotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.bookedHotel.model.BookedHotel;

public interface BookedHotelDao extends JpaRepository<BookedHotel, String> {

}
