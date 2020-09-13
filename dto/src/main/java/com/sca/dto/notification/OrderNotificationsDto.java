/**
 * 
 */
package com.sca.dto.notification;

import java.io.Serializable;

/**
 * 
 * @author 
 *
 */
public class OrderNotificationsDto implements Serializable  {

	private static final long serialVersionUID = 6248534424106356085L;

	private Integer orderNotificationId;
	private Long orderId;
	private Long scaUserId;
	private Long userId;
	private String wmqId;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private boolean isDndDisturb;
	private boolean isPrimary;
	private boolean isPcbDesigner;
	private boolean isEngineer;
	private boolean isShippingRelated;
	private boolean isBillingRelated;
	private boolean isQualityControlRelated;
	private boolean is24Hour;
	private boolean isShareProject;
	/**
	 * @return the orderNotificationId
	 */
	public Integer getOrderNotificationId() {
		return orderNotificationId;
	}
	/**
	 * @param orderNotificationId the orderNotificationId to set
	 */
	public void setOrderNotificationId(Integer orderNotificationId) {
		this.orderNotificationId = orderNotificationId;
	}
	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
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
	 * @return the wmqId
	 */
	public String getWmqId() {
		return wmqId;
	}
	/**
	 * @param wmqId the wmqId to set
	 */
	public void setWmqId(String wmqId) {
		this.wmqId = wmqId;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * @return the isDndDisturb
	 */
	public boolean isDndDisturb() {
		return isDndDisturb;
	}
	/**
	 * @param isDndDisturb the isDndDisturb to set
	 */
	public void setDndDisturb(boolean isDndDisturb) {
		this.isDndDisturb = isDndDisturb;
	}
	/**
	 * @return the isPrimary
	 */
	public boolean isPrimary() {
		return isPrimary;
	}
	/**
	 * @param isPrimary the isPrimary to set
	 */
	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	/**
	 * @return the isPcbDesigner
	 */
	public boolean isPcbDesigner() {
		return isPcbDesigner;
	}
	/**
	 * @param isPcbDesigner the isPcbDesigner to set
	 */
	public void setPcbDesigner(boolean isPcbDesigner) {
		this.isPcbDesigner = isPcbDesigner;
	}
	/**
	 * @return the isEngineer
	 */
	public boolean isEngineer() {
		return isEngineer;
	}
	/**
	 * @param isEngineer the isEngineer to set
	 */
	public void setEngineer(boolean isEngineer) {
		this.isEngineer = isEngineer;
	}
	/**
	 * @return the isShippingRelated
	 */
	public boolean isShippingRelated() {
		return isShippingRelated;
	}
	/**
	 * @param isShippingRelated the isShippingRelated to set
	 */
	public void setShippingRelated(boolean isShippingRelated) {
		this.isShippingRelated = isShippingRelated;
	}
	/**
	 * @return the isBillingRelated
	 */
	public boolean isBillingRelated() {
		return isBillingRelated;
	}
	/**
	 * @param isBillingRelated the isBillingRelated to set
	 */
	public void setBillingRelated(boolean isBillingRelated) {
		this.isBillingRelated = isBillingRelated;
	}
	/**
	 * @return the isQualityControlRelated
	 */
	public boolean isQualityControlRelated() {
		return isQualityControlRelated;
	}
	/**
	 * @param isQualityControlRelated the isQualityControlRelated to set
	 */
	public void setQualityControlRelated(boolean isQualityControlRelated) {
		this.isQualityControlRelated = isQualityControlRelated;
	}
	/**
	 * @return the is24Hour
	 */
	public boolean isIs24Hour() {
		return is24Hour;
	}
	/**
	 * @param is24Hour the is24Hour to set
	 */
	public void setIs24Hour(boolean is24Hour) {
		this.is24Hour = is24Hour;
	}
	/**
	 * @return the isShareProject
	 */
	public boolean isShareProject() {
		return isShareProject;
	}
	/**
	 * @param isShareProject the isShareProject to set
	 */
	public void setShareProject(boolean isShareProject) {
		this.isShareProject = isShareProject;
	}
}
