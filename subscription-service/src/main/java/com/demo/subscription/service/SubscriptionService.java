package com.demo.subscription.service;

import java.util.List;
import java.util.Optional;

import com.demo.subscription.entity.Feature;
import com.demo.subscription.entity.Subscription;
import com.demo.subscription.util.Message;

public interface SubscriptionService {
//	Add Subscription
	Message addSubs(Subscription subs);
//	Update Subscription
	Message updateSubs(int id,Subscription subs);
//	Delete Subscription
	Message deleteSubs(int id);
//	Get by id
	Optional<Subscription> findSubsById(int id);
//	Get all
	List<Subscription> findAllSubs();
//	Get by name
	Optional<Subscription> findSubsByName(String name);
//	Get by name like
	List<Subscription> findAllSubsByNameLike(String name);
//	Get by discount range
	List<Subscription> findAllSubsByDiscountRange(int startValue,int endValue);
//	Get by price range
	List<Subscription> findAllSubsByPriceRange(double startValue,double endValue);
//	Get by discount as well as price range
	
//	Add feature
	Message addFeatureToSubs(int subsId,Feature feature);
//	Update feature
	Message updateFeatureOfSubs(int subsId,int featureId,Feature feature);
//	Delete feature
	Message deleteFeatureFromSubs(int featureId);
//	Get all features of one Subscription
	List<Feature> findAllFeature();
//	Get all the feature
	List<Feature> findAllFeatureOfSubs(int subsId);
	
}
