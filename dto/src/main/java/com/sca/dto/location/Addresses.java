/**
 * 
 */
package com.sca.dto.location;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Addresses {

	@JacksonXmlElementWrapper(localName = "addresses")
	@JacksonXmlProperty(localName = "address")
	@JsonProperty("addresses")
	private List<AddressDto> addressList;

	public void setAddressList(List<AddressDto> addressList) {
		this.addressList = addressList;
	}

	public void addAddress(AddressDto address) {

		if (addressList == null) {
			addressList = new ArrayList<AddressDto>();
		}

		addressList.add(address);
	}
}