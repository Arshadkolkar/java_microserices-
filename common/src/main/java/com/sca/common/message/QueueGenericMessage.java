/**
 * 
 */
package com.sca.common.message;

import java.io.Serializable;

import com.sca.common.util.ScaService;

/**
 * 
 * @author subhash
 *
 */
public class QueueGenericMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private MessageHeader messageHeader;
	private MessageBody messageBody;

	/**
	 * @return the messageHeader
	 */
	public MessageHeader getMessageHeader() {
		return messageHeader;
	}

	/**
	 * @param messageHeader the messageHeader to set
	 */
	public void setMessageHeader(MessageHeader messageHeader) {
		this.messageHeader = messageHeader;
	}

	/**
	 * @return the messageBody
	 */
	public MessageBody getMessageBody() {
		return messageBody;
	}

	/**
	 * @param messageBody the messageBody to set
	 */
	public void setMessageBody(MessageBody messageBody) {
		this.messageBody = messageBody;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueueGenericMessage [messageHeader=").append(messageHeader).append(", messageBody=")
				.append(messageBody).append("]");
		return builder.toString();
	}

	/**
	 * 
	 * @return
	 */
	public boolean isValid() {
		if (messageHeader == null || messageBody == null) {
			return false;
		}

		// MessageHeader Validation
		if (messageHeader.getSourceApplciation() == null || messageHeader.getAction() == null) {
			return false;
		}

		// MessageBody Validation
		if (messageBody.getBodyParams() == null || messageBody.getBodyParams().isEmpty()) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getPublisherServiceId() {
		if (messageHeader != null && messageHeader.getSourceApplciation() != null
				&& !messageHeader.getSourceApplciation().trim().isEmpty()) {
			return ScaService.valueOf(messageHeader.getSourceApplciation().trim()).getServiceId();
		}

		return null;
	}

	/**
	 * 
	 * @return
	 */
	public Long getOrganizationId() {
		if (messageHeader != null && messageHeader.getOrganizationId() != null
				&& messageHeader.getOrganizationId() > 0) {
			return messageHeader.getOrganizationId();
		}

		return null;
	}

	/**
	 * 
	 * @return
	 */
	public Long getUserId() {
		if (messageHeader != null && messageHeader.getUserId() != null && messageHeader.getUserId() > 0) {
			return messageHeader.getUserId();
		}

		return null;
	}
}
