package com.demo.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.subscription.entity.Feature;
@Repository
public interface SubscriptionServiceFeatureRepository extends JpaRepository<Feature, Integer> {

}
