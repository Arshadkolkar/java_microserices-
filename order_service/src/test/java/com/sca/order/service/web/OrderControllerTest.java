package com.sca.order.service.web;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;
import com.sca.common.exception.GenericException;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.order.OrderDto;
import com.sca.order.service.OrderService;

class OrderControllerTest {

	@InjectMocks
	OrderController orderController;

	@Mock
	OrderService orderService;

	OrderDto orderDto;
	
	JsonNode shippingOption=null;

	/*
	 * @Test void test() { MockitoAnnotations.initMocks(this);
	 * 
	 * orderDto = new OrderDto(); fail("Not yet implemented"); }
	 */
	@Test
	void testGetshippingoptions() throws GenericException {

		when(orderService.getshippingoptions("123", "sds76sddm","USA","California")).thenReturn(shippingOption);
		ResponseEntity<ValidationResponse> shippingOption = orderController.getshippingoptions("123", "sds76sddm","USA","California");

		assertNotNull(shippingOption);

	}
}
