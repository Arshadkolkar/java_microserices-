/**
 * 
 */
package com.sca.dao.domain.common;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author subhash
 *
 */
@Entity
@Table(name = "entity_additional_info")
public class EntityAdditionalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entity_additional_info_id")
	private Integer entityAdditionalInfoId;

	@Column(name = "entity_name")
	private String entityName;

	@Column(name = "entity_reference_id")
	private Long entityReferenceId;

	@Column(name = "param_name")
	private String paramName;

	@Column(name = "param_value")
	private String paramValue;

	@Column(name = "created_by", updatable = false)
	private Long createdBy;

	@Column(name = "created_date", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
	private Calendar createdDate = null;

	public EntityAdditionalInfo() {
		super();
	}

	public EntityAdditionalInfo(String entityName, Long entityReferenceId, String paramName, String paramValue,
			Long createdBy) {
		super();
		this.entityName = entityName;
		this.entityReferenceId = entityReferenceId;
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.createdBy = createdBy;
	}

	/**
	 * @return the entityAdditionalInfoId
	 */
	public Integer getEntityAdditionalInfoId() {
		return entityAdditionalInfoId;
	}

	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * @return the entityReferenceId
	 */
	public Long getEntityReferenceId() {
		return entityReferenceId;
	}

	/**
	 * @return the paramName
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * @return the paramValue
	 */
	public String getParamValue() {
		return paramValue;
	}

	/**
	 * @param entityAdditionalInfoId the entityAdditionalInfoId to set
	 */
	public void setEntityAdditionalInfoId(Integer entityAdditionalInfoId) {
		this.entityAdditionalInfoId = entityAdditionalInfoId;
	}

	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/**
	 * @param entityReferenceId the entityReferenceId to set
	 */
	public void setEntityReferenceId(Long entityReferenceId) {
		this.entityReferenceId = entityReferenceId;
	}

	/**
	 * @param paramName the paramName to set
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * @param paramValue the paramValue to set
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	/**
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Calendar getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
