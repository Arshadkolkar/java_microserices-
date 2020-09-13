/**
 * 
 */
package com.sca.dao.domain.security;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author subhash
 *
 */
@Entity
@Table(name = "user_login")
public class UserLogin implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "sca_user_id")
	private Long scaUserId;

	@Column(name = "access_token")
	private String accessToken;

	@Column(name = "login_date")
	private Calendar loginDate;

	@Column(name = "logout_date")
	private Calendar logoutDate;

	@Column(name = "session_id")
	private String sessionId;

	/**
	 * @return the scaUserId
	 */
	public Long getScaUserId() {
		return scaUserId;
	}

	/**
	 * @param scaUserId the scaUserId to set
	 */
	public void setScaUserId(Long scaUserId) {
		this.scaUserId = scaUserId;
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the loginDate
	 */
	public Calendar getLoginDate() {
		return loginDate;
	}

	/**
	 * @param loginDate the loginDate to set
	 */
	public void setLoginDate(Calendar loginDate) {
		this.loginDate = loginDate;
	}

	/**
	 * @return the logoutDate
	 */
	public Calendar getLogoutDate() {
		return logoutDate;
	}

	/**
	 * @param logoutDate the logoutDate to set
	 */
	public void setLogoutDate(Calendar logoutDate) {
		this.logoutDate = logoutDate;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
