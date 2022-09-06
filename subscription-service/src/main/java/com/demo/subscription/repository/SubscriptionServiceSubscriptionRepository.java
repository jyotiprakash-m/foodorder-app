package com.demo.subscription.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.subscription.entity.Subscription;
@Repository
public interface SubscriptionServiceSubscriptionRepository extends JpaRepository<Subscription, Integer> {

	public Optional<Subscription> findBySubscriptionName(String name);
	@Query("SELECT s FROM Subscription s WHERE s.subscriptionName LIKE %:name%")
	public List<Subscription> searchBySubscriptionNameLike(@Param("name") String name);
	public List<Subscription> findAllByDiscountBetween(int startValue, int endValue);
	public List<Subscription> findAllByPriceBetween(double startValue, double endValue);
}
