package com.demo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.user.entity.Address;

public interface UserServiceAddress extends JpaRepository<Address, Integer> {

}
