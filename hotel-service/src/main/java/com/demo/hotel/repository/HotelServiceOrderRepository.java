package com.demo.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hotel.entity.Order;

public interface HotelServiceOrderRepository extends JpaRepository<Order, Integer> {

}
