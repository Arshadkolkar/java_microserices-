/**
 * This is the default exception handler for Sierra
 */
package com.sca.common.exception;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sca.common.response.ValidationError;
import com.sca.common.response.ValidationResponse;

/**
 * 
 * @author subhash
 *
 */
@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.mvc.method.annotation.
	 * ResponseEntityExceptionHandler#handleMethodArgumentNotValid(org.
	 * springframework.web.bind.MethodArgumentNotValidException,
	 * org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus,
	 * org.springframework.web.context.request.WebRequest)
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ValidationResponse response = new ValidationResponse();
		response.setSuccess(false);
		response.setMessage("Invalid inputs");
		BindingResult result = ex.getBindingResult();
		for (FieldError fieldError : result.getFieldErrors()) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage(fieldError.getDefaultMessage());
			validationError.setArgList(Arrays.asList(fieldError.getField()));
			response.addValidatorError(validationError);
		}

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param invalidInputException
	 * @return
	 */
	@ExceptionHandler(InvalidInputException.class)
	public final ResponseEntity<ValidationResponse> invalidDataError(InvalidInputException invalidInputException) {
		ValidationResponse validationResponse = invalidInputException.validationResponse;

		return new ResponseEntity<ValidationResponse>(validationResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = MultipartException.class)
	public ResponseEntity<ValidationResponse> handleMultipartException(MultipartException ex,
			HttpServletRequest request) {
		ValidationResponse response = new ValidationResponse();
		response.setSuccess(false);
		response.setMessage(ex.getMessage());

		return new ResponseEntity<ValidationResponse>(response, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param duplicateEntityException
	 * @return
	 */
	@ExceptionHandler(DuplicateEntityException.class)
	public final ResponseEntity<ValidationResponse> duplicateDataError(
			DuplicateEntityException duplicateEntityException) {
		ValidationResponse validationResponse = duplicateEntityException.validationResponse;

		return new ResponseEntity<ValidationResponse>(validationResponse, HttpStatus.MULTIPLE_CHOICES);
	}

	/**
	 * 
	 * @param dependencyEntityException
	 * @return
	 */
	@ExceptionHandler(DependencyEntityException.class)
	public final ResponseEntity<ValidationResponse> dependencyError(
			DependencyEntityException dependencyEntityException) {
		ValidationResponse validationResponse = dependencyEntityException.validationResponse;

		return new ResponseEntity<ValidationResponse>(validationResponse, HttpStatus.FAILED_DEPENDENCY);
	}

	/**
	 * 
	 * @param unauthorizedException
	 * @return
	 */
	@ExceptionHandler(UnauthorizedException.class)
	public final ResponseEntity<ValidationResponse> unauthorizedError(UnauthorizedException unauthorizedException) {
		ValidationResponse validationResponse = unauthorizedException.validationResponse;

		return new ResponseEntity<ValidationResponse>(validationResponse, HttpStatus.FORBIDDEN);
	}

	/**
	 * 
	 * @param unauthorizedException
	 * @return
	 */
	@ExceptionHandler(UnprocessableEntityException.class)
	public final ResponseEntity<ValidationResponse> unprocessableEntityError(UnprocessableEntityException exception) {
		ValidationResponse validationResponse = exception.validationResponse;

		return new ResponseEntity<ValidationResponse>(validationResponse, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	/**
	 * 
	 * @param genericException
	 * @return
	 */
	@ExceptionHandler(GenericException.class)
	public final ResponseEntity<ValidationResponse> someError(GenericException genericException) {
		ValidationResponse validationResponse = genericException.validationResponse;

		return new ResponseEntity<ValidationResponse>(validationResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
