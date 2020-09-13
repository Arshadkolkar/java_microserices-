/**
 * 
 */
package com.sca.common.mail;

/**
 * 
 * @author subhash
 *
 */
public class MailParams {

	private String from;
	private String fromName;
	private String to;
	private String subject;
	private String template;
	private String language;
	private String text = null;
	private boolean isHtmlMessage = true;

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the fromName
	 */
	public String getFromName() {
		return fromName;
	}

	/**
	 * @param fromName the fromName to set
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param template the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the isHtmlMessage
	 */
	public boolean getIsHtmlMessage() {
		return isHtmlMessage;
	}

	/**
	 * @param isHtmlMessage the isHtmlMessage to set
	 */
	public void setHtmlMessage(boolean isHtmlMessage) {
		this.isHtmlMessage = isHtmlMessage;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "MailParams [from=" + from + ", fromName=" + fromName + ", to=" + to + ", subject=" + subject
				+ ", template=" + template + ", language=" + language + ", text=" + text + ", isHtmlMessage="
				+ isHtmlMessage + "]";
	}

}
