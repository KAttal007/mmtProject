package com.mmt.bookings.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.bookings.model.BookedFlight;

public interface BookingsDao extends JpaRepository<BookedFlight, String>{

}
