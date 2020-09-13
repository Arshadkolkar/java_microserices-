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
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ValidationError validationError = new ValidationError();

	ValidationResponse validationResponse = new ValidationResponse();

	/**
	 * 
	 */
	public UnprocessableEntityException() {
		super();
	}

	/**
	 * 
	 * @param exceptionMsg
	 */
	public UnprocessableEntityException(String exceptionMsg) {
		super(exceptionMsg);
	}

	/**
	 * 
	 * @param message
	 * @param validationMessage
	 * @param errorCodeMessage
	 */
	public UnprocessableEntityException(String message, String validationMessage, String errorCodeMessage) {
		super(message);
		this.validationError.setCode(ErrorCodes.UnprocessableEntity.getStatusCode());
		this.validationError.addArg(message);
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