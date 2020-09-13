/**
 * 
 */
package com.sca.common.util;

/**
 * 
 * @author subhash
 *
 */
public enum SierraRole {
	anonymous(1L), standard(2L), professional(3L), administrator(4L);

	public final Long roleId;

	private SierraRole(Long roleId) {
		this.roleId = roleId;
	}

}
