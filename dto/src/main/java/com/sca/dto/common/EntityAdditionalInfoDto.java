package com.sca.dto.common;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EntityAdditionalInfoDto {

	private String entityName;

	private Integer entityReferenceId;

	private List<AdditionalInfoParamDto> additionalInfoParams;

	

	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * @return the entityReferenceId
	 */
	public Integer getEntityReferenceId() {
		return entityReferenceId;
	}

	/**
	 * @return the additionalInfoParams
	 */
	public List<AdditionalInfoParamDto> getAdditionalInfoParams() {
		return additionalInfoParams;
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
	public void setEntityReferenceId(Integer entityReferenceId) {
		this.entityReferenceId = entityReferenceId;
	}

	/**
	 * @param additionalInfoParams the additionalInfoParams to set
	 */
	public void setAdditionalInfoParams(List<AdditionalInfoParamDto> additionalInfoParams) {
		this.additionalInfoParams = additionalInfoParams;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
