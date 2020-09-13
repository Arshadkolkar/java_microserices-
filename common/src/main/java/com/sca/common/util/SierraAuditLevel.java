/**
 * 
 */
package com.sca.common.util;

/**
 * 
 * @author subhash
 *
 */
public enum SierraAuditLevel {

	DEBUG(1), INFO(2), WARN(3), ERROR(4), FATAL(5);

	private final Integer auditLevelId;

	private SierraAuditLevel(Integer auditLevelId) {
		this.auditLevelId = auditLevelId;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getAuditLevelId() {
		return this.auditLevelId;
	}

}
