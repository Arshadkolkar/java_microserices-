/**
 * 
 */
package com.sca.common.mail;

/**
 * 
 * @author subhash
 *
 */
public enum MimeType {

	png("image/png"), jpg("image/jpeg");

	/**
	 * 
	 */
	public String contentType;

	/**
	 * 
	 * @param contentType
	 */
	MimeType(String contentType) {

		this.contentType = contentType;
	}

}
