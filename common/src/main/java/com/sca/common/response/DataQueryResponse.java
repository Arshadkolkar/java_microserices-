/**
 * 
 */
package com.sca.common.response;

/**
 * 
 * @author subhash
 *
 */
public class DataQueryResponse {

	private String fileName;
	private String emailStatus;
	private ResponseMessage dataMessage;

	/**
	 * 
	 */
	public DataQueryResponse() {
		super();
	}

	/**
	 * 
	 * @param responseMessage
	 */
	public DataQueryResponse(ResponseMessage responseMessage) {
		dataMessage = responseMessage;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the emailStatus
	 */
	public String getEmailStatus() {
		return emailStatus;
	}

	/**
	 * @param emailStatus the emailStatus to set
	 */
	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	/**
	 * @return the dataMessage
	 */
	public ResponseMessage getDataMessage() {
		return dataMessage;
	}

	/**
	 * @param dataMessage the dataMessage to set
	 */
	public void setDataMessage(ResponseMessage dataMessage) {
		this.dataMessage = dataMessage;
	}
}
