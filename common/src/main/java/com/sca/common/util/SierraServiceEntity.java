/**
 * 
 */
package com.sca.common.util;

/**
 * 
 * @author subhash
 *
 */
public enum SierraServiceEntity {
	
	PROJECT_SERVICE(1);

	private final int serviceEntityId;

	private SierraServiceEntity(int serviceEntityId) {
		this.serviceEntityId = serviceEntityId;
	}

	public int getServiceEntityId() {
		return this.serviceEntityId;
	}

}
