package com.sca.dao.domain.notification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sca.dao.domain.common.BaseEntity;

@Entity
@Table(name = "order_notification")
public class OrderNotification extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_notification_id")
	private Integer orderNotificationId;

	@Column(name = "order_id")
	private Long orderId;

	@Column(name = "sca_user_id")
	private Long scaUserId;
	
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "wmq_id")
	private String wmqId;

	@Column(name = "email")
	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "is_dnd_disturb")
	private boolean isDndDisturb;

	@Column(name = "is_primary")
	private boolean isPrimary;

	@Column(name = "is_pcb_designer")
	private boolean isPcbDesigner;

	@Column(name = "is_engineer")
	private boolean isEngineer;

	@Column(name = "is_shipping_related")
	private boolean isShippingelated;

	@Column(name = "is_billing_related")
	private boolean isBillingRelated;

	@Column(name = "is_quality_control_related")
	private boolean isQualityControlRelated;

	@Column(name = "is_24_hour")
	private boolean is24Hour;

	@Column(name = "is_share_project")
	private boolean isShareProject;

	/**
	 * @return the orderNotificationId
	 */
	public Integer getOrderNotificationId() {
		return orderNotificationId;
	}

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @return the scaUserId
	 */
	public Long getScaUserId() {
		return scaUserId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @return the wmqId
	 */
	public String getWmqId() {
		return wmqId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the isDndDisturb
	 */
	public boolean isDndDisturb() {
		return isDndDisturb;
	}

	/**
	 * @return the isPrimary
	 */
	public boolean isPrimary() {
		return isPrimary;
	}

	/**
	 * @return the isPcbDesigner
	 */
	public boolean isPcbDesigner() {
		return isPcbDesigner;
	}

	/**
	 * @return the isEngineer
	 */
	public boolean isEngineer() {
		return isEngineer;
	}

	/**
	 * @return the isShippingelated
	 */
	public boolean isShippingelated() {
		return isShippingelated;
	}

	/**
	 * @return the isBillingRelated
	 */
	public boolean isBillingRelated() {
		return isBillingRelated;
	}

	/**
	 * @return the isQualityControlRelated
	 */
	public boolean isQualityControlRelated() {
		return isQualityControlRelated;
	}

	/**
	 * @return the is24Hour
	 */
	public boolean isIs24Hour() {
		return is24Hour;
	}

	/**
	 * @return the isShareProject
	 */
	public boolean isShareProject() {
		return isShareProject;
	}

	/**
	 * @param orderNotificationId the orderNotificationId to set
	 */
	public void setOrderNotificationId(Integer orderNotificationId) {
		this.orderNotificationId = orderNotificationId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @param scaUserId the scaUserId to set
	 */
	public void setScaUserId(Long scaUserId) {
		this.scaUserId = scaUserId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @param wmqId the wmqId to set
	 */
	public void setWmqId(String wmqId) {
		this.wmqId = wmqId;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @param isDndDisturb the isDndDisturb to set
	 */
	public void setDndDisturb(boolean isDndDisturb) {
		this.isDndDisturb = isDndDisturb;
	}

	/**
	 * @param isPrimary the isPrimary to set
	 */
	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	/**
	 * @param isPcbDesigner the isPcbDesigner to set
	 */
	public void setPcbDesigner(boolean isPcbDesigner) {
		this.isPcbDesigner = isPcbDesigner;
	}

	/**
	 * @param isEngineer the isEngineer to set
	 */
	public void setEngineer(boolean isEngineer) {
		this.isEngineer = isEngineer;
	}

	/**
	 * @param isShippingelated the isShippingelated to set
	 */
	public void setShippingelated(boolean isShippingelated) {
		this.isShippingelated = isShippingelated;
	}

	/**
	 * @param isBillingRelated the isBillingRelated to set
	 */
	public void setBillingRelated(boolean isBillingRelated) {
		this.isBillingRelated = isBillingRelated;
	}

	/**
	 * @param isQualityControlRelated the isQualityControlRelated to set
	 */
	public void setQualityControlRelated(boolean isQualityControlRelated) {
		this.isQualityControlRelated = isQualityControlRelated;
	}

	/**
	 * @param is24Hour the is24Hour to set
	 */
	public void setIs24Hour(boolean is24Hour) {
		this.is24Hour = is24Hour;
	}

	/**
	 * @param isShareProject the isShareProject to set
	 */
	public void setShareProject(boolean isShareProject) {
		this.isShareProject = isShareProject;
	}
	
}

	

