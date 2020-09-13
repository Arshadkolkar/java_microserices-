/**
 * 
 */
package com.sca.order.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.exception.order.OrderValidationException;
import com.sca.common.response.ValidationError;
import com.sca.dao.domain.location.Address;
import com.sca.dao.domain.order.Order;
import com.sca.dao.domain.payment.CreditCard;
import com.sca.dao.repository.location.LocationRepository;
import com.sca.dao.repository.order.OrderRepository;
import com.sca.dao.repository.payment.PaymentRepository;
import com.sca.dto.location.AddressDto;
import com.sca.dto.order.OrderDto;
import com.sca.dto.order.Orders;
import com.sca.dto.payment.CreditCardDto;
import com.sca.fems.service.FemsOrderService;
import com.sca.order.service.OrderService;

/**
 * 
 * @author
 *
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	// private static final DiagnosticLogger logger =
	// DiagnosticLogger.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private FemsOrderService femsOrderService;

	List<ValidationError> validationErrors = new ArrayList<ValidationError>();

	/**
	 * order creation for an user
	 */
	@Override
	public void createOrder(String accessToken, OrderDto orderDto) {

		if (orderDto != null) {

			OrderValidationException orderValidationException = new OrderValidationException(orderDto);
			if ((orderValidationException.getValidationResponse() != null)
					&& (orderValidationException.getValidationResponse().isSuccess() == false)) {
				throw orderValidationException;
			}

			Order order = new Order();

			order.setScaUserId(orderDto.getScaUserId());
			order.setUserId(orderDto.getUserId());
			order.setShippingAddressId(orderDto.getShippingAddress().getAddressId());
			order.setBillingAddressId(orderDto.getBillingAddress().getAddressId());
			order.setDesignerAddressId(orderDto.getDesignergAddress().getAddressId());
			order.setCreditCardId(orderDto.getCreditCardDetails().getCreditCardId());
			order.setWqNumber(orderDto.getWqNumber());
			order.setPromoCode((orderDto.getPromoCode().isBlank() || orderDto.getPromoCode() == null) ? ""
					: orderDto.getPromoCode());
			order.setProjectId((orderDto.getProjectId().isBlank() || orderDto.getProjectId() == null) ? ""
					: orderDto.getProjectId());
			order.setShippingAccountNumber(
					(orderDto.getShippingAccountNumber() == null || orderDto.getShippingAccountNumber() <= 0) ? 0
							: orderDto.getShippingAccountNumber());
			order.setShippingMethod(orderDto.getShippingMethod());
			order.setShippingNotes((orderDto.getShippingNotes().isBlank() || orderDto.getShippingNotes() == null) ? ""
					: orderDto.getShippingNotes());
			order.setTaxable(orderDto.isTaxable());
			order.setTaxExemptCertNumber(
					(orderDto.getTaxExemptCertNumber().isBlank() || orderDto.getTaxExemptCertNumber() == null) ? ""
							: orderDto.getTaxExemptCertNumber());
			order.setTaxExemptOutsideCalifornia((orderDto.getTaxExemptOutsideCalifornia().isBlank()
					|| orderDto.getTaxExemptOutsideCalifornia() == null) ? ""
							: orderDto.getTaxExemptOutsideCalifornia());
			order.setResaleNumber((orderDto.getResaleNumber().isBlank() || orderDto.getResaleNumber() == null) ? ""
					: orderDto.getResaleNumber());
			// order.setActive(orderDto.isActive()!=null?orderDto.isActive():false);

			orderRepository.save(order);

			orderDto.setOrderId(order.getOrderId());
			orderDto = this.copyToOrderDto(orderDto, order);

		}
	}

	/**
	 * 
	 */
	@Override
	public void updateOrder(String accessToken, OrderDto orderDto) {

		OrderValidationException orderValidationException = new OrderValidationException(orderDto);
		if ((orderValidationException.getValidationResponse() != null)
				&& (orderValidationException.getValidationResponse().isSuccess() == false)) {
			throw orderValidationException;
		}

		Optional<Order> orderOptional = orderRepository.findById(orderDto.getOrderId());

		if (orderOptional.isPresent()) {
			Order order = orderOptional.get();

			order.setScaUserId(orderDto.getScaUserId());
			order.setUserId(orderDto.getUserId());
			order.setShippingAddressId(orderDto.getShippingAddress().getAddressId());
			order.setBillingAddressId(orderDto.getBillingAddress().getAddressId());
			order.setDesignerAddressId(orderDto.getDesignergAddress().getAddressId());
			order.setCreditCardId(orderDto.getCreditCardDetails().getCreditCardId());
			order.setWqNumber(orderDto.getWqNumber());
			order.setPromoCode((orderDto.getPromoCode().isBlank() || orderDto.getPromoCode() == null) ? ""
					: orderDto.getPromoCode());
			order.setProjectId((orderDto.getProjectId().isBlank() || orderDto.getProjectId() == null) ? ""
					: orderDto.getProjectId());
			order.setShippingAccountNumber(
					(orderDto.getShippingAccountNumber() == null || orderDto.getShippingAccountNumber() <= 0) ? 0
							: orderDto.getShippingAccountNumber());
			order.setShippingMethod(orderDto.getShippingMethod());
			order.setShippingNotes((orderDto.getShippingNotes().isBlank() || orderDto.getShippingNotes() == null) ? ""
					: orderDto.getShippingNotes());
			order.setTaxable(orderDto.isTaxable());
			order.setTaxExemptCertNumber(
					(orderDto.getTaxExemptCertNumber().isBlank() || orderDto.getTaxExemptCertNumber() == null) ? ""
							: orderDto.getTaxExemptCertNumber());
			order.setTaxExemptOutsideCalifornia((orderDto.getTaxExemptOutsideCalifornia().isBlank()
					|| orderDto.getTaxExemptOutsideCalifornia() == null) ? ""
							: orderDto.getTaxExemptOutsideCalifornia());
			order.setResaleNumber((orderDto.getResaleNumber().isBlank() || orderDto.getResaleNumber() == null) ? ""
					: orderDto.getResaleNumber());
			// order.setActive(orderDto.isActive()!=null?orderDto.isActive():false);

			orderRepository.save(order);

			orderDto = this.copyToOrderDto(orderDto, order);
		} else {
			throw new InvalidInputException("Could not find order to update");
		}

	}

	/**
	 * 
	 */
	@Override
	public OrderDto getOrder(String accessToken, Long orderId) {

		// need to check how to implement below commented lines

		Order order = orderRepository.getOne(orderId);

		/*
		 * if (order == null) throw OrderNotFoundException(orderId);
		 */

		OrderDto orderDto = this.copyToOrderDto(null, order);

		// BeanUtils.copyProperties(order, orderDto);

		return orderDto;
	}

	@Override
	public Orders getOrders(String accessToken, Long scaUserId) {

		Orders orders = null;

		List<OrderDto> orderDtoList = null;

		List<Order> orderList = orderRepository.findByscaUserId(scaUserId);

		if ((orderList != null) && (orderList.size() > 0)) {
			orderDtoList = new ArrayList<OrderDto>();
			orders = new Orders();
			for (Order order : orderList) {
				orderDtoList.add(this.copyToOrderDto(null, order));
			}
			orders.setOrderList(orderDtoList);
		}
		return orders;

	}

	private OrderDto copyToOrderDto(OrderDto orderDto, Order order) {

		if (order != null) {
			try {
				if (orderDto == null) {
					orderDto = new OrderDto();
				}

				orderDto.setOrderId(order.getOrderId());
				orderDto.setUserId(order.getUserId());
				orderDto.setScaUserId(order.getScaUserId());

				// address details
				Address shippingAddress = locationRepository.getOne(order.getShippingAddressId());
				if (shippingAddress != null) {
					if (shippingAddress.getAddressType().getName().equalsIgnoreCase("Shipping Address")
							|| shippingAddress.getAddressType().getName().equalsIgnoreCase("Other Address")) {

						AddressDto shippaingAddressdto = new AddressDto();

						shippaingAddressdto.setScaUserId(shippingAddress.getScaUserId());
						shippaingAddressdto.setAddressId(shippingAddress.getAddressId());
						shippaingAddressdto.setDefaultAddress(shippingAddress.isDefault());
						shippaingAddressdto.setAddressLine1(shippingAddress.getAddressLine1());
						shippaingAddressdto.setAddressLine2(shippingAddress.getAddressLine2());
						shippaingAddressdto.setAddressTypeId(shippingAddress.getAddressType().getAddressTypeId());
						shippaingAddressdto.setAddressTypeName(shippingAddress.getAddressType().getName());
						shippaingAddressdto.setCity(shippingAddress.getCity());
						shippaingAddressdto.setCompanyName(shippingAddress.getCompanyName());
						shippaingAddressdto.setContactEmail(shippingAddress.getContactEmail());
						shippaingAddressdto.setContactFirstName(shippingAddress.getContactFirstName());
						shippaingAddressdto.setContactLastName(shippingAddress.getContactLastName());
						shippaingAddressdto.setContactPhone(shippingAddress.getContactPhone());
						shippaingAddressdto.setCountry(shippingAddress.getCountry());
						shippaingAddressdto.setState(shippingAddress.getState());
						shippaingAddressdto.setZip(shippingAddress.getZip());

						orderDto.setShippingAddress(shippaingAddressdto);

					}
				}

				Address billingAddress = locationRepository.getOne(order.getBillingAddressId());
				if (billingAddress != null) {
					if (billingAddress.getAddressType().getName().equalsIgnoreCase("Billing Address")
							|| billingAddress.getAddressType().getName().equalsIgnoreCase("Other Address")) {

						AddressDto billingAddressdto = new AddressDto();

						billingAddressdto.setScaUserId(billingAddress.getScaUserId());
						billingAddressdto.setAddressId(billingAddress.getAddressId());
						billingAddressdto.setDefaultAddress(billingAddress.isDefault());
						billingAddressdto.setAddressLine1(billingAddress.getAddressLine1());
						billingAddressdto.setAddressLine2(billingAddress.getAddressLine2());
						billingAddressdto.setAddressTypeId(billingAddress.getAddressType().getAddressTypeId());
						billingAddressdto.setAddressTypeName(billingAddress.getAddressType().getName());
						billingAddressdto.setCity(billingAddress.getCity());
						billingAddressdto.setCompanyName(billingAddress.getCompanyName());
						billingAddressdto.setContactEmail(billingAddress.getContactEmail());
						billingAddressdto.setContactFirstName(billingAddress.getContactFirstName());
						billingAddressdto.setContactLastName(billingAddress.getContactLastName());
						billingAddressdto.setContactPhone(billingAddress.getContactPhone());
						billingAddressdto.setCountry(billingAddress.getCountry());
						billingAddressdto.setState(billingAddress.getState());
						billingAddressdto.setZip(billingAddress.getZip());

						orderDto.setBillingAddress(billingAddressdto);

					}
				}

				Address designerAddress = locationRepository.getOne(order.getDesignerAddressId());
				if (designerAddress != null) {

					if (designerAddress.getAddressType().getName().equalsIgnoreCase("Designer Address")
							|| designerAddress.getAddressType().getName().equalsIgnoreCase("Other Address")) {
						AddressDto designerAddressDto = new AddressDto();

						designerAddressDto.setScaUserId(designerAddress.getScaUserId());
						designerAddressDto.setAddressId(designerAddress.getAddressId());
						designerAddressDto.setDefaultAddress(designerAddress.isDefault());
						designerAddressDto.setAddressLine1(designerAddress.getAddressLine1());
						designerAddressDto.setAddressLine2(designerAddress.getAddressLine2());
						designerAddressDto.setAddressTypeId(designerAddress.getAddressType().getAddressTypeId());
						designerAddressDto.setAddressTypeName(designerAddress.getAddressType().getName());
						designerAddressDto.setCity(designerAddress.getCity());
						designerAddressDto.setCompanyName(designerAddress.getCompanyName());
						designerAddressDto.setContactEmail(designerAddress.getContactEmail());
						designerAddressDto.setContactFirstName(designerAddress.getContactFirstName());
						designerAddressDto.setContactLastName(designerAddress.getContactLastName());
						designerAddressDto.setContactPhone(designerAddress.getContactPhone());
						designerAddressDto.setCountry(designerAddress.getCountry());
						designerAddressDto.setState(designerAddress.getState());
						designerAddressDto.setZip(designerAddress.getZip());

						orderDto.setDesignergAddress(designerAddressDto);
					}
				}
				// Credit card details

				CreditCard cardDetails = paymentRepository.getOne(order.getCreditCardId());
				if (cardDetails != null) {
					CreditCardDto creditCardDto = new CreditCardDto();

					creditCardDto.setScaUserId(cardDetails.getUser().getScaUserId());
					creditCardDto.setCreditCardId(cardDetails.getCreditCardId());
					creditCardDto.setCreditCardNumber(cardDetails.getCreditCardNumber());
					creditCardDto.setCreditCardHolderName(cardDetails.getCreditCardHolderName());
					creditCardDto.setCreditCardName(cardDetails.getCreditCardType().getDisplayName());
					creditCardDto.setCreditCardTypeId(cardDetails.getCreditCardType().getCreditCardTypeId());
					creditCardDto.setCreditCardSecurityCode(cardDetails.getCreditCardSecurityCode());
					creditCardDto.setCreditCardExpiryDate(cardDetails.getCreditCardExpiryDate());
					orderDto.setCreditCardDetails(creditCardDto);
				}
				// other details
				orderDto.setShippingAccountNumber(order.getShippingAccountNumber());
				orderDto.setShippingCharges(order.getShippingCharges());
				orderDto.setShippingMethod(order.getShippingMethod());
				orderDto.setShippingNotes(order.getShippingNotes());
				orderDto.setWqNumber(order.getWqNumber());
				orderDto.setTaxable(order.isTaxable());
				orderDto.setPromoCode(order.getPromoCode());
				orderDto.setProjectId(order.getProjectId());
				orderDto.setTaxExemptCertNumber(order.getTaxExemptCertNumber());
				orderDto.setTaxExemptOutsideCalifornia(order.getTaxExemptOutsideCalifornia());
				orderDto.setResaleNumber(order.getResaleNumber());
				orderDto.setActive(order.isActive());
				orderDto.setEntityStatusId(order.getEntityStatusId());
				orderDto.setOrderNumber(order.getOrderNumber());
				orderDto.setOrderSubTotal(order.getOrderSubTotal());
				orderDto.setOrderTotal(order.getOrderTotal());
				orderDto.setShippingCharges(order.getShippingCharges());
				orderDto.setCalculatedTax(order.getCalculatedTax());
			} catch (EntityNotFoundException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			}
		}
		return orderDto;
	}

	@Override
	public void submitOrderToFems(String accessToken, OrderDto orderDto) {

		if (orderDto.getOrderNumber() != null) {
			return;
		}
		femsOrderService.createOrder(accessToken, orderDto);

		Order order = orderRepository.getOne(orderDto.getOrderId());
		order.setOrderNumber(orderDto.getOrderNumber());
		order.setOrderSubTotal(orderDto.getOrderSubTotal());
		order.setShippingCharges(orderDto.getShippingCharges());
		order.setCalculatedTax(orderDto.getCalculatedTax());
		order.setOrderTotal(orderDto.getOrderTotal());
		orderRepository.save(order);
	}

	@Override
	public JsonNode getshippingoptions(String accessToken, String userId, String shippingCountry,
			String shippingState) {
		JsonNode shippingoptions = femsOrderService.getShippingOptions(accessToken, userId, shippingCountry,
				shippingState);
		return shippingoptions;
	}

}