package com.sca.dto.common;

import com.sca.dao.domain.common.EntityAdditionalInfo;

public class AdditionalInfoParamDto {
	private String paramName;

	private String paramValue;

	public AdditionalInfoParamDto(EntityAdditionalInfo entityAdditionalInfo) {
		super();
		this.paramName = entityAdditionalInfo.getParamName();
		this.paramValue = entityAdditionalInfo.getParamValue();
	}

	public AdditionalInfoParamDto() {
		super();
		// TODO Auto-generated constructor stub
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

}
