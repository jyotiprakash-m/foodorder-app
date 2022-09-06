package com.demo.subscription.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.subscription.dto.FeatureDTO;
import com.demo.subscription.dto.SubscriptionDTO;
import com.demo.subscription.entity.Feature;
import com.demo.subscription.entity.Subscription;
import com.demo.subscription.service.SubscriptionServiceImpl;
import com.demo.subscription.util.Message;

@RestController
@RequestMapping("/subs")
public class SubscriptionServiceRestController {

	@Autowired
	SubscriptionServiceImpl subsImpl;

	Message message = new Message();
	Logger logger = LoggerFactory.getLogger(SubscriptionServiceRestController.class);

//	Add Subscription
	@PostMapping("/save")
	public ResponseEntity<Message> addSubscription(@RequestBody SubscriptionDTO subsDto) {

		Subscription newSubs = new Subscription(subsDto.getSubscriptionName(), subsDto.getDiscount(),
				subsDto.getPrice());
		return new ResponseEntity<>(subsImpl.addSubs(newSubs), HttpStatus.OK);
	}

//	Update Subscription
	@PutMapping("/update/{id}")
	public ResponseEntity<Message> updateSubscription(@PathVariable("id") int id,
			@RequestBody SubscriptionDTO subsDto) {
		List<Feature> features = new ArrayList<>();
		subsDto.getFeatures().stream().forEach(f -> {
			Feature feature = new Feature(f.getFeatureName(), f.getFeatureDescription());
			features.add(feature);
		});

		Subscription newSubs = new Subscription(subsDto.getSubscriptionId(), subsDto.getSubscriptionName(),
				subsDto.getDiscount(), subsDto.getPrice(), features);
		return new ResponseEntity<>(subsImpl.updateSubs(id, newSubs), HttpStatus.OK);
	}

//	Delete Subscription
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Message> deleteSubscription(@PathVariable("id") int id) {
		Optional<Subscription> subsOptional = subsImpl.findSubsById(id);
		if (subsOptional.isEmpty()) {
			return new ResponseEntity<Message>(subsImpl.deleteSubs(id), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Message>(subsImpl.deleteSubs(id), HttpStatus.OK);
		}
	}

//	Get by id
	@GetMapping("/get/{id}")
	public ResponseEntity<Subscription> findSubscriptionById(@PathVariable int id) {
		Optional<Subscription> subsOptional = subsImpl.findSubsById(id);
		if (subsOptional.isEmpty()) {
			logger.error("No data found with id: {}", id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(subsOptional.get(), HttpStatus.OK);
		}
	}

//	Get all
	@GetMapping("/get")
	public ResponseEntity<List<Subscription>> getAllSubscriptions() {
		return new ResponseEntity<>(subsImpl.findAllSubs(), HttpStatus.OK);
	}

//	Get by name
//	findBySubscriptionName
	@GetMapping("/findBySubscriptionName")
	public ResponseEntity<Subscription> getSubscriptionByName(@RequestParam("name") String name) {
		Optional<Subscription> subsOptional = subsImpl.findSubsByName(name);
		if (subsOptional.isEmpty()) {
			logger.error("No data found with name: {}", name);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(subsOptional.get(), HttpStatus.OK);
		}
	}

//	Get by name like
	@GetMapping("/searchBySubscriptionNameLike")
	public ResponseEntity<List<Subscription>> getAllSubscriptionsNameLike(@RequestParam("name") String name) {
		return new ResponseEntity<>(subsImpl.findAllSubsByNameLike(name), HttpStatus.OK);
	}

//	Get by discount range
	@GetMapping("/findAllByDiscountBetween")
	public ResponseEntity<List<Subscription>> getAllSubscriptionsDiscountRange(
			@RequestParam("startValue") int startValue, @RequestParam("endValue") int endValue) {
		return new ResponseEntity<>(subsImpl.findAllSubsByDiscountRange(startValue, endValue), HttpStatus.OK);
	}

//	Get by price range
	@GetMapping("/findAllByPriceBetween")
	public ResponseEntity<List<Subscription>> getAllSubscriptionsPriceRange(
			@RequestParam("startValue") double startValue, @RequestParam("endValue") double endValue) {
		return new ResponseEntity<>(subsImpl.findAllSubsByPriceRange(startValue, endValue), HttpStatus.OK);
	}
//	Get by discount as well as price range

//	Add feature
	@PostMapping("/update/{subsId}/addFeature")
	public ResponseEntity<Message> addFeatuerToSubscription(@PathVariable("subsId") int subsId,
			@RequestBody FeatureDTO featureDto) {
		Feature newFeature = new Feature(featureDto.getFeatureName(), featureDto.getFeatureDescription());
		return new ResponseEntity<>(subsImpl.addFeatureToSubs(subsId, newFeature), HttpStatus.OK);
	}

//	Update feature
	@PutMapping("/update/{subsId}/updateFeature/{featureId}")
	public ResponseEntity<Message> updateFeatuerOfSubscription(@PathVariable("subsId") int subsId,
			@PathVariable("featureId") int featureId, @RequestBody FeatureDTO featureDto) {
		Feature newFeature = new Feature(featureDto.getFeatureName(), featureDto.getFeatureDescription());
		return new ResponseEntity<>(subsImpl.updateFeatureOfSubs(subsId, featureId, newFeature), HttpStatus.OK);
	}

//	Delete feature
	@DeleteMapping("/update/{subsId}/deleteFeature/{featureId}")
	public ResponseEntity<Message> deleteFeatuerFromSubscription(@PathVariable("subsId") int subsId,
			@PathVariable("featureId") int featureId) {
		return new ResponseEntity<>(subsImpl.deleteFeatureFromSubs(featureId), HttpStatus.OK);
	}

//	Get all features of one Subscription
	@GetMapping("/get/{id}/findFeatures")
	public ResponseEntity<List<Feature>> getAllFeaturesOfSubs(@PathVariable("id") int id) {
		return new ResponseEntity<>(subsImpl.findAllFeatureOfSubs(id), HttpStatus.OK);
	}

//	Get all the feature
	@GetMapping("/findFeatures")
	public ResponseEntity<List<Feature>> getAllFeatures() {
		return new ResponseEntity<>(subsImpl.findAllFeature(), HttpStatus.OK);
	}

}
