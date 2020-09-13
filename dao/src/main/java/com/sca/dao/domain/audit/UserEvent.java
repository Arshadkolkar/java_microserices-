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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.sca.dao.domain.common.ServiceCategory;

/**
 * 
 * @author subhash
 *
 */
@Entity
@Table(name = "user_event")
public class UserEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_event_id")
	private Long userEventId;

	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "service_entity_id", referencedColumnName = "service_entity_id", nullable = true)
	private ServiceEntity serviceEntity;

	@Column(name = "reference_id")
	private Long referenceId;

	@Column(name = "enterprise_domain")
	private String enterpriseDomain;

	@Column(name = "enterprise_url")
	private String enterpriseUrl;

	@Column(name = "enterprise_ip_address")
	private String enterpriseIpAddress;

	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "ip_audit_log_id", referencedColumnName = "ip_audit_log_id", nullable = true)
	private IpAuditLog ipAuditLog;

	@Column(name = "organization_id")
	private Long organizationId;

	@Column(name = "user_id")
	private Long userId;

	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "service_category_id", referencedColumnName = "service_category_id", nullable = true)
	private ServiceCategory serviceCategory;

	@Column(name = "user_event_source_url")
	private String userEventSourceUrl;

	@Column(name = "user_event_page_title")
	private String userEventPageTitle;

	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "user_event_type_id", referencedColumnName = "user_event_type_id", nullable = true)
	private UserEventType userEventType;

	@Column(name = "user_event_name")
	private String userEventName;

	@Column(name = "user_event_description")
	private String userEventDescription;

	@Column(name = "sca_service_url")
	private String scaServiceUrl;


	@Column(name = "sca_service_request")
	private String scaServiceRequest;

	@Column(name = "sca_service_response")
	private String scaServiceResponse;

	@Column(name = "service_request_status")
	private Integer serviceRequestStatus;

	@Column(name = "application")
	private Integer application;

	@Column(name = "created_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
	private Calendar createdDate;

	@Column(name = "updated_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
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
	 * @return the serviceEntity
	 */
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	/**
	 * @param serviceEntity the serviceEntity to set
	 */
	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
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
	 * @return the ipAuditLog
	 */
	public IpAuditLog getIpAuditLog() {
		return ipAuditLog;
	}

	/**
	 * @param ipAuditLog the ipAuditLog to set
	 */
	public void setIpAuditLog(IpAuditLog ipAuditLog) {
		this.ipAuditLog = ipAuditLog;
	}

	/**
	 * @return the organizationId
	 */
	public Long getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
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
	 * @return the serviceCategory
	 */
	public ServiceCategory getServiceCategory() {
		return serviceCategory;
	}

	/**
	 * @param serviceCategory the serviceCategory to set
	 */
	public void setServiceCategory(ServiceCategory serviceCategory) {
		this.serviceCategory = serviceCategory;
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
	 * @return the userEventType
	 */
	public UserEventType getUserEventType() {
		return userEventType;
	}

	/**
	 * @param userEventType the userEventType to set
	 */
	public void setUserEventType(UserEventType userEventType) {
		this.userEventType = userEventType;
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
	 * @return the kukunServiceRequest
	 */
	public String getScaServiceRequest() {
		return scaServiceRequest;
	}

	/**
	 * @param scaServiceRequest the kukunServiceRequest to set
	 */
	public void setScaServiceRequest(String scaServiceRequest) {
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
	public Integer getServiceRequestStatus() {
		return serviceRequestStatus;
	}

	/**
	 * @param serviceRequestStatus the serviceRequestStatus to set
	 */
	public void setServiceRequestStatus(Integer serviceRequestStatus) {
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
		this.application = application;
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
}
