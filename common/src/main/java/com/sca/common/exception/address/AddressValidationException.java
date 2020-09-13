package com.sca.common.exception.address;

import java.util.ArrayList;
import java.util.List;

import com.sca.common.exception.ErrorCodes;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.response.ValidationError;
import com.sca.common.util.ValidationUtil;
import com.sca.dto.location.AddressDto;

public class AddressValidationException extends InvalidInputException {

	private static final long serialVersionUID = 1L;

	public AddressValidationException(AddressDto addressDto) {

		List<ValidationError> validationErrors = new ArrayList<ValidationError>();

		if ((addressDto.getScaUserId() == null) || (addressDto.getScaUserId() <= 0)) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("userId cannot be null or less than 0");
			validationErrors.add(validationError);
		}

		if ((addressDto.getAddressTypeId() <= 0)) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("addressTypeId cannot be null or less than 0");
			validationErrors.add(validationError);
		}

		if ((addressDto.getContactFirstName() == null) || (addressDto.getContactFirstName().isEmpty())
				|| (addressDto.getContactFirstName().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("FirstName cannot be empty");
			validationErrors.add(validationError);
		}

		if ((addressDto.getContactLastName() == null) || (addressDto.getContactLastName().isEmpty())
				|| (addressDto.getContactLastName().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("LastName cannot be empty");
			validationErrors.add(validationError);
		}

		if ((addressDto.getContactEmail() == null) || (addressDto.getContactEmail().isEmpty())
				|| (addressDto.getContactEmail().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Email cannot be empty");
			validationErrors.add(validationError);
		} else if (!ValidationUtil.isValidEmail(addressDto.getContactEmail())) {

			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Invalid email");
			validationErrors.add(validationError);

		}

		if ((addressDto.getContactPhone() == null) || (addressDto.getContactPhone().isEmpty())
				|| (addressDto.getContactPhone().isBlank()))

		{
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("phone cannot be empty");
			validationErrors.add(validationError);
		}

		if ((addressDto.getCompanyName() == null) || (addressDto.getCompanyName().isEmpty())
				|| (addressDto.getCompanyName().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("CompanyName cannot be empty");
			validationErrors.add(validationError);
		}

		if ((addressDto.getAddressLine1() == null) || (addressDto.getAddressLine1().isEmpty())
				|| (addressDto.getAddressLine1().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("addressLine 1 cannot be empty");
			validationErrors.add(validationError);
		}

		if ((addressDto.getCity() == null) || (addressDto.getCity().isEmpty()) || (addressDto.getCity().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("City cannot be empty");
			validationErrors.add(validationError);
		}

		if ((addressDto.getState() == null) || (addressDto.getState().isEmpty()) || (addressDto.getState().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("State cannot be empty");
			validationErrors.add(validationError);
		}

		if (addressDto.getZip() < 5) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Zipcode cannot be empty");
			validationErrors.add(validationError);
		}

		if ((addressDto.getCountry() == null) || (addressDto.getCountry().isEmpty())
				|| (addressDto.getCountry().isBlank())) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Country cannot be empty");
			validationErrors.add(validationError);
		}

		if (validationErrors.size() > 0) {

			this.validationResponse.setValidationErrorList(validationErrors);

		}

	}

}
