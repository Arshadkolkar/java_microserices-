/**
 * 
 */
package com.sca.order.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sca.dto.order.OrderDto;
import com.sca.dto.order.Orders;

/**
 * 
 * @author
 *
 */
public interface OrderService {

	/**
	 * 
	 * @param accessToken
	 * @param userID
	 */
	Orders getOrders(String accessToken, Long userID);

	/**
	 * 
	 * @param accessToken
	 * @param orderID
	 */
	OrderDto getOrder(String accessToken, Long orderId);

	/**
	 * 
	 * @param accessToken
	 * @param orderDto
	 * @return
	 */
	void createOrder(String accessToken, OrderDto orderDto);

	void submitOrderToFems(String accessToken, OrderDto orderDto);

	/**
	 * 
	 * @param accessToken
	 * @param orderDto
	 */
	void updateOrder(String accessToken, OrderDto orderDto);

	JsonNode getshippingoptions(String accessToken, String userId, String shippingCountry, String shippingState);

}
