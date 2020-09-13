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

import com.sca.dao.domain.common.BaseEntity;

/**
 * 
 * @author subhash
 *
 */
@Entity
@Table(name = "user_event_type")
public class UserEventType extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_event_type_id")
	private Integer userEventTypeId;

	@Column(name = "user_event_type_internal_name")
	private String userEventTypeInternalName;

	@Column(name = "user_event_type_external_name")
	private String userEventTypeExternalName;

	/**
	 * @return the userEventTypeId
	 */
	public Integer getUserEventTypeId() {
		return userEventTypeId;
	}

	/**
	 * @param userEventTypeId the userEventTypeId to set
	 */
	public void setUserEventTypeId(Integer userEventTypeId) {
		this.userEventTypeId = userEventTypeId;
	}

	/**
	 * @return the userEventTypeInternalName
	 */
	public String getUserEventTypeInternalName() {
		return userEventTypeInternalName;
	}

	/**
	 * @param userEventTypeInternalName the userEventTypeInternalName to set
	 */
	public void setUserEventTypeInternalName(String userEventTypeInternalName) {
		this.userEventTypeInternalName = userEventTypeInternalName;
	}

	/**
	 * @return the userEventTypeExternalName
	 */
	public String getUserEventTypeExternalName() {
		return userEventTypeExternalName;
	}

	/**
	 * @param userEventTypeExternalName the userEventTypeExternalName to set
	 */
	public void setUserEventTypeExternalName(String userEventTypeExternalName) {
		this.userEventTypeExternalName = userEventTypeExternalName;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
