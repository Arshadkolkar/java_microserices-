/**
 * 
 */
package com.sca.dao.domain.audit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author subhash
 *
 */
@Entity
@Table(name = "user_event_param")
public class UserEventParam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_event_param_id")
	private Long userEventParamId;

	@Column(name = "user_event_param_name")
	private String userEventParamName;

	@Column(name = "user_event_param_value")
	private String userEventParamValue;

	@Column(name = "user_event_id")
	private Long userEventId;

	/**
	 * @return the userEventParamId
	 */
	public Long getUserEventParamId() {
		return userEventParamId;
	}

	/**
	 * @param userEventParamId the userEventParamId to set
	 */
	public void setUserEventParamId(Long userEventParamId) {
		this.userEventParamId = userEventParamId;
	}

	/**
	 * @return the userEventParamName
	 */
	public String getUserEventParamName() {
		return userEventParamName;
	}

	/**
	 * @param userEventParamName the userEventParamName to set
	 */
	public void setUserEventParamName(String userEventParamName) {
		this.userEventParamName = userEventParamName;
	}

	/**
	 * @return the userEventParamValue
	 */
	public String getUserEventParamValue() {
		return userEventParamValue;
	}

	/**
	 * @param userEventParamValue the userEventParamValue to set
	 */
	public void setUserEventParamValue(String userEventParamValue) {
		this.userEventParamValue = userEventParamValue;
	}

	/**
	 * @return the userEventId
	 */
	public Long getUserEventId() {
		return userEventId;
	}

	/**
	 * @param userEventId the userEventId to set
	 */
	public void setUserEventId(Long userEventId) {
		this.userEventId = userEventId;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
