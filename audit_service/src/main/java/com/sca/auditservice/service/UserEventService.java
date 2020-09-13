/**
 * This is the main interface for Audit service.
 */
package com.sca.auditservice.service;

import com.sca.dto.audit.UserEventDto;

/**
 * 
 * @author subhash
 *
 */
public interface UserEventService {

	/**
	 * 
	 * @param organizationApiKey
	 * @param accessToken
	 * @param userEventDto
	 * @throws Exception
	 */
	void saveUserEvent(String organizationApiKey, String accessToken, UserEventDto userEventDto) throws Exception;

	/**
	 * 
	 * @param userEventDto
	 */
	void saveUserEventForApiReqs(UserEventDto userEventDto);

}
