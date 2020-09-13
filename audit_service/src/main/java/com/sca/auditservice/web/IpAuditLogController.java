/**
 * This is the controller class that provides REST APIs for managing IP Audit log
 */
package com.sca.auditservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sca.auditservice.service.IpAuditLogService;
import com.sca.auditservice.util.Constants;
import com.sca.common.exception.ExceptionUtil;
import com.sca.common.exception.GenericException;
import com.sca.common.response.ValidationResponse;

/**
 * 
 * The <code>IpAuditLogController</code> class is used for defining the CRUD
 * operations for IpAuditLog entity, which includes parameter types and response
 * messages for each operation.
 * 
 * @author subhash
 *
 */
@RestController
@RequestMapping(Constants.IP_AUDIT_LOGS_REST_URL)
public class IpAuditLogController {

//	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(IpAuditLogController.class);

	@Autowired
	private IpAuditLogService ipAuditLogService;

	@Autowired
	private ExceptionUtil exceptionUtil;

	/**
	 * 
	 * @param organizationApiKey
	 * @param accessToken
	 * @param clientIpAddress
	 * @return
	 * @throws GenericException
	 */
	@GetMapping
	public ResponseEntity<ValidationResponse> getIpAuditLog(
			@RequestHeader(value = "organization-api-key", required = true) String organizationApiKey,
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestHeader(value = "client-ip-address", required = true) String clientIpAddress)
			throws GenericException {
		ValidationResponse response = null;

		try {
			response = ipAuditLogService.getIpAuditLog(organizationApiKey, accessToken, clientIpAddress);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get the IpAuditLog ");
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param organizationApiKey
	 * @param accessToken
	 * @param clientIpAddress
	 * @return
	 * @throws GenericException
	 */
	@GetMapping(value = "/client-ip-address")
	public ResponseEntity<ValidationResponse> getIpAuditLogByClientIpAddress(
			@RequestHeader(value = "organization-api-key", required = true) String organizationApiKey,
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "client-ip-address", required = true) String clientIpAddress)
			throws GenericException {

		ValidationResponse response = null;

		try {
			response = ipAuditLogService.getIpAuditLogByClientIpAddress(organizationApiKey, accessToken,
					clientIpAddress);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get the IpAuditLog ");
		}

		return ResponseEntity.ok(response);
	}
	
	
	/**
	 * 
	 * @return
	 * @throws GenericException
	 */
	@GetMapping(value = "/check-service")
	public ResponseEntity<ValidationResponse> checkService()
			throws GenericException {

		ValidationResponse response = new ValidationResponse();

		try {
			response.setMessage("working fine !!");
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get the IpAuditLog ");
		}

		return ResponseEntity.ok(response);
	}

}
