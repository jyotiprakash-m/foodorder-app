package com.demo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.user.entity.Order;

public interface OrderServiceRepository extends JpaRepository<Order, Integer> {

}
