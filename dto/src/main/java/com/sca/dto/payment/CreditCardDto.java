/**
 * 
 */
package com.sca.dto.payment;

/**
 * 
 * @author subhash
 *
 */
public class CreditCardDto {

	private Long creditCardId;
	private Long scaUserId;
	private String creditCardHolderName;
	private Long creditCardNumber;
	private Integer creditCardTypeId;
	private String creditCardName;
	private Integer creditCardSecurityCode;
	private String creditCardExpiryDate;
	private boolean defaultCreditCard;
	private boolean activeCreditCard;

	public Long getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(Long creditCardId) {
		this.creditCardId = creditCardId;
	}

	public Long getScaUserId() {
		return scaUserId;
	}

	public void setScaUserId(Long scaUserId) {
		this.scaUserId = scaUserId;
	}

	public String getCreditCardHolderName() {
		return creditCardHolderName;
	}

	public void setCreditCardHolderName(String creditCardHolderName) {
		this.creditCardHolderName = creditCardHolderName;
	}

	public Long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Integer getCreditCardTypeId() {
		return creditCardTypeId;
	}

	public void setCreditCardTypeId(Integer creditCardTypeId) {
		this.creditCardTypeId = creditCardTypeId;
	}

	public String getCreditCardName() {
		return creditCardName;
	}

	public void setCreditCardName(String creditCardName) {
		this.creditCardName = creditCardName;
	}

	public Integer getCreditCardSecurityCode() {
		return creditCardSecurityCode;
	}

	public void setCreditCardSecurityCode(Integer creditCardSecurityCode) {
		this.creditCardSecurityCode = creditCardSecurityCode;
	}

	public String getCreditCardExpiryDate() {
		return creditCardExpiryDate;
	}

	public void setCreditCardExpiryDate(String creditCardExpiryDate) {
		this.creditCardExpiryDate = creditCardExpiryDate;
	}

	public boolean isDefaultCreditCard() {
		return defaultCreditCard;
	}

	public void setDefaultCreditCard(boolean defaultCreditCard) {
		this.defaultCreditCard = defaultCreditCard;
	}

	public boolean isActiveCreditCard() {
		return activeCreditCard;
	}

	public void setActiveCreditCard(boolean activeCreditCard) {
		this.activeCreditCard = activeCreditCard;
	}

}
