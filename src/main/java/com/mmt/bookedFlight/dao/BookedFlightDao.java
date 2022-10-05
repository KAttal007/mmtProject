package com.mmt.bookedFlight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.bookedFlight.model.BookedFlight;

public interface BookedFlightDao extends JpaRepository<BookedFlight, String>{

}
