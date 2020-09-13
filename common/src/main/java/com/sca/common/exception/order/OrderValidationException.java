package com.sca.common.exception.order;

import java.util.ArrayList;
import java.util.List;

import com.sca.common.exception.ErrorCodes;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.response.ValidationError;
import com.sca.dto.order.OrderDto;

public class OrderValidationException extends InvalidInputException {

	private static final long serialVersionUID = 1L;

	public OrderValidationException(OrderDto orderDto) {

		List<ValidationError> validationErrors = new ArrayList<ValidationError>();

		if ((orderDto.getUserId() == null) || (orderDto.getUserId().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("userId cannot be null or empty");
			validationErrors.add(validationError);
		}
		if (orderDto.getScaUserId() == null) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("ScaUserId cannot be null or empty");
			validationErrors.add(validationError);
		}

		if ((orderDto.getShippingAddress() == null) || (orderDto.getShippingAddress().getAddressId() <= 0)) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Shipping address cannot be null or empty");
			validationErrors.add(validationError);
		}

		if ((orderDto.getBillingAddress() == null) || (orderDto.getBillingAddress().getAddressId() <= 0)) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Billing address cannot be null or empty");
			validationErrors.add(validationError);
		}

		if ((orderDto.getDesignergAddress() == null) || (orderDto.getDesignergAddress().getAddressId() <= 0)) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Designer address cannot be null or empty");
			validationErrors.add(validationError);
		}

		if ((orderDto.getCreditCardDetails() == null) || (orderDto.getCreditCardDetails().getCreditCardId() <= 0)) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Credit card details cannot be null or empty");
			validationErrors.add(validationError);
		}

		if ((orderDto.getWqNumber() == null) || (orderDto.getWqNumber().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("WQNumber cannot be null or empty");
			validationErrors.add(validationError);
		}
		if (!orderDto.isTaxable()) {
			if (((orderDto.getTaxExemptCertNumber() == null) || (orderDto.getTaxExemptCertNumber().isBlank()))
					&& ((orderDto.getResaleNumber() == null) || (orderDto.getResaleNumber().isBlank()))
					&& ((orderDto.getTaxExemptOutsideCalifornia() == null) || (orderDto.getTaxExemptOutsideCalifornia().isBlank()))) {
				ValidationError validationError = new ValidationError();
				validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
				validationError.setMessage("Atleast One Resale Option Must Be Filled");
				validationErrors.add(validationError);
			}
		}
		if ((orderDto.getShippingMethod() == null) || (orderDto.getShippingMethod() <= 0)) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Shipping Method cannot be null or empty");
			validationErrors.add(validationError);
		}
		if ((orderDto.getDesignFileName() == null) || (orderDto.getDesignFileName().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Designer file name cannot be null or empty");
			validationErrors.add(validationError);
		}
		

		if (validationErrors.size() > 0) {

			this.validationResponse.setValidationErrorList(validationErrors);

		}

	}

}
