/**
 * 
 */
package com.sca.common.util;

/**
 * 
 * @author subhash
 *
 */
public enum ScaService {

	sca_eureka_service(1), sca_zuul_service(2), sca_audit_service(3), sca_security_service(4), sca_scheduler_service(5),
	sca_file_exchange_service(6), sca_project_service(7), sca_order_service(8), sca_notification_service(9),
	sca_payment_service(10), sca_location_service(11);

	private final int serviceId;

	private ScaService(int serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * 
	 * @return
	 */
	public int getServiceId() {
		return this.serviceId;
	}

}
