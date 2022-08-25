package com.demo.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.subscription.entity.Subscription;
@Repository
public interface SubscriptionServiceSubscriptionRepository extends JpaRepository<Subscription, Integer> {

}
