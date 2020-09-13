/**
 * 
 */
package com.sca.dao.domain.common;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author subhash
 *
 */
@MappedSuperclass
public abstract class BaseEntity {

	@Column(name = "is_active")
	private boolean isActive = true;

	//@Column(name = "created_by", insertable = false, updatable = false)
	@Column(name = "created_by")
	private Long createdBy = 1L;

	@Column(name = "updated_by")
	private Long updatedBy = 1L;

	//@Column(name = "created_date", insertable = false, updatable = false)
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
	private Calendar createdDate = null;

	//@Column(name = "updated_date", insertable = false, updatable = false)
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
	private Calendar updatedDate;

//	@Column(name = "fems_ref_id")
//	private String femsRefId;
	
	@Column(name = "entity_status_id")
	private Integer entityStatusId;
	
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
		// String createdDate = null;
		// if (this.createdDate != null) {
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd
		// HH:mm:ss");
		// createdDate = dateFormat.format(this.createdDate.getTime());
		// }

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
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

//	/**
//	 * 
//	 * @return
//	 */
//	public String getFemsRefId() {
//		return femsRefId;
//	}
//
//	/**
//	 * 
//	 * @param femsRefId
//	 */
//	public void setFemsRefId(String femsRefId) {
//		this.femsRefId = femsRefId;
//	}

	/**
	 * 
	 * @return
	 */
	public Integer getEntityStatusId() {
		return entityStatusId;
	}

	/**
	 * 
	 * @param entityStatusId
	 */
	public void setEntityStatusId(Integer entityStatusId) {
		this.entityStatusId = entityStatusId;
	}
}
