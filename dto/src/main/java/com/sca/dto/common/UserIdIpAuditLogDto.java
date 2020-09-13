package com.sca.dto.common;

import java.util.List;

public class UserIdIpAuditLogDto {
	private String clientIpAddress;
	private List<Long> userId;

	public UserIdIpAuditLogDto() {
		super();
	}

	public String getClientIpAddress() {
		return clientIpAddress;
	}

	public void setClientIpAddress(String clientIpAddress) {
		this.clientIpAddress = clientIpAddress;
	}

	public List<Long> getUserId() {
		return userId;
	}

	public void setUserId(List<Long> userId) {
		this.userId = userId;
	}

}
