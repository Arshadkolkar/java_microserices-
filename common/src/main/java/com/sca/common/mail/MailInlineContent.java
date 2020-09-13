/**
 * 
 */
package com.sca.common.mail;

/**
 * 
 * @author subhash
 *
 */
public class MailInlineContent {

	private String contentId;
	private String contentSource;
	private String contentType;

	/**
	 * 
	 */
	public MailInlineContent() {

	}

	/**
	 * 
	 * @param contentId
	 * @param contentSource
	 * @param contentType
	 */
	public MailInlineContent(String contentId, String contentSource, String contentType) {
		this.contentId = contentId;
		this.contentSource = contentSource;
		this.contentType = contentType;
	}

	/**
	 * @return the contentId
	 */
	public String getContentId() {
		return contentId;
	}

	/**
	 * @param contentId the contentId to set
	 */
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	/**
	 * @return the contentSource
	 */
	public String getContentSource() {
		return contentSource;
	}

	/**
	 * @param contentSource the contentSource to set
	 */
	public void setContentSource(String contentSource) {
		this.contentSource = contentSource;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	// /**
	// * @return the contentElementType
	// */
	// public ContentElementType getContentElementType() {
	// return contentElementType;
	// }
	//
	// /**
	// * @param contentElementType
	// * the contentElementType to set
	// */
	// public void setContentElementType(ContentElementType contentElementType)
	// {
	// this.contentElementType = contentElementType;
	// }

}
