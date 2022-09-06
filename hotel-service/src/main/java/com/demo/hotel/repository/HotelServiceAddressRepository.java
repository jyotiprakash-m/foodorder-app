package com.demo.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hotel.entity.Address;

public interface HotelServiceAddressRepository extends JpaRepository<Address, Integer> {

}
