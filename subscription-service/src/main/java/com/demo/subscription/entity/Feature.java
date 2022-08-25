package com.demo.subscription.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "features")
public class Feature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int featureId;
	@NotEmpty(message = "Coupon name is required")
	@Column(name = "name")
	private String featureName;
	private String featureDescription;

	public int getFeatureId() {
		return featureId;
	}

	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getFeatureDescription() {
		return featureDescription;
	}

	public void setFeatureDescription(String featureDescription) {
		this.featureDescription = featureDescription;
	}

	public Feature() {
	}

	public Feature(String featureName, String featureDescription) {
		this.featureName = featureName;
		this.featureDescription = featureDescription;
	}

	public Feature(int featureId, String featureName, String featureDescription) {
		this.featureId = featureId;
		this.featureName = featureName;
		this.featureDescription = featureDescription;
	}

}
