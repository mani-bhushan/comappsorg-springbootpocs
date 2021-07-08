package com.apps.org.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address", uniqueConstraints = @UniqueConstraint(columnNames = {"address_id"}) )
public class Address extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4926468583005150702L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="GSN_SEQ")
	@Column(name = "address_id", unique=true, nullable = false)
	private Long addressId;
	
	@NotNull
	@Column(name = "address_line")
	private String addressLine;
	
	@Column(name = "house_number")
	private String houseNumber;
	
	@Column(name = "street_name")
	private String streetName;
	
	@Column(name = "lat")
	private String lat;
	
	@Column(name = "lon")
	private String lon;
	
	@Column(name = "mobile")
	private Long mobile;
	
	@ManyToOne 	//Many address can be associated with One employee
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="country_code", nullable=false)
	private Country country;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="state_id", nullable=false)
	private State state;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="city_id", nullable=false)
	private City city;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

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

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressId, addressLine, city, country, employee, houseNumber, lat, lon, mobile, state, streetName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressId, other.addressId) && Objects.equals(addressLine, other.addressLine)
				&& Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(employee, other.employee) && Objects.equals(houseNumber, other.houseNumber)
				&& Objects.equals(lat, other.lat) && Objects.equals(lon, other.lon)
				&& Objects.equals(mobile, other.mobile) && Objects.equals(state, other.state)
				&& Objects.equals(streetName, other.streetName);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("Address { ")
				.append("addressId=").append(addressId).append(", addressLine=").append(addressLine)
				.append(", houseNumber=").append(houseNumber).append(", streetName=").append(streetName)
				.append(", lat=").append(lat).append(", lon=").append(lon).append(", mobile=").append(mobile)
				.append(", employee=").append(employee).append(", country=").append(country).append(", state=")
				.append(state).append(", city=").append(city).append(" }");
		return buffer.toString();
	}

}
