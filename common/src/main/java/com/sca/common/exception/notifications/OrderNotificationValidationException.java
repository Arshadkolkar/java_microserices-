package com.sca.common.exception.notifications;

import java.util.ArrayList;
import java.util.List;

import com.sca.common.exception.ErrorCodes;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.response.ValidationError;
import com.sca.dto.notification.OrderNotificationsDto;

public class OrderNotificationValidationException extends InvalidInputException {

	private static final long serialVersionUID = 1L;

	public OrderNotificationValidationException(OrderNotificationsDto orderNotificationsDto) {

		List<ValidationError> validationErrors = new ArrayList<ValidationError>();

		if ((orderNotificationsDto.getFirstName() == null) || (orderNotificationsDto.getFirstName().isEmpty())
				|| (orderNotificationsDto.getFirstName().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("First Name cannot be empty");
			validationErrors.add(validationError);
		}

		if ((orderNotificationsDto.getEmail() == null) || (orderNotificationsDto.getEmail().isEmpty())
				|| (orderNotificationsDto.getEmail().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Email cannot be empty");
			validationErrors.add(validationError);
		}

		if ((orderNotificationsDto.getPhoneNo() == null) || (orderNotificationsDto.getPhoneNo().isEmpty())
				|| (orderNotificationsDto.getPhoneNo().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Phone Number cannot be empty");
			validationErrors.add(validationError);
		}

		if ((orderNotificationsDto.getWmqId() == null) || (orderNotificationsDto.getWmqId().isEmpty())
				|| (orderNotificationsDto.getWmqId().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("WmqId cannot be empty");
			validationErrors.add(validationError);
		}

		if (orderNotificationsDto.isBillingRelated() == false & orderNotificationsDto.isDndDisturb() == false
				& orderNotificationsDto.isEngineer() == false & orderNotificationsDto.isIs24Hour() == false
				& orderNotificationsDto.isPcbDesigner() == false & orderNotificationsDto.isPrimary() == false
				& orderNotificationsDto.isQualityControlRelated() == false
				& orderNotificationsDto.isShareProject() == false
				& orderNotificationsDto.isShippingRelated() == false) {

			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Please choose any of the check box");
			validationErrors.add(validationError);
		}

		if (validationErrors.size() > 0) {

			this.validationResponse.setValidationErrorList(validationErrors);

		}
	}

}
