/**
 * 
 */
package com.sca.dao.domain.audit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull; 

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author subhash
 *
 */
@Entity
@Table(name = "audit_level")
public class AuditLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "audit_level_id")
	private Integer auditLevelId;

	@Column(name = "audit_level_name", length = 50)
	@NotNull
	private String auditLevelName;

	@Column(name = "audit_level_desc", length = 255)
	private String auditLevelDesc;

	public AuditLevel() {
	}

	public AuditLevel(Integer auditLevelId) {
		this.auditLevelId = auditLevelId;
	}

	/**
	 * @return the auditLevelId
	 */
	public Integer getAuditLevelId() {
		return auditLevelId;
	}

	/**
	 * @param auditLevelId the auditLevelId to set
	 */
	public void setAuditLevelId(Integer auditLevelId) {
		this.auditLevelId = auditLevelId;
	}

	/**
	 * @return the auditLevelName
	 */
	public String getAuditLevelName() {
		return auditLevelName;
	}

	/**
	 * @param auditLevelName the auditLevelName to set
	 */
	public void setAuditLevelName(String auditLevelName) {
		this.auditLevelName = auditLevelName;
	}

	/**
	 * @return the auditLevelDesc
	 */
	public String getAuditLevelDesc() {
		return auditLevelDesc;
	}

	/**
	 * @param auditLevelDesc the auditLevelDesc to set
	 */
	public void setAuditLevelDesc(String auditLevelDesc) {
		this.auditLevelDesc = auditLevelDesc;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}

}
