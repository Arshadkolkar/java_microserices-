/**
 * 
 */
package com.sca.common.exception;

/**
 * 
 * @author subhash
 *
 */
public enum ErrorCodes {
	
	Generic(10000), // if unknown error
	DuplicateData(10001), // data already exist
	Dependency(10002), // can't delete as some dependency
	InvalidInput(10003), // if any input is invalid
	Unauthorized(401), // if user don't have rights
	UnprocessableEntity(422);// If Unprocessable Entity
	
	// InvalidUser(402), // if user is not authenticated
	// NotFound(404), // if entity not found
	// InternalServerError(500); // unhandled exception

	private Integer statusCode;

	ErrorCodes(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * 
	 * @param statusCode
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
}
