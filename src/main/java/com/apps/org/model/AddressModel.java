package com.apps.org.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("address")
public class AddressModel {

	@JsonProperty("addressLine")
	private String addressLine;
	
	@JsonProperty("houseNumber")
	private String houseNumber;
	
	@JsonProperty("streetName")
	private String streetName;
	
	@JsonProperty("lat")
	private String lat;
	
	@JsonProperty("lon")
	private String lon;
	
	@JsonProperty("countryCode")
	private Integer countryCode;
	
	@JsonProperty("mobile")
	private Long mobile;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("zipCode")
	private Integer zipCode;
	
	@JsonProperty("isPrimary")
	private String isPrimary;
	
	@JsonProperty("stdCode")
	private Integer stdCode;
	
	@JsonProperty("telephone")
	private Long telephone;
	

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Integer getStdCode() {
		return stdCode;
	}

	public void setStdCode(Integer stdCode) {
		this.stdCode = stdCode;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressLine, city, country, countryCode, houseNumber, lat, lon, mobile, state, streetName, zipCode, isPrimary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AddressModel))
			return false;
		AddressModel other = (AddressModel) obj;
		return Objects.equals(addressLine, other.addressLine) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && Objects.equals(countryCode, other.countryCode)
				&& Objects.equals(houseNumber, other.houseNumber) && Objects.equals(lat, other.lat)
				&& Objects.equals(lon, other.lon) && Objects.equals(mobile, other.mobile)
				&& Objects.equals(state, other.state) && Objects.equals(streetName, other.streetName)
				&& Objects.equals(zipCode, other.zipCode) && Objects.equals(isPrimary, other.isPrimary)
				&& Objects.equals(stdCode, other.stdCode) && Objects.equals(telephone, other.telephone);
	}

	@Override
	public String toString() {
		StringBuffer builder = new StringBuffer("Address { ")
				.append("addressLine=").append(addressLine).append(", houseNumber=").append(houseNumber)
				.append(", streetName=").append(streetName).append(", lat=").append(lat)
				.append(", lon=").append(lon).append(", countryCode=").append(countryCode)
				.append(", mobile=").append(mobile).append(", country=").append(country)
				.append(", state=").append(state).append(", city=").append(city)
				.append(", zipCode=").append(zipCode).append(", isPrimary=").append(isPrimary)
				.append(" }");
		return builder.toString();
	}
		
}
