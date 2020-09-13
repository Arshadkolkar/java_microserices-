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
@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
public class DependencyEntityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ValidationError validationError = new ValidationError();

	ValidationResponse validationResponse = new ValidationResponse();

	/**
	 * 
	 */
	public DependencyEntityException() {
		super();
	}

	/**
	 * 
	 * @param parentEntity
	 * @param parentEntityId
	 * @param childEntityName
	 * @param validationMessage
	 * @param errorCodeMessage
	 */
	public DependencyEntityException(String parentEntity, long parentEntityId, String childEntityName,
			String validationMessage, String errorCodeMessage) {
		super(validationMessage);
		this.validationError.setCode(ErrorCodes.Dependency.getStatusCode());
		this.validationError.addArg(parentEntity);
		this.validationError.addArg(parentEntityId);
		this.validationError.addArg(childEntityName);
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
