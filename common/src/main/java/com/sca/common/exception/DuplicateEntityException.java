/**
 * 
 */
package com.sca.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sca.common.response.ValidationError;
import com.sca.common.response.ValidationResponse;

/**
 * 
 * @author subhash
 *
 */
@ResponseStatus(HttpStatus.MULTIPLE_CHOICES)
public class DuplicateEntityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ValidationError validationError = new ValidationError();

	ValidationResponse validationResponse = new ValidationResponse();

	/**
	 * 
	 */
	public DuplicateEntityException() {
		super();
	}

	/**
	 * 
	 * @param attributeName
	 * @param attributeValue
	 * @param validationMessage
	 * @param errorCodeMessage
	 */
	public DuplicateEntityException(String attributeName, String attributeValue, String validationMessage,
			String errorCodeMessage) {
		super(validationMessage);
		this.validationError.setCode(ErrorCodes.DuplicateData.getStatusCode());
		this.validationError.addArg(attributeName);
		this.validationError.addArg(attributeValue);
		this.validationError.setMessageWithArgs(errorCodeMessage);
		this.validationResponse.addValidatorError(validationError);
		this.validationResponse.setMessage(validationMessage);
	}

	/**
	 * 
	 * @return
	 */
	public ValidationResponse getValidationResponse() {
		return validationResponse;
	}

	/**
	 * 
	 * @return
	 */
	public ValidationError getValidationError() {
		return validationError;
	}
}