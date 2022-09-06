package com.demo.subscription.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.subscription.entity.Feature;
import com.demo.subscription.entity.Subscription;
import com.demo.subscription.repository.SubscriptionServiceFeatureRepository;
import com.demo.subscription.repository.SubscriptionServiceSubscriptionRepository;
import com.demo.subscription.util.Message;
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionServiceSubscriptionRepository subsRepo;
	@Autowired
	SubscriptionServiceFeatureRepository featureRepo;

	Message message = new Message();
	Logger logger = LoggerFactory.getLogger(SubscriptionServiceImpl.class);

	@Override
	public Message addSubs(@Valid Subscription subs) {
		subsRepo.save(subs);
		logger.info("Subscription is saved");
		message.setStatus("Subscription is saved");
		return message;
	}

	@Override
	public Message updateSubs(int id, Subscription subs) {
		if (subsRepo.findById(id).isEmpty()) {
			logger.error("No data found with id: {}", id);
			message.setStatus("Not found");
			return message;
		} else {
			subsRepo.save(subs);
			logger.error("Subscription is updated");
			message.setStatus("Subscription is updated");
			return message;
		}
	}

	@Override
	public Message deleteSubs(int id) {
		if (subsRepo.findById(id).isEmpty()) {
			logger.error("No data found with id: {}", id);
			message.setStatus("Not found");
			return message;
		} else {
			subsRepo.deleteById(id);
			logger.error("Subscription is deleted");
			message.setStatus("Subscription is deleted");
			return message;
		}
	}

	@Override
	public Optional<Subscription> findSubsById(int id) {
		return subsRepo.findById(id);
	}

	@Override
	public List<Subscription> findAllSubs() {
		return subsRepo.findAll();
	}

	@Override
	public Optional<Subscription> findSubsByName(String name) {
		return subsRepo.findBySubscriptionName(name);
	}

	@Override
	public List<Subscription> findAllSubsByNameLike(String name) {
		return subsRepo.searchBySubscriptionNameLike(name);
	}

	@Override
	public List<Subscription> findAllSubsByDiscountRange(int startValue, int endValue) {
		return subsRepo.findAllByDiscountBetween(startValue, endValue);
	}

	@Override
	public List<Subscription> findAllSubsByPriceRange(double startValue, double endValue) {
		return subsRepo.findAllByPriceBetween(startValue, endValue);
	}

	@Override
	public Message addFeatureToSubs(int subsId, Feature feature) {
		Optional<Subscription> subscriptionOp = subsRepo.findById(subsId);
		if (subscriptionOp.isEmpty()) {
			logger.error("No data found with id: {}", subsId);
			message.setStatus("Not found");
			return message;
		} else {
			subscriptionOp.get().getFeatures().add(feature);
			subsRepo.save(subscriptionOp.get());
			logger.info("Doctor is added to specialty {}", subscriptionOp.get().getSubscriptionName());
			message.setStatus("Doctor is added to specialty " + subscriptionOp.get().getSubscriptionName());
			return message;
		}
	}

	@Override
	public Message updateFeatureOfSubs(int subsId,int featureId, Feature feature) {
		if (featureRepo.findById(featureId).isEmpty()) {
			logger.error("No data found with id: {}", featureId);
			message.setStatus("Not found");
			return message;
		} else {
			featureRepo.save(feature);
			logger.error("Subscription is updated");
			message.setStatus("Subscription is updated");
			return message;
		}
	}

	@Override
	public Message deleteFeatureFromSubs(int id) {
		if (featureRepo.findById(id).isEmpty()) {
			logger.error("No data found with id: {}", id);
			message.setStatus("Not found");
			return message;
		} else {
			featureRepo.deleteById(id);
			logger.error("Feature is deleted");
			message.setStatus("Feature is deleted");
			return message;
		}
	}

	@Override
	public List<Feature> findAllFeature() {
		return featureRepo.findAll();
	}

	@Override
	public List<Feature> findAllFeatureOfSubs(int subsId) {
		Optional<Subscription> subscriptionOp = subsRepo.findById(subsId);
		if (subscriptionOp.isEmpty()) {
			logger.error("No data found with id: {}", subsId);
			return null;
		} else {

			return subscriptionOp.get().getFeatures();
		}
	}

}
