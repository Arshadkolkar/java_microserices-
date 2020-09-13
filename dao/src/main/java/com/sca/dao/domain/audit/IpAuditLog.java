/**
 * 
 */
package com.sca.dao.domain.audit;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author subhash
 *
 */
@Entity
@Table(name = "ip_audit_log")
public class IpAuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ip_audit_log_id")
	private Long ipAuditLogId;

	@Column(name = "client_ip_address")
	private String clientIpAddress;

	@Column(name = "client_city")
	private String clientCity;

	@Column(name = "client_state")
	private String clientState;

	@Column(name = "client_zip_code")
	private String clientZipCode;

	@Column(name = "client_country_code")
	private String clientCountryCode;

	@Column(name = "client_latitude")
	private String clientLatitude;

	@Column(name = "client_longitude")
	private String clientLongitude;

	@Column(name = "client_ip_lookup_response")
	private String clientIpLookupResponse;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "created_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
	private Calendar createdDate;

	/**
	 * @return the ipAuditLogId
	 */
	public Long getIpAuditLogId() {
		return ipAuditLogId;
	}

	/**
	 * @param ipAuditLogId the ipAuditLogId to set
	 */
	public void setIpAuditLogId(Long ipAuditLogId) {
		this.ipAuditLogId = ipAuditLogId;
	}

	/**
	 * @return the clientIpAddress
	 */
	public String getClientIpAddress() {
		return clientIpAddress;
	}

	/**
	 * @param clientIpAddress the clientIpAddress to set
	 */
	public void setClientIpAddress(String clientIpAddress) {
		this.clientIpAddress = clientIpAddress;
	}

	/**
	 * @return the clientCity
	 */
	public String getClientCity() {
		return clientCity;
	}

	/**
	 * @param clientCity the clientCity to set
	 */
	public void setClientCity(String clientCity) {
		this.clientCity = clientCity;
	}

	/**
	 * @return the clientState
	 */
	public String getClientState() {
		return clientState;
	}

	/**
	 * @param clientState the clientState to set
	 */
	public void setClientState(String clientState) {
		this.clientState = clientState;
	}

	/**
	 * @return the clientZipCode
	 */
	public String getClientZipCode() {
		return clientZipCode;
	}

	/**
	 * @param clientZipCode the clientZipCode to set
	 */
	public void setClientZipCode(String clientZipCode) {
		this.clientZipCode = clientZipCode;
	}

	/**
	 * @return the clientCountryCode
	 */
	public String getClientCountryCode() {
		return clientCountryCode;
	}

	/**
	 * @param clientCountryCode the clientCountryCode to set
	 */
	public void setClientCountryCode(String clientCountryCode) {
		this.clientCountryCode = clientCountryCode;
	}

	/**
	 * @return the clientLatitude
	 */
	public String getClientLatitude() {
		return clientLatitude;
	}

	/**
	 * @param clientLatitude the clientLatitude to set
	 */
	public void setClientLatitude(String clientLatitude) {
		this.clientLatitude = clientLatitude;
	}

	/**
	 * @return the clientLongitude
	 */
	public String getClientLongitude() {
		return clientLongitude;
	}

	/**
	 * @param clientLongitude the clientLongitude to set
	 */
	public void setClientLongitude(String clientLongitude) {
		this.clientLongitude = clientLongitude;
	}

	/**
	 * @return the clientIpLookupResponse
	 */
	public String getClientIpLookupResponse() {
		return clientIpLookupResponse;
	}

	/**
	 * @param clientIpLookupResponse the clientIpLookupResponse to set
	 */
	public void setClientIpLookupResponse(String clientIpLookupResponse) {
		this.clientIpLookupResponse = clientIpLookupResponse;
	}

	/**
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Calendar getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
