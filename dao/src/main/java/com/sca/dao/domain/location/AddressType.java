/**
 * 
 */
package com.sca.dao.domain.location;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sca.dao.domain.payment.CreditCard;

@Entity
@Table(name = "address_type")
public class AddressType {

	@Id
	@Column(name = "address_type_id")
	private Long addressTypeId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "addressType", cascade = CascadeType.ALL)
	private List<Address> address;
	
	

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	/**
	 * @return the addressTypeId
	 */
	public Long getAddressTypeId() {
		return addressTypeId;
	}

	/**
	 * @param addressTypeId the addressTypeId to set
	 */
	public void setAddressTypeId(Long addressTypeId) {
		this.addressTypeId = addressTypeId;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}