/**
 * This is the class to audit IP address of clients
 */
package com.sca.auditservice.service;

import com.sca.common.response.ValidationResponse;

/**
 * 
 * @author subhash
 *
 */
public interface IpAuditLogService {

	/**
	 * 
	 * @param organizationApiKey
	 * @param accessToken
	 * @param clientIpAddress
	 * @return
	 * @throws Exception
	 */
	ValidationResponse getIpAuditLog(String organizationApiKey, String accessToken, String clientIpAddress)
			throws Exception;

	/**
	 * 
	 * @param organizationApiKey
	 * @param accessToken
	 * @param clientIpAddress
	 * @return
	 * @throws Exception
	 */
	ValidationResponse getIpAuditLogByClientIpAddress(String organizationApiKey, String accessToken,
			String clientIpAddress) throws Exception;

}
