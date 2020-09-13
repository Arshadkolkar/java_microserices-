package com.sca.notification.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.sca.common.exception.GenericException;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.notification.OrderNotificationsDto;
import com.sca.notification.service.OrderNotificationService;

public class OrderNotificationControllerTest {
	@InjectMocks
	OrderNotificationController orderNotificationController;

	@Mock
	OrderNotificationService orderNotificationService;

	OrderNotificationsDto orderNotificationsDto;

	List<OrderNotificationsDto> orderNotificationsList = null;

	private Long orderId = 1L;

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		orderNotificationsDto = new OrderNotificationsDto();

		orderNotificationsDto.setFirstName("Arshad");
		orderNotificationsDto.setLastName("kollkar");
		orderNotificationsDto.setEmail("arshad@gmail.com");
		orderNotificationsDto.setOrderId(orderId);
		orderNotificationsDto.setDndDisturb(true);
		orderNotificationsDto.setEngineer(true);

	}

	@Test
	public void testCreateOrderNotification() throws GenericException {

		orderNotificationService.createOrderNotifications("123", orderNotificationsDto);

		ResponseEntity<ValidationResponse> response = orderNotificationController.createOrderNotification("123",
				orderNotificationsDto);

		assertNotNull(response);

		assertEquals(201, response.getStatusCodeValue());

	}

	@Test
	public void testUpdateNotificationDetails() throws Exception {

		orderNotificationService.updateOrderNotifications("123", orderNotificationsDto);

		ResponseEntity<ValidationResponse> response = orderNotificationController.updateNotificationDetails("123", orderNotificationsDto);

		assertNotNull(response);
		assertEquals(200, response.getStatusCodeValue());

	}

	
	@Test
	final void testGetOrderNotifications() throws GenericException {

		when(orderNotificationService.getAllOrderNotificaitonsByOrderId("123", orderId)).thenReturn(orderNotificationsList);

		ResponseEntity<ValidationResponse> orderNotificationsDtoList = orderNotificationController.getOrderNotifications("123", "wmqId", orderId);

		assertNotNull(orderNotificationsDtoList);

		assertEquals(200, orderNotificationsDtoList.getStatusCodeValue());
	}


}
