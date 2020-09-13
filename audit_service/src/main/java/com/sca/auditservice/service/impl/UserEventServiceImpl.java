/**
 * This is the main implementation class of Audit service.
 */
package com.sca.auditservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.auditservice.service.AuditCommonService;
import com.sca.auditservice.service.UserEventService;
import com.sca.common.util.IpStackUtil;
import com.sca.dao.domain.audit.IpAuditLog;
import com.sca.dao.domain.audit.UserEvent;
import com.sca.dao.domain.audit.UserEventParam;
import com.sca.dao.domain.audit.UserEventType;
import com.sca.dao.repository.audit.IpAuditLogRepository;
import com.sca.dao.repository.audit.UserEventParamRepository;
import com.sca.dao.repository.audit.UserEventRepository;
import com.sca.dao.repository.audit.UserEventTypeRepository;
import com.sca.dao.util.CalendarUtil;
import com.sca.dto.audit.UserEventDto;

/**
 * 
 * @author subhash
 *
 */
@Service
@Transactional
public class UserEventServiceImpl extends AuditCommonService implements UserEventService {

//	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(UserEventServiceImpl.class);

	@Autowired
	private UserEventRepository userEventRepository;

	@Autowired
	private UserEventTypeRepository userEventTypeRepository;

	@Autowired
	private UserEventParamRepository userEventParamRepository;

	@Autowired
	private IpAuditLogRepository ipAuditLogRepository;

	@Autowired
	private IpStackUtil ipStackUtil;

	/**
	 * 
	 */
	@Override
	public void saveUserEvent(String organizationApiKey, String accessToken, UserEventDto userEventDto)
			throws Exception {

		if (userEventDto.getUserEventTypeId() == null || userEventDto.getUserEventTypeId() <= 0) {
			if (userEventDto.getUserEventTypeName() != null && !userEventDto.getUserEventTypeName().isEmpty()) {
				UserEventType userEventType = userEventTypeRepository
						.findByUserEventTypeExternalName(userEventDto.getUserEventTypeName());
				if (userEventType == null) {
					userEventType = createUserEventType(userEventDto, (long) 1);
				}
				userEventDto.setUserEventTypeId(userEventType.getUserEventTypeId());
			}
		}

		IpAuditLog ipAuditLog = getIpAuditLog(userEventDto, (long) 1);

		UserEvent userEvent = createUserEvent(userEventDto, (long) 1, ipAuditLog);
		if (userEventDto.getUserEventParams() != null && !userEventDto.getUserEventParams().isEmpty()) {
			createUserEventParams(userEvent.getUserEventId(), userEventDto.getUserEventParams());
		}

	}

	private IpAuditLog getIpAuditLog(UserEventDto userEventDto, Long userId) {
		IpAuditLog ipAuditLog = null;
		if (userEventDto.getClientIpAddress() != null && !userEventDto.getClientIpAddress().trim().isEmpty()) {
			Pageable pageRequest = PageRequest.of(0, 1);
			List<IpAuditLog> ipAuditLogs = null;
			if (userId == null) {
				ipAuditLogs = ipAuditLogRepository.retrieveByClientIpAddress(userEventDto.getClientIpAddress(),
						pageRequest);
			} else {
				ipAuditLogs = ipAuditLogRepository.retrieveByParams(userEventDto.getClientIpAddress(), userId,
						pageRequest);
			}
			if (ipAuditLogs == null || ipAuditLogs.isEmpty()) {
				ipAuditLog = buildIpAuditLog(userEventDto, userId);
			} else {
				ipAuditLog = ipAuditLogs.get(0);
			}
		}

		return ipAuditLog;
	}

	private IpAuditLog buildIpAuditLog(UserEventDto userEventDto, Long userId) {
		IpAuditLog ipAuditLog = null;
		if (userEventDto.getClientCity() == null || userEventDto.getClientCity().trim().isEmpty()) {
			// IpStackResponseDto ipStackResponseDto =
			// ipStackUtil.setClientIpDetails(userEventDto.getClientIpAddress());
			userEventDto.setClientIpAddress(userEventDto.getClientIpAddress());
			/*
			 * userEventDto.setClientCity(ipStackResponseDto.getCity());
			 * userEventDto.setClientState(ipStackResponseDto.getRegion_name());
			 * userEventDto.setClientZipCode(ipStackResponseDto.getZip());
			 * userEventDto.setClientCountryCode(ipStackResponseDto.getCountry_code());
			 * userEventDto.setClientLatitude(ipStackResponseDto.getLatitude());
			 * userEventDto.setClientLongitude(ipStackResponseDto.getLongitude());
			 * userEventDto.setClientIpLookupResponse(ipStackResponseDto.
			 * getClientIpLookupResponse());
			 */
		}

		ipAuditLog = userEventDto.buildIpAuditLog();
		ipAuditLog.setCreatedBy(userId);
		ipAuditLogRepository.save(ipAuditLog);

		return ipAuditLog;
	}

	private void createUserEventParams(Long userEventId, List<UserEventParam> userEventParams) {
		userEventParams.forEach(param -> {
			param.setUserEventId(userEventId);
		});

		userEventParamRepository.saveAll(userEventParams);
	}

	private UserEvent createUserEvent(UserEventDto userEventDto, Long userId, IpAuditLog ipAuditLog) {
		UserEvent userEvent = userEventDto.convertToEntity();
		userEvent.setUserId(userId);
		userEvent.setIpAuditLog(ipAuditLog);
		if (userEventDto.getCreatedDate() == null) {
			userEvent.setCreatedDate(CalendarUtil.getCurrentTimeStamp());
		}
		if (userEventDto.getUpdatedDate() == null) {
			userEvent.setUpdatedDate(CalendarUtil.getCurrentTimeStamp());
		}

		userEventRepository.save(userEvent);

		return userEvent;
	}

	private UserEventType createUserEventType(UserEventDto userEventDto, Long userId) {
		UserEventType userEventType = new UserEventType();
		userEventType.setUserEventTypeInternalName(
				userEventDto.getUserEventTypeName().trim().toLowerCase().replaceAll(" ", "_"));
		userEventType.setUserEventTypeExternalName(userEventDto.getUserEventTypeName());
		userEventType.setUpdatedBy(userId);
		userEventTypeRepository.save(userEventType);

		return userEventType;
	}

	/**
	 * 
	 */
	@Override
	public void saveUserEventForApiReqs(UserEventDto userEventDto) {
		IpAuditLog ipAuditLog = getIpAuditLog(userEventDto, userEventDto.getUserId());

		createUserEvent(userEventDto, userEventDto.getUserId(), ipAuditLog);
	}

}
