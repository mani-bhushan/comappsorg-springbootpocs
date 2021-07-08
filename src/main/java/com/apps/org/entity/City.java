package com.apps.org.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "city", uniqueConstraints = @UniqueConstraint(columnNames = {"city_id"}) )
public class City extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4926468583005150705L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="GSN_SEQ")
	@Column(name = "city_id", unique=true, nullable = false)
	private Long cityId;
	
	@NotNull
	@Column(name = "city_name", nullable=false)
	private String cityName;
	
	@NotNull
	@Column(name = "zip_code", unique=true, nullable=false)
	private Integer zipCode;
	
	@ManyToOne	// Many cities can be associated with One State.
	@JoinColumn(name="state_id")
	private State state;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityId, cityName, state, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof City))
			return false;
		City other = (City) obj;
		return Objects.equals(cityId, other.cityId) && Objects.equals(cityName, other.cityName)
				&& Objects.equals(state, other.state) && Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		StringBuffer builder = new StringBuffer("City { ");
		builder.append("cityId=").append(cityId).append(", cityName=").append(cityName).append(", zipCode=")
				.append(zipCode).append(", state=").append(state).append(" }");
		return builder.toString();
	}
	
	
}
