package com.demo.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hotel.entity.Item;

public interface HotelServiceItemRepository extends JpaRepository<Item, Integer> {

}
