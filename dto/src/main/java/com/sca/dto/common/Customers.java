package com.sca.dto.common;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Customers {
	@JacksonXmlElementWrapper(localName = "customers")
	@JacksonXmlProperty(localName = "customer")
	@JsonProperty("customers")
	private List<TrackCustomerEngagementDto> customerList;

	/**
	 * @return the customerList
	 */
	public List<TrackCustomerEngagementDto> getCustomerList() {
		return customerList;
	}

	/**
	 * @param customerList the customerList to set
	 */
	public void setCustomerList(List<TrackCustomerEngagementDto> customerList) {
		this.customerList = customerList;
	}

	public void addCustomer(TrackCustomerEngagementDto trackCustomerEngagementDto) {

		if (customerList == null) {
			customerList = new ArrayList<TrackCustomerEngagementDto>();
		}

		customerList.add(trackCustomerEngagementDto);
	}

}
