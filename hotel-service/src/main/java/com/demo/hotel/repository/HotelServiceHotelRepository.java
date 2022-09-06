package com.demo.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hotel.entity.Hotel;

public interface HotelServiceHotelRepository extends JpaRepository<Hotel, Integer> {

}
