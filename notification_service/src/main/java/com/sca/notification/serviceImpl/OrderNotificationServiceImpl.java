/**
 * 
 */
package com.sca.notification.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sca.common.exception.InvalidInputException;
import com.sca.common.exception.address.AddressValidationException;
import com.sca.common.exception.notifications.OrderNotificationValidationException;
import com.sca.common.util.ValidationUtil;
import com.sca.dao.domain.notification.OrderNotification;
import com.sca.dao.repository.notification.OrderNotificationRepository;
import com.sca.dto.notification.OrderNotificationsDto;

/**
 * 
 * @author Arshad K
 */
@Service
public class OrderNotificationServiceImpl implements com.sca.notification.service.OrderNotificationService {

	@Autowired
	private OrderNotificationRepository orderNotificationRepository;

	@Override
	public void createOrderNotifications(String accessToken, OrderNotificationsDto orderNotificationsDto) {

		OrderNotificationValidationException orderNotificationValidationException = new OrderNotificationValidationException(
				orderNotificationsDto);

		if ((orderNotificationValidationException.getValidationResponse() != null)
				&& (orderNotificationValidationException.getValidationResponse().isSuccess() == false)) {
			throw orderNotificationValidationException;
		}
//		isEmailAlreadyExists(orderNotificationsDto.getEmail());
		OrderNotification orderNotification = new OrderNotification();

		orderNotification.setEntityStatusId(1);
		orderNotification.setIsActive(true);
		orderNotification.setScaUserId(orderNotificationsDto.getScaUserId());
		orderNotification.setUserId(orderNotificationsDto.getUserId());
		orderNotification.setOrderId(orderNotificationsDto.getOrderId());

		orderNotification.setWmqId(orderNotificationsDto.getWmqId());
		orderNotification.setEmail(orderNotificationsDto.getEmail());
		orderNotification.setFirstName(orderNotificationsDto.getFirstName());
		orderNotification.setLastName(orderNotificationsDto.getLastName());
		orderNotification.setPhoneNumber(orderNotificationsDto.getPhoneNo());

		orderNotification.setIs24Hour(orderNotificationsDto.isIs24Hour());
		orderNotification.setDndDisturb(orderNotificationsDto.isDndDisturb());
		orderNotification.setPrimary(orderNotificationsDto.isPrimary());
		orderNotification.setPcbDesigner(orderNotificationsDto.isPcbDesigner());
		orderNotification.setEngineer(orderNotificationsDto.isEngineer());
		orderNotification.setShippingelated(orderNotificationsDto.isShippingRelated());
		orderNotification.setBillingRelated(orderNotificationsDto.isBillingRelated());
		orderNotification.setQualityControlRelated(orderNotificationsDto.isQualityControlRelated());
		orderNotification.setShareProject(orderNotificationsDto.isShareProject());

		orderNotificationRepository.save(orderNotification);

		orderNotificationsDto.setOrderNotificationId(orderNotification.getOrderNotificationId());

	}

	/**
	 * A Service class method to update the notification details based on user_id
	 * and respective order_id
	 */
	@Override
	public void updateOrderNotifications(String accessToken, OrderNotificationsDto orderNotificationsDto) {

		OrderNotification orderNotifications = orderNotificationRepository
				.getOne(orderNotificationsDto.getOrderNotificationId());
		OrderNotificationValidationException orderNotificationValidationException = new OrderNotificationValidationException(
				orderNotificationsDto);

		if ((orderNotificationValidationException.getValidationResponse() != null)
				&& (orderNotificationValidationException.getValidationResponse().isSuccess() == false)) {
			throw orderNotificationValidationException;
		}

		orderNotifications.setScaUserId(orderNotificationsDto.getScaUserId());
		orderNotifications.setUserId(orderNotificationsDto.getUserId());
		orderNotifications.setOrderId(orderNotificationsDto.getOrderId());
		orderNotifications.setWmqId(orderNotificationsDto.getWmqId());
		orderNotifications.setOrderNotificationId(orderNotificationsDto.getOrderNotificationId());
		orderNotifications.setEmail(orderNotificationsDto.getEmail());
		orderNotifications.setFirstName(orderNotificationsDto.getFirstName());
		orderNotifications.setPhoneNumber(orderNotificationsDto.getPhoneNo());
		orderNotifications.setIs24Hour(orderNotificationsDto.isIs24Hour());
		orderNotifications.setDndDisturb(orderNotificationsDto.isDndDisturb());
		orderNotifications.setPrimary(orderNotificationsDto.isPrimary());
		orderNotifications.setPcbDesigner(orderNotificationsDto.isPcbDesigner());
		orderNotifications.setEngineer(orderNotificationsDto.isEngineer());
		orderNotifications.setShippingelated(orderNotificationsDto.isShippingRelated());
		orderNotifications.setBillingRelated(orderNotificationsDto.isBillingRelated());
		orderNotifications.setQualityControlRelated(orderNotificationsDto.isQualityControlRelated());
		orderNotifications.setShareProject(orderNotificationsDto.isShareProject());

		orderNotificationRepository.save(orderNotifications);

	}

