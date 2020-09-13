/**
 * 
 */
package com.sca.common.mail;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author subhash
 *
 */
public class MailMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MailParams mailParams;
	private Map<String, Object> messageVariables;
	private List<MailInlineContent> inlineContents;
	private List<MailAttachment> mailAttachments;
	private Long userId;

	/**
	 * 
	 */
	public MailMessage() {

	}

	/**
	 * 
	 * @param mailParams
	 * @param messageVariables
	 * @param mailAttachments
	 * @param userId
	 */
	public MailMessage(MailParams mailParams, Map<String, Object> messageVariables,
			List<MailAttachment> mailAttachments, Long userId) {
		this.mailParams = mailParams;
		this.messageVariables = messageVariables;
		this.mailAttachments = mailAttachments;
		this.userId = userId;
	}

	/**
	 * @return the mailParams
	 */
	public MailParams getMailParams() {
		return mailParams;
	}

	/**
	 * @param mailParams the mailParams to set
	 */
	public void setMailParams(MailParams mailParams) {
		this.mailParams = mailParams;
	}

	/**
	 * @return the messageVariables
	 */
	public Map<String, Object> getMessageVariables() {
		return messageVariables;
	}

	/**
	 * @param messageVariables the messageVariables to set
	 */
	public void setMessageVariables(Map<String, Object> messageVariables) {
		this.messageVariables = messageVariables;
	}

	/**
	 * @return the inlineContents
	 */
	public List<MailInlineContent> getInlineContents() {
		return inlineContents;
	}

	/**
	 * @param inlineContents the inlineContents to set
	 */
	public void setInlineContents(List<MailInlineContent> inlineContents) {
		this.inlineContents = inlineContents;
	}

	/**
	 * @return the mailAttachments
	 */
	public List<MailAttachment> getMailAttachments() {
		return mailAttachments;
	}

	/**
	 * @param mailAttachments the mailAttachments to set
	 */
	public void setMailAttachments(List<MailAttachment> mailAttachments) {
		this.mailAttachments = mailAttachments;
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
	 * 
	 */
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.setExcludeFieldNames("inlineContents", "mailAttachments", "messageVariables").toString();
	}
}
