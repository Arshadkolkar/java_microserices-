/**
 * 
 */
package com.sca.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author subhash
 *
 */
@Component
// prefix errorcode, find errorcode.* values
@ConfigurationProperties("errorcode")
public class ErrorCodeProperties {

	private String generic;
	private String invalidInput;
	private String duplicateName;
	private String dependency;
	private String unauthorized;
	private String unprocessableEntity;

	/**
	 * @return the generic
	 */
	public String getGeneric() {
		return generic;
	}

	/**
	 * @param generic the generic to set
	 */
	public void setGeneric(String generic) {
		this.generic = generic;
	}

	/**
	 * @return the invalidInput
	 */
	public String getInvalidInput() {
		return invalidInput;
	}

	/**
	 * @param invalidInput the invalidInput to set
	 */
	public void setInvalidInput(String invalidInput) {
		this.invalidInput = invalidInput;
	}

	/**
	 * @return the duplicateName
	 */
	public String getDuplicateName() {
		return duplicateName;
	}

	/**
	 * @param duplicateName the duplicateName to set
	 */
	public void setDuplicateName(String duplicateName) {
		this.duplicateName = duplicateName;
	}

	/**
	 * @return the dependency
	 */
	public String getDependency() {
		return dependency;
	}

	/**
	 * @param dependency the dependency to set
	 */
	public void setDependency(String dependency) {
		this.dependency = dependency;
	}

	/**
	 * @return the unauthorized
	 */
	public String getUnauthorized() {
		return unauthorized;
	}

	/**
	 * @param unauthorized the unauthorized to set
	 */
	public void setUnauthorized(String unauthorized) {
		this.unauthorized = unauthorized;
	}

	/**
	 * @return the unprocessableEntity
	 */
	public String getUnprocessableEntity() {
		return unprocessableEntity;
	}

	/**
	 * @param unprocessableEntity the unprocessableEntity to set
	 */
	public void setUnprocessableEntity(String unprocessableEntity) {
		this.unprocessableEntity = unprocessableEntity;
	}

}
