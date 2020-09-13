package com.sca.dto.common;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TrackCustomerEngagementDto {

	private Long userId;
	private String customerName;
	private String customerEmail;
	private String customerPhone;
	private List<UserPropertyInfoDto> userProperties;
//	private Integer application;

	public TrackCustomerEngagementDto() {
		super();
	}

	public TrackCustomerEngagementDto(Long userId, String customerName, String customerEmail, String customerPhone) {
		super();
		this.userId = userId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the customerPhone
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}

	/**
	 * @param customerPhone the customerPhone to set
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the userProperties
	 */
	public List<UserPropertyInfoDto> getUserProperties() {
		return userProperties;
	}

	/**
	 * @param userProperties the userProperties to set
	 */
	public void setUserProperties(List<UserPropertyInfoDto> userProperties) {
		this.userProperties = userProperties;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
