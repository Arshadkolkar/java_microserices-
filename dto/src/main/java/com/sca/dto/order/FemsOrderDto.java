/**
 * 
 */
package com.sca.dto.order;

import java.io.Serializable;

/**
 * 
 * @author
 *
 */
public class FemsOrderDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String areComponentCanNotWashed;
	private String billingAddressLine1;
	private String billingAddressLine2;
	private String billingCity;
	private String billingContactCompany;
	private String billingContactEmail;
	private String billingContactFirstName;
	private String billingContactLastName;
	private String billingContactPhone;
	private String billingCountry;
	private String billingState;
	private String billingZip;
	private String bomSpecialInstructions;
	private String channelOrderNumber;
	private String contactPersonName24Hour;
	private String contactPhoneNumber24Hour;
	private String customerEmail;
	private String designFileName;
	private String designerAddressLine1;
	private String designerAddressLine2;
	private String designerCity;
	private String designerContactCompany;
	private String designerContactEmail;
	private String designerContactFirstName;
	private String designerContactLastName;
	private String designerContactPhone;
	private String designerCountry;
	private String designerState;
	private String designerZip;
	private String isElectricalTest;
	private String iwillSupplyPcbAs;
	private String pcbComingFrom;
	private String pcbReceiveDate;
	private String projectID;
	private String promoCode;
	private String referencePONumber;
	private String resaleFileByteArray;
	private String resaleFileName;
	private String resaleNumber;
	private String shipAssembledBoard;
	private String shippingAccountNumber;
	private String shippingAddressLine1;
	private String shippingAddressLine2;
	private String shippingCity;
	private String shippingContactCompany;
	private String shippingContactEmail;
	private String shippingContactFirstName;
	private String shippingContactLastName;
	private String shippingContactPhone;
	private String shippingCountry;
	private String shippingMethod;
	private String shippingNotes;
	private String shippingState;
	private String shippingZip;
	private String sierraPCBToolNo;
	private String specifyWhichCompCanNotWashed;
	private String taxExemptCertNumber;
	private String taxExemptOutsideCalifornia;
	private String taxable;
	private String whenComponentWillArrive;
	
	private String errorMessage;
	public FemsOrderDto(OrderDto orderDto) {
		this.areComponentCanNotWashed = "";
		this.billingAddressLine1 = orderDto.getBillingAddress().getAddressLine1();
		this.billingAddressLine2 = orderDto.getBillingAddress().getAddressLine2();
		this.billingCity = orderDto.getBillingAddress().getCity();
		this.billingContactCompany = orderDto.getBillingAddress().getCompanyName();
		this.billingContactEmail = orderDto.getBillingAddress().getContactEmail();
		this.billingContactFirstName = orderDto.getBillingAddress().getContactFirstName();
		this.billingContactLastName = orderDto.getBillingAddress().getContactLastName();
		this.billingContactPhone = orderDto.getBillingAddress().getContactPhone();
		this.billingCountry = orderDto.getBillingAddress().getCountry();
		this.billingState = orderDto.getBillingAddress().getState();
		this.billingZip = String.valueOf(orderDto.getBillingAddress().getZip());
		this.bomSpecialInstructions = "";
		this.channelOrderNumber = "";
		this.contactPersonName24Hour = "";
		this.contactPhoneNumber24Hour = "";
		this.customerEmail = "";
		this.designFileName = orderDto.getDesignFileName();
		this.designerAddressLine1 = orderDto.getDesignergAddress().getAddressLine1();
		this.designerAddressLine2 = orderDto.getDesignergAddress().getAddressLine2();
		this.designerCity = orderDto.getDesignergAddress().getCity();
		this.designerContactCompany = orderDto.getDesignergAddress().getCompanyName();
		this.designerContactEmail = orderDto.getDesignergAddress().getContactEmail();
		this.designerContactFirstName = orderDto.getDesignergAddress().getContactFirstName();
		this.designerContactLastName = orderDto.getDesignergAddress().getContactLastName();
		this.designerContactPhone = orderDto.getDesignergAddress().getContactPhone();
		this.designerCountry = orderDto.getDesignergAddress().getCountry();
		this.designerState = orderDto.getDesignergAddress().getState();
		this.designerZip = String.valueOf(orderDto.getDesignergAddress().getZip());
		this.isElectricalTest = "";
		this.iwillSupplyPcbAs = "";
		this.pcbComingFrom = "";
		this.pcbReceiveDate = "";
		this.projectID = orderDto.getProjectId();
		this.promoCode = orderDto.getPromoCode();
		this.referencePONumber = "";

		this.resaleFileByteArray = "";
		this.resaleFileName = "";

		this.resaleNumber = orderDto.getResaleNumber();
		this.shipAssembledBoard = "";
		this.shippingAccountNumber = String.valueOf(orderDto.getShippingAccountNumber());
		this.shippingAddressLine1 = orderDto.getShippingAddress().getAddressLine1();
		this.shippingAddressLine2 = orderDto.getShippingAddress().getAddressLine2();
		this.shippingCity = orderDto.getShippingAddress().getCity();
		this.shippingContactCompany = orderDto.getShippingAddress().getCompanyName();
		this.shippingContactEmail = orderDto.getShippingAddress().getContactEmail();
		this.shippingContactFirstName = orderDto.getShippingAddress().getContactFirstName();
		this.shippingContactLastName = orderDto.getShippingAddress().getContactLastName();
		this.shippingContactPhone = orderDto.getShippingAddress().getContactPhone();
		this.shippingCountry = orderDto.getShippingAddress().getCountry();
		this.shippingMethod = String.valueOf(orderDto.getShippingMethod());
		this.shippingNotes = orderDto.getShippingNotes();
		this.shippingState = orderDto.getShippingAddress().getState();
		this.shippingZip = String.valueOf(orderDto.getShippingAddress().getZip());
		this.sierraPCBToolNo = "";
		this.specifyWhichCompCanNotWashed = "";
		this.taxExemptCertNumber = orderDto.getTaxExemptCertNumber();
		this.taxExemptOutsideCalifornia = orderDto.getTaxExemptOutsideCalifornia();
		this.taxable = orderDto.isTaxable() ? "1" : "0";
		this.whenComponentWillArrive = "";
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getAreComponentCanNotWashed() {
		return areComponentCanNotWashed;
	}

	public void setAreComponentCanNotWashed(String areComponentCanNotWashed) {
		this.areComponentCanNotWashed = areComponentCanNotWashed;
	}

	public String getBillingAddressLine1() {
		return billingAddressLine1;
	}

	public void setBillingAddressLine1(String billingAddressLine1) {
		this.billingAddressLine1 = billingAddressLine1;
	}

	public String getBillingAddressLine2() {
		return billingAddressLine2;
	}

	public void setBillingAddressLine2(String billingAddressLine2) {
		this.billingAddressLine2 = billingAddressLine2;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingContactCompany() {
		return billingContactCompany;
	}

	public void setBillingContactCompany(String billingContactCompany) {
		this.billingContactCompany = billingContactCompany;
	}

	public String getBillingContactEmail() {
		return billingContactEmail;
	}

	public void setBillingContactEmail(String billingContactEmail) {
		this.billingContactEmail = billingContactEmail;
	}

	public String getBillingContactFirstName() {
		return billingContactFirstName;
	}

	public void setBillingContactFirstName(String billingContactFirstName) {
		this.billingContactFirstName = billingContactFirstName;
	}

	public String getBillingContactLastName() {
		return billingContactLastName;
	}

	public void setBillingContactLastName(String billingContactLastName) {
		this.billingContactLastName = billingContactLastName;
	}

	public String getBillingContactPhone() {
		return billingContactPhone;
	}

	public void setBillingContactPhone(String billingContactPhone) {
		this.billingContactPhone = billingContactPhone;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingZip() {
		return billingZip;
	}

	public void setBillingZip(String billingZip) {
		this.billingZip = billingZip;
	}

	public String getBomSpecialInstructions() {
		return bomSpecialInstructions;
	}

	public void setBomSpecialInstructions(String bomSpecialInstructions) {
		this.bomSpecialInstructions = bomSpecialInstructions;
	}

	public String getChannelOrderNumber() {
		return channelOrderNumber;
	}

	public void setChannelOrderNumber(String channelOrderNumber) {
		this.channelOrderNumber = channelOrderNumber;
	}

	public String getContactPersonName24Hour() {
		return contactPersonName24Hour;
	}

	public void setContactPersonName24Hour(String contactPersonName24Hour) {
		this.contactPersonName24Hour = contactPersonName24Hour;
	}

	public String getContactPhoneNumber24Hour() {
		return contactPhoneNumber24Hour;
	}

	public void setContactPhoneNumber24Hour(String contactPhoneNumber24Hour) {
		this.contactPhoneNumber24Hour = contactPhoneNumber24Hour;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getDesignFileName() {
		return designFileName;
	}

	public void setDesignFileName(String designFileName) {
		this.designFileName = designFileName;
	}

	public String getDesignerAddressLine1() {
		return designerAddressLine1;
	}

	public void setDesignerAddressLine1(String designerAddressLine1) {
		this.designerAddressLine1 = designerAddressLine1;
	}

	public String getDesignerAddressLine2() {
		return designerAddressLine2;
	}

	public void setDesignerAddressLine2(String designerAddressLine2) {
		this.designerAddressLine2 = designerAddressLine2;
	}

	public String getDesignerContactCompany() {
		return designerContactCompany;
	}

	public void setDesignerContactCompany(String designerContactCompany) {
		this.designerContactCompany = designerContactCompany;
	}

	public String getDesignerContactEmail() {
		return designerContactEmail;
	}

	public void setDesignerContactEmail(String designerContactEmail) {
		this.designerContactEmail = designerContactEmail;
	}

	public String getDesignerContactFirstName() {
		return designerContactFirstName;
	}

	public void setDesignerContactFirstName(String designerContactFirstName) {
		this.designerContactFirstName = designerContactFirstName;
	}

	public String getDesignerContactLastName() {
		return designerContactLastName;
	}

	public void setDesignerContactLastName(String designerContactLastName) {
		this.designerContactLastName = designerContactLastName;
	}

	public String getDesignerContactPhone() {
		return designerContactPhone;
	}

	public void setDesignerContactPhone(String designerContactPhone) {
		this.designerContactPhone = designerContactPhone;
	}

	public String getDesignerCountry() {
		return designerCountry;
	}

	public void setDesignerCountry(String designerCountry) {
		this.designerCountry = designerCountry;
	}

	public String getDesignerState() {
		return designerState;
	}

	public void setDesignerState(String designerState) {
		this.designerState = designerState;
	}

	public String getDesignerZip() {
		return designerZip;
	}

	public void setDesignerZip(String designerZip) {
		this.designerZip = designerZip;
	}

	public String getIsElectricalTest() {
		return isElectricalTest;
	}

	public void setIsElectricalTest(String isElectricalTest) {
		this.isElectricalTest = isElectricalTest;
	}

	public String getIwillSupplyPcbAs() {
		return iwillSupplyPcbAs;
	}

	public void setIwillSupplyPcbAs(String iwillSupplyPcbAs) {
		this.iwillSupplyPcbAs = iwillSupplyPcbAs;
	}

	public String getPcbComingFrom() {
		return pcbComingFrom;
	}

	public void setPcbComingFrom(String pcbComingFrom) {
		this.pcbComingFrom = pcbComingFrom;
	}

	public String getPcbReceiveDate() {
		return pcbReceiveDate;
	}

	public void setPcbReceiveDate(String pcbReceiveDate) {
		this.pcbReceiveDate = pcbReceiveDate;
	}

	public String getReferencePONumber() {
		return referencePONumber;
	}

	public void setReferencePONumber(String referencePONumber) {
		this.referencePONumber = referencePONumber;
	}

	public String getResaleFileByteArray() {
		return resaleFileByteArray;
	}

	public void setResaleFileByteArray(String resaleFileByteArray) {
		this.resaleFileByteArray = resaleFileByteArray;
	}

	public String getResaleFileName() {
		return resaleFileName;
	}

	public void setResaleFileName(String resaleFileName) {
		this.resaleFileName = resaleFileName;
	}

	public String getResaleNumber() {
		return resaleNumber;
	}

	public void setResaleNumber(String resaleNumber) {
		this.resaleNumber = resaleNumber;
	}

	public String getShipAssembledBoard() {
		return shipAssembledBoard;
	}

	public void setShipAssembledBoard(String shipAssembledBoard) {
		this.shipAssembledBoard = shipAssembledBoard;
	}

	public String getShippingAccountNumber() {
		return shippingAccountNumber;
	}

	public void setShippingAccountNumber(String shippingAccountNumber) {
		this.shippingAccountNumber = shippingAccountNumber;
	}

	public String getShippingAddressLine1() {
		return shippingAddressLine1;
	}

	public void setShippingAddressLine1(String shippingAddressLine1) {
		this.shippingAddressLine1 = shippingAddressLine1;
	}

	public String getShippingAddressLine2() {
		return shippingAddressLine2;
	}

	public void setShippingAddressLine2(String shippingAddressLine2) {
		this.shippingAddressLine2 = shippingAddressLine2;
	}

	public String getShippingContactCompany() {
		return shippingContactCompany;
	}

	public void setShippingContactCompany(String shippingContactCompany) {
		this.shippingContactCompany = shippingContactCompany;
	}

	public String getShippingContactEmail() {
		return shippingContactEmail;
	}

	public void setShippingContactEmail(String shippingContactEmail) {
		this.shippingContactEmail = shippingContactEmail;
	}

	public String getShippingContactFirstName() {
		return shippingContactFirstName;
	}

	public void setShippingContactFirstName(String shippingContactFirstName) {
		this.shippingContactFirstName = shippingContactFirstName;
	}

	public String getShippingContactLastName() {
		return shippingContactLastName;
	}

	public void setShippingContactLastName(String shippingContactLastName) {
		this.shippingContactLastName = shippingContactLastName;
	}

	public String getShippingContactPhone() {
		return shippingContactPhone;
	}

	public void setShippingContactPhone(String shippingContactPhone) {
		this.shippingContactPhone = shippingContactPhone;
	}

	public String getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getShippingNotes() {
		return shippingNotes;
	}

	public void setShippingNotes(String shippingNotes) {
		this.shippingNotes = shippingNotes;
	}

	public String getShippingState() {
		return shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public String getShippingZip() {
		return shippingZip;
	}

	public void setShippingZip(String shippingZip) {
		this.shippingZip = shippingZip;
	}

	public String getSierraPCBToolNo() {
		return sierraPCBToolNo;
	}

	public void setSierraPCBToolNo(String sierraPCBToolNo) {
		this.sierraPCBToolNo = sierraPCBToolNo;
	}

	public String getSpecifyWhichCompCanNotWashed() {
		return specifyWhichCompCanNotWashed;
	}

	public void setSpecifyWhichCompCanNotWashed(String specifyWhichCompCanNotWashed) {
		this.specifyWhichCompCanNotWashed = specifyWhichCompCanNotWashed;
	}

	public String getTaxExemptCertNumber() {
		return taxExemptCertNumber;
	}

	public void setTaxExemptCertNumber(String taxExemptCertNumber) {
		this.taxExemptCertNumber = taxExemptCertNumber;
	}

	public String getTaxExemptOutsideCalifornia() {
		return taxExemptOutsideCalifornia;
	}

	public void setTaxExemptOutsideCalifornia(String taxExemptOutsideCalifornia) {
		this.taxExemptOutsideCalifornia = taxExemptOutsideCalifornia;
	}

	public String getWhenComponentWillArrive() {
		return whenComponentWillArrive;
	}

	public void setWhenComponentWillArrive(String whenComponentWillArrive) {
		this.whenComponentWillArrive = whenComponentWillArrive;
	}

	public String getDesignerCity() {
		return designerCity;
	}

	public void setDesignerCity(String designerCity) {
		this.designerCity = designerCity;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getTaxable() {
		return taxable;
	}

	public void setTaxable(String taxable) {
		this.taxable = taxable;
	}

}
