/**
 * 
 */
package com.sca.common.exception;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.sca.common.logger.DiagnosticLogger;
import com.sca.common.properties.ErrorCodeProperties;

/**
 * 
 * @author subhash
 *
 */
@Component
public class ExceptionUtil {

	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(ExceptionUtil.class);

	@Autowired
	private ErrorCodeProperties errorCodeProperties;

	/**
	 * 
	 * Check the exception type and throw it with code
	 * 
	 * @param exception
	 * @param message
	 * @throws GenericException
	 */
	public void processException(Exception exception, String message) throws GenericException {

		logger.error(exception);

		if (exception instanceof InvalidInputException) {
			throw new InvalidInputException(exception.getMessage(), message, errorCodeProperties.getInvalidInput());
		} else if (exception instanceof UnprocessableEntityException) {
			throw new UnprocessableEntityException(exception.getMessage(), message,
					errorCodeProperties.getUnprocessableEntity());
		} else if (exception instanceof DependencyEntityException) {
			throw (DependencyEntityException) exception;
		} else if (exception instanceof DuplicateEntityException) {
			throw (DuplicateEntityException) exception;
		} else if (exception instanceof UnauthorizedException) {
			throw new UnauthorizedException(exception.getMessage(), message, errorCodeProperties.getUnauthorized());
		} else if (exception instanceof DataAccessException) {
			DataAccessException dataEx = (DataAccessException) exception;
			if (dataEx.getRootCause() instanceof SQLException) {
				SQLException sqlEx = (SQLException) dataEx.getRootCause();
				throw new GenericException(sqlEx.getMessage(), message, errorCodeProperties.getGeneric());
			} else {
				throw new GenericException(exception.getMessage(), message, errorCodeProperties.getGeneric());
			}
		} else {
			throw new GenericException(exception.getMessage(), message, errorCodeProperties.getGeneric());
		}
	}

}
