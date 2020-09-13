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
public class FemsCardDetailsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String creditCardExpirationDate;
	private String creditCardHolderName;
	private String creditCardNumber;
	private String creditCardSecurityCode;
	private String creditCardType;
	
		
		
	public FemsCardDetailsDto(OrderDto orderDto) {
		this.creditCardExpirationDate = orderDto.getCreditCardDetails().getCreditCardExpiryDate();
		this.creditCardHolderName = orderDto.getCreditCardDetails().getCreditCardHolderName();
		this.creditCardNumber = orderDto.getCreditCardDetails().getCreditCardNumber().toString();
		this.creditCardSecurityCode = orderDto.getCreditCardDetails().getCreditCardSecurityCode().toString();
		this.creditCardType = orderDto.getCreditCardDetails().getCreditCardName();
	}



	public String getCreditCardExpirationDate() {
		return creditCardExpirationDate;
	}



	public void setCreditCardExpirationDate(String creditCardExpirationDate) {
		this.creditCardExpirationDate = creditCardExpirationDate;
	}



	public String getCreditCardHolderName() {
		return creditCardHolderName;
	}



	public void setCreditCardHolderName(String creditCardHolderName) {
		this.creditCardHolderName = creditCardHolderName;
	}



	public String getCreditCardNumber() {
		return creditCardNumber;
	}



	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}



	public String getCreditCardSecurityCode() {
		return creditCardSecurityCode;
	}



	public void setCreditCardSecurityCode(String creditCardSecurityCode) {
		this.creditCardSecurityCode = creditCardSecurityCode;
	}



	public String getCreditCardType() {
		return creditCardType;
	}



	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}


}
