/**
 * 
 */
package com.sca.common.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 * @author subhash
 *
 */
@JacksonXmlRootElement(localName = "response")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ValidationResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	protected boolean success = true;
	private Object message;
	private Map<String, Object> additionalData;

	@JacksonXmlElementWrapper(localName = "errors")
	@JacksonXmlProperty(localName = "error")
	@JsonProperty("errors")
	private List<ValidationError> validationErrorList;

	/**
	 * 
	 * @return
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * 
	 * @param success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public Object getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(Object message) {
		this.message = message;
	}

	/**
	 * @return the additionalData
	 */
	public Map<String, Object> getAdditionalData() {
		return additionalData;
	}

	/**
	 * @param additionalData the additionalData to set
	 */
	public void setAdditionalData(Map<String, Object> additionalData) {
		this.additionalData = additionalData;
	}

	/**
	 * 
	 * @param validationErrorList
	 */
	public void setValidationErrorList(List<ValidationError> validationErrorList) {

		if ((validationErrorList != null) && (validationErrorList.size() > 0))
			success = false;

		this.validationErrorList = validationErrorList;
	}

	/**
	 * 
	 * @param validationError
	 */
	public void addValidatorError(ValidationError validationError) {

		if (validationErrorList == null) {
			validationErrorList = new ArrayList<ValidationError>();
		}

		if (validationError != null) {
			success = false;
			validationErrorList.add(validationError);
		}
	}

	/**
	 * 
	 */
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
