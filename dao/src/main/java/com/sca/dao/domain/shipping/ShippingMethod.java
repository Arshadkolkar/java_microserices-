/**
 * 
 */
package com.sca.dao.domain.shipping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipping_method")
public class ShippingMethod {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "shipping_method_id")
	private Integer shippingMethodId;

	@Column(name = "name")
	private String name;

	@Column(name = "display_name")
	private String displayName;

	/**
	 * @return the shippingMethodId
	 */
	public Integer getShippingMethodId() {
		return shippingMethodId;
	}

	/**
	 * @param shippingMethodId the shippingMethodId to set
	 */
	public void setShippingMethodId(Integer shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}