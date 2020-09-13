/**
 * 
 */
package com.sca.common.mail;

/**
 * 
 * @author subhash
 *
 */
public class MailAttachment {
	
	private String attachmentName;
	private String attachmentFile;
	private String contentType;

	/**
	 * 
	 */
	public MailAttachment() {

	}

	/**
	 * 
	 * @param attachmentName
	 * @param attachmentFile
	 */
	public MailAttachment(String attachmentName, String attachmentFile) {
		super();
		this.attachmentName = attachmentName;
		this.attachmentFile = attachmentFile;
	}

	/**
	 * @return the attachmentName
	 */
	public String getAttachmentName() {
		return attachmentName;
	}

	/**
	 * @param attachmentName
	 *            the attachmentName to set
	 */
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	/**
	 * @return the attachmentFile
	 */
	public String getAttachmentFile() {
		return attachmentFile;
	}

	/**
	 * @param attachmentFile 
	 *            the attachmentFile to set
	 */
	public void setAttachmentFile(String attachmentFile) {
		this.attachmentFile = attachmentFile;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
