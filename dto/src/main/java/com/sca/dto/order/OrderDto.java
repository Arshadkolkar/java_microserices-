/**
 * 
 */
package com.sca.dto.order;

import java.io.Serializable;

import com.sca.dto.location.AddressDto;
import com.sca.dto.payment.CreditCardDto;

public class OrderDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long orderId;
	private Long scaUserId;
	private String userId;
	private AddressDto shippingAddress;
	private AddressDto billingAddress;
	private AddressDto designergAddress;
	private CreditCardDto creditCardDetails;
	private boolean taxable=true;
	private String promoCode;
	private String projectId;
	private Integer shippingAccountNumber;
	private Integer shippingMethod;
	private String shippingNotes;
	private String taxExemptCertNumber;
	private String taxExemptOutsideCalifornia;
	private String resaleNumber;
	private String wqNumber;
	private Integer entityStatusId;
	private boolean isActive;
	private String orderNumber;
	private Double orderSubTotal;
	private Double shippingCharges;
	private Double calculatedTax;
	private Double orderTotal;
	private String promisedShipDate;
	// private boolean submitToFems;
	private String designFileName;
	private int statusCode;
	private String errorMessage;

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
	 * @return the shippingAddress
	 */
	public AddressDto getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(AddressDto shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * @return the billingAddress
	 */
	public AddressDto getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(AddressDto billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the designergAddress
	 */
	public AddressDto getDesignergAddress() {
		return designergAddress;
	}

	/**
	 * @param designergAddress the designergAddress to set
	 */
	public void setDesignergAddress(AddressDto designergAddress) {
		this.designergAddress = designergAddress;
	}

	/**
	 * @return the creditCardDetails
	 */
	public CreditCardDto getCreditCardDetails() {
		return creditCardDetails;
	}

	/**
	 * @param creditCardDetails the creditCardDetails to set
	 */
	public void setCreditCardDetails(CreditCardDto creditCardDetails) {
		this.creditCardDetails = creditCardDetails;
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
	 * @return the entityStatusId
	 */
	public Integer getEntityStatusId() {
		return entityStatusId;
	}

	/**
	 * @param entityStatusId the entityStatusId to set
	 */
	public void setEntityStatusId(Integer entityStatusId) {
		this.entityStatusId = entityStatusId;
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
	public String getPromisedShipDate() {
		return promisedShipDate;
	}

	/**
	 * @param promisedShipDate the promisedShipDate to set
	 */
	public void setPromisedShipDate(String promisedShipDate) {
		this.promisedShipDate = promisedShipDate;
	}
	/**
	 * @return the submitToFems
	 */
	/*
	 * public boolean isSubmitToFems() { return submitToFems; }
	 *//**
		 * @param submitToFems the submitToFems to set
		 *//*
			 * public void setSubmitToFems(boolean submitToFems) { this.submitToFems =
			 * submitToFems; }
			 */

	/**
	 * @return the designFileName
	 */
	public String getDesignFileName() {
		return designFileName;
	}

	/**
	 * @param designFileName the designFileName to set
	 */
	public void setDesignFileName(String designFileName) {
		this.designFileName = designFileName;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
