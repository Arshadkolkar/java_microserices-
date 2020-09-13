/**
 * 
 */
package com.sca.dto.audit;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.modelmapper.ModelMapper;

import com.sca.dao.domain.audit.IpAuditLog;
import com.sca.dao.domain.audit.UserEvent;
import com.sca.dao.domain.audit.UserEventParam;
import com.sca.dao.domain.common.RequestHttpMethod;

/**
 * 
 * @author subhash
 *
 */
public class UserEventDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userEventId;

	private Integer serviceEntityId;

	private Long referenceId;

	private String enterpriseDomain;

	private String enterpriseUrl;

	private String enterpriseIpAddress;

	private String clientIpAddress;

	private String clientCity;

	private String clientState;

	private String clientZipCode;

	private String clientCountryCode;

	private String clientLatitude;

	private String clientLongitude;

	private String clientIpLookupResponse;

	private Long userId;

	private Integer serviceCategoryId;

	private String userEventSourceUrl;

	private String userEventPageTitle;

	private Integer userEventTypeId;

	private String userEventTypeName;

	private String userEventName;

	private String userEventDescription;

	private String scaServiceUrl;

	private RequestHttpMethod scaServiceHttpMethod;

	private String scaServiceRequest;

	private String scaServiceResponse;

	private boolean serviceRequestStatus = true;

	private Integer application;

	private List<UserEventParam> userEventParams;

	private Calendar createdDate;

	private Calendar updatedDate;

	/**
	 * @return the userEventId
	 */
	public Long getUserEventId() {
		return userEventId;
	}

	/**
	 * @param userEventId the userEventId to set
	 */
	public void setUserEventId(Long userEventId) {
		this.userEventId = userEventId;
	}

	/**
	 * @return the serviceEntityId
	 */
	public Integer getServiceEntityId() {
		return serviceEntityId;
	}

	/**
	 * @param serviceEntityId the serviceEntityId to set
	 */
	public void setServiceEntityId(Integer serviceEntityId) {
		this.serviceEntityId = serviceEntityId;
	}

	/**
	 * @return the referenceId
	 */
	public Long getReferenceId() {
		return referenceId;
	}

	/**
	 * @param referenceId the referenceId to set
	 */
	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	/**
	 * @return the enterpriseDomain
	 */
	public String getEnterpriseDomain() {
		return enterpriseDomain;
	}

	/**
	 * @param enterpriseDomain the enterpriseDomain to set
	 */
	public void setEnterpriseDomain(String enterpriseDomain) {
		this.enterpriseDomain = enterpriseDomain;
	}

	/**
	 * @return the enterpriseUrl
	 */
	public String getEnterpriseUrl() {
		return enterpriseUrl;
	}

	/**
	 * @param enterpriseUrl the enterpriseUrl to set
	 */
	public void setEnterpriseUrl(String enterpriseUrl) {
		this.enterpriseUrl = enterpriseUrl;
	}

	/**
	 * @return the enterpriseIpAddress
	 */
	public String getEnterpriseIpAddress() {
		return enterpriseIpAddress;
	}

	/**
	 * @param enterpriseIpAddress the enterpriseIpAddress to set
	 */
	public void setEnterpriseIpAddress(String enterpriseIpAddress) {
		this.enterpriseIpAddress = enterpriseIpAddress;
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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the serviceCategoryId
	 */
	public Integer getServiceCategoryId() {
		return serviceCategoryId;
	}

	/**
	 * @param serviceCategoryId the serviceCategoryId to set
	 */
	public void setServiceCategoryId(Integer serviceCategoryId) {
		this.serviceCategoryId = serviceCategoryId;
	}

	/**
	 * @return the userEventSourceUrl
	 */
	public String getUserEventSourceUrl() {
		return userEventSourceUrl;
	}

	/**
	 * @param userEventSourceUrl the userEventSourceUrl to set
	 */
	public void setUserEventSourceUrl(String userEventSourceUrl) {
		this.userEventSourceUrl = userEventSourceUrl;
	}

	/**
	 * @return the userEventPageTitle
	 */
	public String getUserEventPageTitle() {
		return userEventPageTitle;
	}

	/**
	 * @param userEventPageTitle the userEventPageTitle to set
	 */
	public void setUserEventPageTitle(String userEventPageTitle) {
		this.userEventPageTitle = userEventPageTitle;
	}

	/**
	 * @return the userEventTypeId
	 */
	public Integer getUserEventTypeId() {
		return userEventTypeId;
	}

	/**
	 * @param userEventTypeId the userEventTypeId to set
	 */
	public void setUserEventTypeId(Integer userEventTypeId) {
		this.userEventTypeId = userEventTypeId;
	}

	/**
	 * @return the userEventTypeName
	 */
	public String getUserEventTypeName() {
		return userEventTypeName;
	}

	/**
	 * @param userEventTypeName the userEventTypeName to set
	 */
	public void setUserEventTypeName(String userEventTypeName) {
		this.userEventTypeName = userEventTypeName;
	}

	/**
	 * @return the userEventName
	 */
	public String getUserEventName() {
		return userEventName;
	}

	/**
	 * @param userEventName the userEventName to set
	 */
	public void setUserEventName(String userEventName) {
		this.userEventName = userEventName;
	}

	/**
	 * @return the userEventDescription
	 */
	public String getUserEventDescription() {
		return userEventDescription;
	}

	/**
	 * @param userEventDescription the userEventDescription to set
	 */
	public void setUserEventDescription(String userEventDescription) {
		this.userEventDescription = userEventDescription;
	}

	/**
	 * @return the kukunServiceUrl
	 */
	public String getScaServiceUrl() {
		return scaServiceUrl;
	}

	/**
	 * @param scaServiceUrl the kukunServiceUrl to set
	 */
	public void setScaServiceUrl(String scaServiceUrl) {
		this.scaServiceUrl = scaServiceUrl;
	}

	/**
	 * @return the kukunServiceHttpMethod
	 */
	public RequestHttpMethod getScaServiceHttpMethod() {
		return scaServiceHttpMethod;
	}

	/**
	 * @param scaServiceHttpMethod the kukunServiceHttpMethod to set
	 */
	public void setScaServiceHttpMethod(RequestHttpMethod scaServiceHttpMethod) {
		this.scaServiceHttpMethod = scaServiceHttpMethod;
	}

	/**
	 * @return the kukunServiceRequest
	 */
	public String getScaServiceRequest() {
		return scaServiceRequest;
	}

	/**
	 * @param scaServiceRequest the kukunServiceRequest to set
	 */
	public void setscaServiceRequest(String scaServiceRequest) {
		this.scaServiceRequest = scaServiceRequest;
	}

	/**
	 * @return the kukunServiceResponse
	 */
	public String getScaServiceResponse() {
		return scaServiceResponse;
	}

	/**
	 * @param scaServiceResponse the kukunServiceResponse to set
	 */
	public void setScaServiceResponse(String scaServiceResponse) {
		this.scaServiceResponse = scaServiceResponse;
	}

	/**
	 * @return the serviceRequestStatus
	 */
	public boolean isServiceRequestStatus() {
		return serviceRequestStatus;
	}

	/**
	 * @param serviceRequestStatus the serviceRequestStatus to set
	 */
	public void setServiceRequestStatus(boolean serviceRequestStatus) {
		this.serviceRequestStatus = serviceRequestStatus;
	}

	/**
	 * @return the application
	 */
	public Integer getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(Integer application) {
		if (application != null && com.sca.dao.util.Constants.scaApps.contains(application)) {
			this.application = application;
		} else {
			this.application = null;
		}
	}

	/**
	 * @return the userEventParams
	 */
	public List<UserEventParam> getUserEventParams() {
		return userEventParams;
	}

	/**
	 * @param userEventParams the userEventParams to set
	 */
	public void setUserEventParams(List<UserEventParam> userEventParams) {
		this.userEventParams = userEventParams;
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

	/**
	 * @return the updatedDate
	 */
	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}

	public UserEvent convertToEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, UserEvent.class);
	}

	public IpAuditLog buildIpAuditLog() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, IpAuditLog.class);
	}
}
