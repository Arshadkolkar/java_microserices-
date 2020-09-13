/**
 * 
 */
package com.sca.dto.notification;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 
 * @author 
 *
 */
public class OrderNotifications {
	
	@JacksonXmlElementWrapper(localName = "orderNotifications")
	@JacksonXmlProperty(localName = "orderNotification")
	@JsonProperty("orderNotifications")
	private List<OrderNotificationsDto> orderNotificationList;

	/**
	 * 
	 * @param orderNotificationList
	 */
	public void setNotificationList(List<OrderNotificationsDto> orderNotificationList) {
		this.orderNotificationList = orderNotificationList;
	}

	/**
	 * 
	 * @param orderNotification
	 */
	public void addOrderNotification(OrderNotificationsDto orderNotification) {

		if (orderNotificationList == null) {
			orderNotificationList = new ArrayList<OrderNotificationsDto>();
		}

		orderNotificationList.add(orderNotification);
	}

}
