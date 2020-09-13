/**
 * 
 */
package com.sca.common.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 
 * @author subhash
 *
 */
public class ResponseMessage {
	
	private int totalPages;
	private long totalRecordCount;
	private int pageNumber = 0;
	private int pageCount = 0;
	@JacksonXmlElementWrapper(localName = "records")
	@JacksonXmlProperty(localName = "record")
	@JsonProperty("records")
	private List<Object> records;

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages
	 *            the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the totalRecordCount
	 */
	public long getTotalRecordCount() {
		return totalRecordCount;
	}

	/**
	 * @param totalRecordCount
	 *            the totalRecordCount to set
	 */
	public void setTotalRecordCount(long totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	/**
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber
	 *            the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount
	 *            the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return the records
	 */
	public List<Object> getRecords() {
		return records;
	}

	/**
	 * @param records
	 *            the records to set
	 */
	public void setRecords(List<Object> records) {
		this.records = records;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseMessage [totalRecordCount=").append(totalRecordCount).append(", pageNumber=")
				.append(pageNumber).append(", pageCount=").append(pageCount).append(", records=").append(records)
				.append("]");
		return builder.toString();
	}

}
