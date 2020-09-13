package com.sca.dao.domain.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sca.dao.domain.common.BaseEntity;

@Entity
@Table(name = "sca_order")
public class Order extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "sca_user_id")
	private Long scaUserId;

	@Column(name = "wq_number")
	private String wqNumber;

	@Column(name = "shipping_address_id")
	private Long shippingAddressId;

	@Column(name = "billing_address_id")
	private Long billingAddressId;

	@Column(name = "designer_address_id")
	private Long designerAddressId;

	@Column(name = "order_notification_id")
	private Integer orderNotificationId;

	@Column(name = "credit_card_id")
	private Long creditCardId;

	@Column(name = "promo_code")
	private String promoCode;

	@Column(name = "project_id")
	private String projectId;

	@Column(name = "shipping_account_number")
	private Integer shippingAccountNumber;

	@Column(name = "shipping_method")
	private Integer shippingMethod;

	@Column(name = "shipping_notes")
	private String shippingNotes;

	@Column(name = "taxable")
	private boolean taxable;

	@Column(name = "tax_exempt_cert_number")
	private String taxExemptCertNumber;

	@Column(name = "tax_exempt_outside_california")
	private String taxExemptOutsideCalifornia;

	@Column(name = "resale_number")
	private String resaleNumber;

	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "order_subTotal")
	private Double orderSubTotal;

	@Column(name = "shipping_charges")
	private Double shippingCharges;

	@Column(name = "calculated_tax")
	private Double calculatedTax;

	@Column(name = "order_Total")
	private Double orderTotal;

	@Column(name = "promised_ship_date")
	private Date promisedShipDate;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "submit_to_fems")
	private boolean submitToFems;

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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @return the wqNumber
	 */
	public String getWqNumber() {
		return wqNumber;
	}

	/**
	 * @param wqNumber the wqNumber to set
	 */
	public void setWqNumber(String wqNumber) {
		this.wqNumber = wqNumber;
	}

	/**
	 * @return the shippingAddressId
	 */
	public Long getShippingAddressId() {
		return shippingAddressId;
	}

	/**
	 * @param shippingAddressId the shippingAddressId to set
	 */
	public void setShippingAddressId(Long shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	/**
	 * @return the billingAddressId
	 */
	public Long getBillingAddressId() {
		return billingAddressId;
	}

	/**
	 * @param billingAddressId the billingAddressId to set
	 */
	public void setBillingAddressId(Long billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	/**
	 * @return the designerAddressId
	 */
	public Long getDesignerAddressId() {
		return designerAddressId;
	}

	/**
	 * @param designerAddressId the designerAddressId to set
	 */
	public void setDesignerAddressId(Long designerAddressId) {
		this.designerAddressId = designerAddressId;
	}

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
	 * @return the creditCardId
	 */
	public Long getCreditCardId() {
		return creditCardId;
	}

	/**
	 * @param creditCardId the creditCardId to set
	 */
	public void setCreditCardId(Long creditCardId) {
		this.creditCardId = creditCardId;
	}

	/**
	 * @return the promoCode
	 */
	public String getPromoCode() {
		return promoCode;
	}

	/**
	 * @param promoCode the promoCode to set
	 */
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the shippingAccountNumber
	 */
	public Integer getShippingAccountNumber() {
		return shippingAccountNumber;
	}

	/**
	 * @param shippingAccountNumber the shippingAccountNumber to set
	 */
	public void setShippingAccountNumber(Integer shippingAccountNumber) {
		this.shippingAccountNumber = shippingAccountNumber;
	}

	/**
	 * @return the shippingMethod
	 */
	public Integer getShippingMethod() {
		return shippingMethod;
	}

	/**
	 * @param shippingMethod the shippingMethod to set
	 */
	public void setShippingMethod(Integer shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	/**
	 * @return the shippingNotes
	 */
	public String getShippingNotes() {
		return shippingNotes;
	}

	/**
	 * @param shippingNotes the shippingNotes to set
	 */
	public void setShippingNotes(String shippingNotes) {
		this.shippingNotes = shippingNotes;
	}

	/**
	 * @return the taxable
	 */
	public boolean isTaxable() {
		return taxable;
	}

	/**
	 * @param taxable the taxable to set
	 */
	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}

	/**
	 * @return the taxExemptCertNumber
	 */
	public String getTaxExemptCertNumber() {
		return taxExemptCertNumber;
	}

	/**
	 * @param taxExemptCertNumber the taxExemptCertNumber to set
	 */
	public void setTaxExemptCertNumber(String taxExemptCertNumber) {
		this.taxExemptCertNumber = taxExemptCertNumber;
	}

	/**
	 * @return the taxExemptOutsideCalifornia
	 */
	public String getTaxExemptOutsideCalifornia() {
		return taxExemptOutsideCalifornia;
	}

	/**
	 * @param taxExemptOutsideCalifornia the taxExemptOutsideCalifornia to set
	 */
	public void setTaxExemptOutsideCalifornia(String taxExemptOutsideCalifornia) {
		this.taxExemptOutsideCalifornia = taxExemptOutsideCalifornia;
	}

	/**
	 * @return the resaleNumber
	 */
	public String getResaleNumber() {
		return resaleNumber;
	}

	/**
	 * @param resaleNumber the resaleNumber to set
	 */
	public void setResaleNumber(String resaleNumber) {
		this.resaleNumber = resaleNumber;
	}

	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the orderSubTotal
	 */
	public Double getOrderSubTotal() {
		return orderSubTotal;
	}

	/**
	 * @param orderSubTotal the orderSubTotal to set
	 */
	public void setOrderSubTotal(Double orderSubTotal) {
		this.orderSubTotal = orderSubTotal;
	}

	/**
	 * @return the shippingCharges
	 */
	public Double getShippingCharges() {
		return shippingCharges;
	}

	/**
	 * @param shippingCharges the shippingCharges to set
	 */
	public void setShippingCharges(Double shippingCharges) {
		this.shippingCharges = shippingCharges;
	}

	/**
	 * @return the calculatedTax
	 */
	public Double getCalculatedTax() {
		return calculatedTax;
	}

	/**
	 * @param calculatedTax the calculatedTax to set
	 */
	public void setCalculatedTax(Double calculatedTax) {
		this.calculatedTax = calculatedTax;
	}

	/**
	 * @return the orderTotal
	 */
	public Double getOrderTotal() {
		return orderTotal;
	}

	/**
	 * @param orderTotal the orderTotal to set
	 */
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	/**
	 * @return the promisedShipDate
	 */
	public Date getPromisedShipDate() {
		return promisedShipDate;
	}

	/**
	 * @param promisedShipDate the promisedShipDate to set
	 */
	public void setPromisedShipDate(Date promisedShipDate) {
		this.promisedShipDate = promisedShipDate;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the submitToFems
	 */
	public boolean isSubmitToFems() {
		return submitToFems;
	}

	/**
	 * @param submitToFems the submitToFems to set
	 */
	public void setSubmitToFems(boolean submitToFems) {
		this.submitToFems = submitToFems;
	}
}
