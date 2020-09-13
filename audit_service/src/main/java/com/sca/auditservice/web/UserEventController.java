/**
 * This is the controller class that provides REST APIs for managing Audit Log
 */
package com.sca.auditservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sca.auditservice.service.UserEventService;
import com.sca.auditservice.util.Constants;
import com.sca.common.exception.ExceptionUtil;
import com.sca.common.exception.GenericException;
import com.sca.common.response.ValidationResponse;
import com.sca.dao.util.CalendarUtil;
import com.sca.dto.audit.UserEventDto;

/**
 * 
 * The <code>UserEventController</code> class is used for defining the CRUD
 * operations for UserEvent entity, which includes parameter types and response
 * messages for each operation.
 * 
 * @author subhash
 * 
 */
@RestController
@RequestMapping(Constants.USER_EVENTS_REST_URL)
public class UserEventController {

//	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(UserEventController.class);

	@Autowired
	private UserEventService userEventService;

	@Autowired
	private ExceptionUtil exceptionUtil;

	/**
	 * 
	 * @param organizationApiKey
	 * @param accessToken
	 * @param userEventDto
	 * @return
	 * @throws GenericException
	 */
	@PostMapping
	public ResponseEntity<ValidationResponse> saveUserEvent(
			@RequestHeader(value = "organization-api-key", required = true) String organizationApiKey,
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestBody UserEventDto userEventDto) throws GenericException {
		ValidationResponse response = null;

		try {
			if (userEventDto.getCreatedDate() == null) {
				userEventDto.setCreatedDate(CalendarUtil.getCurrentTimeStamp());
			}
			if (userEventDto.getUpdatedDate() == null) {
				userEventDto.setUpdatedDate(CalendarUtil.getCurrentTimeStamp());
			}
			userEventService.saveUserEvent(organizationApiKey, accessToken, userEventDto);

			response = new ValidationResponse();
			response.setMessage("UserEvent saved successfully!");
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to save the UserEvent ");
		}

		return ResponseEntity.ok(response);
	}

}
