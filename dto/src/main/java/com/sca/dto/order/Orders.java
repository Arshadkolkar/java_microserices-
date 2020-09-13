/**
 * 
 */
package com.sca.dto.order;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Orders {

	@JacksonXmlElementWrapper(localName = "orders")
	@JacksonXmlProperty(localName = "order")
	@JsonProperty("orders")
	private List<OrderDto> orderList;

	/**
	 * 
	 * @param orderList
	 */
	public void setOrderList(List<OrderDto> orderList) {
		this.orderList = orderList;
	}

	/**
	 * 
	 * @param order
	 */
	public void addOrder(OrderDto order) {

		if (orderList == null) {
			orderList = new ArrayList<OrderDto>();
		}

		orderList.add(order);
	}

}
