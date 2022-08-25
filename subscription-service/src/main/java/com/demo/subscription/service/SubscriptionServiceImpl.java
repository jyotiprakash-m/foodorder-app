package com.demo.subscription.service;

import java.util.List;
import java.util.Optional;

import com.demo.subscription.entity.Feature;
import com.demo.subscription.entity.Subscription;
import com.demo.subscription.util.Message;

public class SubscriptionServiceImpl implements SubscriptionService {

	@Override
	public Message addSubs(Subscription subs) {
		return null;
	}

	@Override
	public Message updateSubs(int id, Subscription subs) {
		return null;
	}

	@Override
	public Message deleteSubs(int id) {
		return null;
	}

	@Override
	public Optional<Subscription> findSubsById(int id) {
		return null;
	}

	@Override
	public List<Subscription> findAllSubs() {
		return null;
	}

	@Override
	public Optional<Subscription> findSubsByName(String name) {
		return null;
	}

	@Override
	public List<Subscription> findAllSubsByNameLike(String name) {
		return null;
	}

	@Override
	public List<Subscription> findAllSubsByDiscountRange(int startValue, int endValue) {
		return null;
	}

	@Override
	public List<Subscription> findAllSubsByPriceRange(double startValue, double endValue) {
		return null;
	}

	@Override
	public Message addFeatureToSubs(Feature feature) {
		return null;
	}

	@Override
	public Message updateFeatureOfSubs(int id, Feature feature) {
		return null;
	}
	@Override
	public Message deleteFeatureFromSubs(int id, Feature feature) {
		return null;
	}
	@Override
	public List<Feature> findAllFeature() {
		return null;
	}

	@Override
	public List<Feature> findAllFeatureOfSubs(int subsId) {
		return null;
	}



}
