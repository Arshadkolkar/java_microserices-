/**
 * 
 */
package com.sca.common.message;

import java.util.List;

/**
 * 
 * @author subhash
 *
 */
public class MessageBody {

	private List<MessageBodyParam> bodyParams;

	/**
	 * @return the bodyParams
	 */
	public List<MessageBodyParam> getBodyParams() {
		return bodyParams;
	}

	/**
	 * @param bodyParams the bodyParams to set
	 */
	public void setBodyParams(List<MessageBodyParam> bodyParams) {
		this.bodyParams = bodyParams;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageBody [bodyParams=").append(bodyParams).append("]");
		return builder.toString();
	}

}
