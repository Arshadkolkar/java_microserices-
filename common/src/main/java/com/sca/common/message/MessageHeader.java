/**
 * 
 */
package com.sca.common.message;

import java.util.Calendar;

/**
 * 
 * @author subhash
 *
 */
public class MessageHeader {

	private String sourceApplciation;
	private Calendar requestedOn;
	private Long organizationId;
	private Long userId;
	private Integer application;
	private MessageAction action;

	/**
	 * @return the sourceApplciation
	 */
	public String getSourceApplciation() {
		return sourceApplciation;
	}

	/**
	 * @param sourceApplciation the sourceApplciation to set
	 */
	public void setSourceApplciation(String sourceApplciation) {
		this.sourceApplciation = sourceApplciation;
	}

	/**
	 * @return the requestedOn
	 */
	public Calendar getRequestedOn() {
		return requestedOn;
	}

	/**
	 * @param requestedOn the requestedOn to set
	 */
	public void setRequestedOn(Calendar requestedOn) {
		this.requestedOn = requestedOn;
	}

	/**
	 * @return the organizationId
	 */
	public Long getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
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
	 * @return the application
	 */
	public Integer getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(Integer application) {
		this.application = application;
	}

	/**
	 * @return the action
	 */
	public MessageAction getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(MessageAction action) {
		this.action = action;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageHeader [sourceApplciation=").append(sourceApplciation).append(", requestedOn=")
				.append(requestedOn).append(", action=").append(action).append("]");
		return builder.toString();
	}

}
