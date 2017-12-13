package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Bookings;

public interface BookingRespository extends JpaRepository<Bookings, Integer> {

}
