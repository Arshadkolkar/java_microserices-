/**
 * 
 */
package com.sca.dto.common;

import java.util.Calendar;


public abstract class BaseEntityDto {

	private boolean isActive = true;

	private Long createdBy = 1L;

	private Long updatedBy = 1L;

	private Calendar createdDate = null;

	private Calendar updatedDate;
	
	private String femsRefId;
	
	private Integer entityStatusd;

	
	public String getFemsRefId() {
		return femsRefId;
	}

	public Integer getEntityStatusd() {
		return entityStatusd;
	}

	public void setFemsRefId(String femsRefId) {
		this.femsRefId = femsRefId;
	}

	public void setEntityStatusd(Integer entityStatusd) {
		this.entityStatusd = entityStatusd;
	}
	/**
	 * @return the isActive
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public Long getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the createdDate
	 */
	public Calendar getCreatedDate() {
//		String createdDate = null;
//		if (this.createdDate != null) {
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			createdDate = dateFormat.format(this.createdDate.getTime());
//		}

		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedDate
	 */
	public Calendar getUpdatedDate() {
//		String updatedDate = null;
//		if (this.updatedDate != null) {
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			updatedDate = dateFormat.format(this.updatedDate.getTime());
//		}

		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	

}
