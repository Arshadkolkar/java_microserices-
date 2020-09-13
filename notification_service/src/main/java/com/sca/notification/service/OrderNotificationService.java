/**
 * 
 * @author Arshad 
 *
 */
package com.sca.notification.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.dto.notification.OrderNotificationsDto;

@Service
@Transactional
public interface OrderNotificationService {

	
	void createOrderNotifications(String accessToken, OrderNotificationsDto orderNotificationsDto);

	void updateOrderNotifications(String accessToken, OrderNotificationsDto orderNotifications);

	List<OrderNotificationsDto> getAllOrderNotificaitonsByOrderId(String accessToken, Long orderId);

	List<OrderNotificationsDto> getAllOrderNotificaitonsByWmqId(String accessToken, String wmqId);

}
