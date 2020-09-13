package com.sca.notification.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sca.common.exception.ExceptionUtil;
import com.sca.common.exception.GenericException;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.logger.DiagnosticLogger;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.notification.OrderNotifications;
import com.sca.dto.notification.OrderNotificationsDto;
import com.sca.notification.service.OrderNotificationService;
import com.sca.notification.util.Constants;

@RestController
@RequestMapping(Constants.ORDER_NOTIFICATION_REST_URL)
public class OrderNotificationController {

	@Autowired
	private OrderNotificationService orderNotificationService;

	@Autowired
	private ExceptionUtil exceptionUtil;

	DiagnosticLogger logger = DiagnosticLogger.getLogger(getClass());

	@PostMapping(value = "/notification")
	public ResponseEntity<ValidationResponse> createOrderNotification(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestBody OrderNotificationsDto orderNotificationsDto) throws GenericException {
		ValidationResponse response = null;

		try {

			orderNotificationService.createOrderNotifications(accessToken, orderNotificationsDto);

			response = new ValidationResponse();
			response.setSuccess(true);
			response.setMessage(orderNotificationsDto);
		} catch (InvalidInputException invalidInputException) {
			response = invalidInputException.getValidationResponse();
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to create the notifications");
		}

		return new ResponseEntity<ValidationResponse>(response, HttpStatus.CREATED);
	}

	@PutMapping(value = "/notification")
	public ResponseEntity<ValidationResponse> updateNotificationDetails(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestBody OrderNotificationsDto orderNotificationsDto) throws GenericException {
		ValidationResponse response = null;

		try {

			orderNotificationService.updateOrderNotifications(accessToken, orderNotificationsDto);

			response = new ValidationResponse();
			response.setMessage(orderNotificationsDto);
		}  catch (InvalidInputException invalidInputException) {
			response = invalidInputException.getValidationResponse();
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to Update the notifications Details");
		}

		return new ResponseEntity<ValidationResponse>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/notification")
	public ResponseEntity<ValidationResponse> getOrderNotifications(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "wmqId", required = false) String wmqId,
			@RequestParam(value = "orderId", required = false) Long orderId) throws GenericException {

		ValidationResponse response = null;
		OrderNotifications orderNotification = null;

		try {

			List<OrderNotificationsDto> NotificationsList = null;

			if (orderId > 0) {
				NotificationsList = orderNotificationService.getAllOrderNotificaitonsByOrderId(accessToken, orderId);
				orderNotification = new OrderNotifications();
				orderNotification.setNotificationList(NotificationsList);
			} else {
				NotificationsList = orderNotificationService.getAllOrderNotificaitonsByWmqId(accessToken, wmqId);
				orderNotification = new OrderNotifications();
				orderNotification.setNotificationList(NotificationsList);
			}

			response = new ValidationResponse();
			response.setMessage(orderNotification);
			response.setSuccess(true);

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get Order Notificaitons");
		}

		return ResponseEntity.ok(response);
	}
}
