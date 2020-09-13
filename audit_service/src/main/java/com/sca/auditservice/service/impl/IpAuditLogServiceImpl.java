/**
 *  This is the implementation class for of IPAuditLogService
 */
package com.sca.auditservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.auditservice.service.AuditCommonService;
import com.sca.auditservice.service.IpAuditLogService;
import com.sca.common.response.ValidationResponse;
import com.sca.common.util.IpStackUtil;
import com.sca.dao.domain.audit.IpAuditLog;
import com.sca.dao.repository.audit.IpAuditLogRepository;
import com.sca.dao.util.CalendarUtil;
import com.sca.dto.audit.IpStackResponseDto;

/**
 * 
 * @author subhash
 *
 */
@Service
@Transactional
public class IpAuditLogServiceImpl extends AuditCommonService implements IpAuditLogService {

//	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(IpAuditLogServiceImpl.class);

	@Autowired
	private IpAuditLogRepository ipAuditLogRepository;

	@Autowired
	private IpStackUtil ipStackUtil;

	/**
	 * 
	 */
	@Override
	public ValidationResponse getIpAuditLog(String organizationApiKey, String accessToken, String clientIpAddress)
			throws Exception {
		/*
		 * OrganizationUserDto organizationUserDto =
		 * validateUserByAccessTokenAndOrganization(accessToken, organizationApiKey);
		 * 
		 * IpAuditLog ipAuditLog =
		 * getIpAuditLog(organizationUserDto.getUser().getUserId(), clientIpAddress);
		 * ValidationResponse validationResponse = new ValidationResponse();
		 * validationResponse.setMessage(ipAuditLog);
		 * 
		 * return validationResponse;
		 */
		return null;
	}

	private IpAuditLog getIpAuditLog(Long userId, String clientIpAddress) {
		IpAuditLog ipAuditLog = null;
		Pageable pageRequest = PageRequest.of(0, 1);
		List<IpAuditLog> ipAuditLogs = null;
		if (userId == null) {
			ipAuditLogs = ipAuditLogRepository.retrieveByClientIpAddress(clientIpAddress, pageRequest);
		} else {
			ipAuditLogs = ipAuditLogRepository.retrieveByParams(clientIpAddress, userId, pageRequest);
		}
		if (ipAuditLogs == null || ipAuditLogs.isEmpty()) {
			ipAuditLog = buildIpAuditLog(clientIpAddress, userId);
		} else {
			ipAuditLog = ipAuditLogs.get(0);
		}

		return ipAuditLog;
	}

	private IpAuditLog buildIpAuditLog(String clientIpAddress, Long userId) {
		IpStackResponseDto ipStackResponseDto = ipStackUtil.setClientIpDetails(clientIpAddress);

		IpAuditLog ipAuditLog = new IpAuditLog();
		ipAuditLog.setClientIpAddress(clientIpAddress);
		ipAuditLog.setClientCity(ipStackResponseDto.getCity());
		ipAuditLog.setClientState(ipStackResponseDto.getRegion_name());
		ipAuditLog.setClientZipCode(ipStackResponseDto.getZip());
		ipAuditLog.setClientCountryCode(ipStackResponseDto.getCountry_code());
		ipAuditLog.setClientLatitude(ipStackResponseDto.getLatitude());
		ipAuditLog.setClientLongitude(ipStackResponseDto.getLongitude());
		ipAuditLog.setClientIpLookupResponse(ipStackResponseDto.getClientIpLookupResponse());
		ipAuditLog.setCreatedBy(userId);
		ipAuditLog.setCreatedDate(CalendarUtil.getCurrentTimeStamp());
		ipAuditLogRepository.save(ipAuditLog);

		return ipAuditLog;
	}

	/**
	 * 
	 */
	@Override
	public ValidationResponse getIpAuditLogByClientIpAddress(String organizationApiKey, String accessToken,
			String clientIpAddress) throws Exception {

		/*
		 * validateUserByAccessTokenAndOrganization(accessToken, organizationApiKey);
		 * 
		 * List<IpAuditLog> ipAuditLogs =
		 * getIpAuditLogByclientIpAddress(clientIpAddress); UserIdIpAuditLogDto
		 * userIdIpAuditLogDto = new UserIdIpAuditLogDto();
		 * userIdIpAuditLogDto.setUserId(ipAuditLogs.stream().map(IpAuditLog::
		 * getCreatedBy).collect(Collectors.toList()));
		 * userIdIpAuditLogDto.setClientIpAddress(clientIpAddress); ValidationResponse
		 * validationResponse = new ValidationResponse();
		 * validationResponse.setMessage(userIdIpAuditLogDto);
		 * 
		 * return validationResponse;
		 */
		return null;
	}

	private List<IpAuditLog> getIpAuditLogByclientIpAddress(String clientIpAddress) {
		return ipAuditLogRepository.retrieveByClientIpAddressAndDate(clientIpAddress);
	}

}
