package com.mmt.bookings.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.bookings.model.Bookings;

public interface BookingsDao extends JpaRepository<Bookings, String>{

}
