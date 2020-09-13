package com.sca.dao.domain.shipping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipping_rate")
public class ShippingRate {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "shipping_rate_id")
	private Integer shippingRateId;

	@Column(name = "country_id")
	private Integer countryId;

	@Column(name = "state_id")
	private Integer stateId;
	
	@Column(name = "shipping_method_id")
	private Integer shippingMethodId;
	
	public Integer getShippingRateId() {
		return shippingRateId;
	}

	public void setShippingRateId(Integer shippingRateId) {
		this.shippingRateId = shippingRateId;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getShippingMethodId() {
		return shippingMethodId;
	}

	public void setShippingMethodId(Integer shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	public long getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(long shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	@Column(name = "shipping_price")
	private long shippingPrice;
	
	
	

}
