/**
 * 
 */
package com.sca.order.service.web;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.sca.common.exception.ExceptionUtil;
import com.sca.common.exception.GenericException;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.logger.DiagnosticLogger;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.order.OrderDto;
import com.sca.dto.order.Orders;
import com.sca.order.service.OrderService;
import com.sca.order.util.Constants;

/**
 * 
 * @author santosh
 *
 */

@RestController
@RequestMapping(Constants.ORDER_REST_URL)
public class OrderController {

	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(OrderController.class);

	@Autowired
	private ExceptionUtil exceptionUtil;

	@Autowired
	private OrderService orderService;

	/**
	 * 
	 * @param accessToken
	 * @param orderDto
	 * @return
	 * @throws GenericException
	 */
	@PostMapping
	public ResponseEntity<ValidationResponse> createOrder(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "submitToFems", required = true) boolean submitToFems, @RequestBody OrderDto orderDto)
			throws GenericException {
		ValidationResponse response = new ValidationResponse();
		try {

			orderService.createOrder(accessToken, orderDto);
			logger.info("created an order for " + orderDto.getScaUserId());

			if (submitToFems) {
				orderService.submitOrderToFems(accessToken, orderDto);
				if (orderDto.getStatusCode() != 200) {
					response.setMessage(orderDto.getErrorMessage());
					response.setSuccess(false);
				} else {
					response.setMessage(orderDto);
				}
			} else {
				response.setMessage(orderDto);
			}

		} catch (InvalidInputException invalidInputException) {
			response = invalidInputException.getValidationResponse();
		} catch (EntityNotFoundException entityNotFoundException) {
			response.setMessage(entityNotFoundException.getMessage());
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to create an order");
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param accessToken
	 * @param userID
	 * @param orderID
	 * @return
	 * @throws GenericException
	 */
	@PutMapping
	public ResponseEntity<ValidationResponse> updateOrder(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "submitToFems", required = true) boolean submitToFems, @RequestBody OrderDto orderDto)
			throws GenericException {

		ValidationResponse response = new ValidationResponse();

		try {
			logger.debug("update order api");
			orderService.updateOrder(accessToken, orderDto);

			if (submitToFems) {
				orderService.submitOrderToFems(accessToken, orderDto);
				if (orderDto.getStatusCode() != 200) {
					response.setMessage(orderDto.getErrorMessage());
					response.setSuccess(false);
				} else {
					response.setMessage(orderDto);
				}
			} else {
				response.setMessage(orderDto);
			}
		} catch (InvalidInputException invalidInputException) {
			response = invalidInputException.getValidationResponse();
		} catch (EntityNotFoundException entityNotFoundException) {
			response.setMessage(entityNotFoundException.getMessage());
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to update the order");
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param accessToken
	 * @param userID
	 * @param orderID
	 * @return
	 * @throws GenericException
	 */
	@GetMapping(path = "/{orderId}")
	public ResponseEntity<ValidationResponse> getOrder(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@PathVariable(value = "orderId", required = true) Long orderId) throws GenericException {

		ValidationResponse response = new ValidationResponse();

		try {
			logger.debug("order get api");
			OrderDto orderDto = orderService.getOrder(accessToken, orderId);
			response.setMessage(orderDto);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get the order");
		}

		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<ValidationResponse> getOrders(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "scaUserId", required = true) Long scaUserId) throws GenericException {

		ValidationResponse response = new ValidationResponse();

		try {
			logger.debug("getOrders called of an user");

			Orders orders = orderService.getOrders(accessToken, scaUserId);
			response.setMessage(orders);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get the order");
		}

		return ResponseEntity.ok(response);
	}

	@GetMapping(path = "/shippingoptions")
	public ResponseEntity<ValidationResponse> getshippingoptions(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "shippingCountry", required = true) String shippingCountry,
			@RequestParam(value = "shippingState", required = true) String shippingState) throws GenericException {
		ValidationResponse response = new ValidationResponse();

		try {
			logger.debug("get shipping details");
			JsonNode shippingDetailsjson = orderService.getshippingoptions(accessToken, userId, shippingCountry,
					shippingState);
			response.setMessage(shippingDetailsjson);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get the order");
		}

		return ResponseEntity.ok(response);
	}

}