	/**
	 * A Service class method to get the notification details by OrderId
	 */

	@Override
	public List<OrderNotificationsDto> getAllOrderNotificaitonsByOrderId(String accessToken, Long orderId) {

		List<OrderNotificationsDto> orderNotificationsDto = null;

		List<OrderNotification> orderNotificationList = orderNotificationRepository.findByOrderId(orderId);

		if ((orderNotificationList != null) && (orderNotificationList.size() > 0)) {

			orderNotificationsDto = new ArrayList<OrderNotificationsDto>();

			for (OrderNotification orderNotification : orderNotificationList) {
				orderNotificationsDto.add(this.copyToOrderNotificationsDto(null, orderNotification));
			}
		}

		return orderNotificationsDto;
	}

	/**
	 * A Service class method to get the notification by WmqId
	 */

	@Override
	public List<OrderNotificationsDto> getAllOrderNotificaitonsByWmqId(String accessToken, String wmqId) {

		List<OrderNotificationsDto> orderNotificationsDto = null;

		List<OrderNotification> orderNotificationList = orderNotificationRepository.findByWmqId(wmqId);

		if ((orderNotificationList != null) && (orderNotificationList.size() > 0)) {

			orderNotificationsDto = new ArrayList<OrderNotificationsDto>();

			for (OrderNotification orderNotification : orderNotificationList) {
				orderNotificationsDto.add(this.copyToOrderNotificationsDto(null, orderNotification));
			}
		}

		return orderNotificationsDto;
	}

	private OrderNotificationsDto copyToOrderNotificationsDto(OrderNotificationsDto orderNotificationsDto,
			OrderNotification orderNotification) {

		if (orderNotification != null) {

			if (orderNotificationsDto == null) {
				orderNotificationsDto = new OrderNotificationsDto();
			}
			orderNotificationsDto.setOrderNotificationId(orderNotification.getOrderNotificationId());
			orderNotificationsDto.setOrderId(orderNotification.getOrderId());
			orderNotificationsDto.setScaUserId(orderNotification.getScaUserId());
			orderNotificationsDto.setUserId(orderNotification.getUserId());
			orderNotificationsDto.setWmqId(orderNotification.getWmqId());
			orderNotificationsDto.setFirstName(orderNotification.getFirstName());
			orderNotificationsDto.setLastName(orderNotification.getLastName());
			orderNotificationsDto.setEmail(orderNotification.getEmail());
			orderNotificationsDto.setPhoneNo(orderNotification.getPhoneNumber());
			orderNotificationsDto.setDndDisturb(orderNotification.isDndDisturb());
			orderNotificationsDto.setIs24Hour(orderNotification.isIs24Hour());
			orderNotificationsDto.setDndDisturb(orderNotification.isDndDisturb());
			orderNotificationsDto.setPrimary(orderNotification.isPrimary());
			orderNotificationsDto.setPcbDesigner(orderNotification.isPcbDesigner());
			orderNotificationsDto.setEngineer(orderNotification.isEngineer());
			orderNotificationsDto.setShippingRelated(orderNotification.isShippingelated());
			orderNotificationsDto.setBillingRelated(orderNotification.isBillingRelated());
			orderNotificationsDto.setQualityControlRelated(orderNotification.isQualityControlRelated());
			orderNotificationsDto.setShareProject(orderNotification.isShareProject());

		}

		return orderNotificationsDto;
	}

}
