package com.apps.org.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("address")
@JsonInclude(Include.NON_NULL)
public class AddressModel {
	
	@JsonProperty("countryCode") private String countryCode;
	@JsonProperty("country") private String country;
	
	@JsonProperty("state") private String state;
	@JsonProperty("stateId") private Long stateId;
	@JsonProperty("isSpecialState") private String isSpecialState;
	
	@JsonProperty("cityId") private Long cityId;
	@JsonProperty("city") private String city;
	@JsonProperty("isCapital") private String isCapital;
	@JsonProperty("zipCode") private String zipCode;
	@JsonProperty("stdCode") private String stdCode;
	@JsonProperty("subDivisionCode") private Long subDivisionCode;

	public AddressModel() { }

	public AddressModel(boolean isresponseModel) {
		this.isresponseModel = isresponseModel;
	}
	@JsonIgnore private boolean isresponseModel;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getIsSpecial() {
		return isSpecialState;
	}

	public void setIsSpecial(String isSpecial) {
		this.isSpecialState = isSpecial;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIsCapital() {
		return isCapital;
	}

	public void setIsCapital(String isCapital) {
		this.isCapital = isCapital;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStdCode() {
		return stdCode;
	}

	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}

	public Long getSubDivisionCode() {
		return subDivisionCode;
	}

	public void setSubDivisionCode(Long subDivisionCode) {
		this.subDivisionCode = subDivisionCode;
	}

	public boolean isIsresponseModel() {
		return isresponseModel;
	}

	public void setIsresponseModel(boolean isresponseModel) {
		this.isresponseModel = isresponseModel;
	}

}
