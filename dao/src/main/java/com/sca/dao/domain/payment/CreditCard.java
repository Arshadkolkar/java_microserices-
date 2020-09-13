/**
 * 
 */
package com.sca.dao.domain.payment;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sca.dao.domain.common.BaseEntity;
import com.sca.dao.domain.security.User;

@Entity(name = "creditCard")
@Table(name = "credit_card")
public class CreditCard extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "credit_card_id")
	private Long creditCardId;

	@ManyToOne
	@JoinColumn(name = "sca_user_id", referencedColumnName = "sca_user_id", nullable = true)
	private User user;

	@Column(name = "is_default")
	private boolean isDefault;

	@Column(name = "credit_card_holder_name")
	private String creditCardHolderName;
	
	@Column(name = "credit_card_number")
	private Long creditCardNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "credit_card_type_id", referencedColumnName = "credit_card_type_id", nullable = true)
	private CreditCardType creditCardType;
	
	@Column(name = "credit_card_security_code")
	private Integer creditCardSecurityCode;
	
	@Column(name = "credit_card_expiry_date")
	private String creditCardExpiryDate;

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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the isDefault
	 */
	public boolean isDefault() {
		return isDefault;
	}

	/**
	 * @param isDefault the isDefault to set
	 */
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * @return the creditCardHolderName
	 */
	public String getCreditCardHolderName() {
		return creditCardHolderName;
	}

	/**
	 * @param creditCardHolderName the creditCardHolderName to set
	 */
	public void setCreditCardHolderName(String creditCardHolderName) {
		this.creditCardHolderName = creditCardHolderName;
	}

	/**
	 * @return the creditCardNumber
	 */
	public Long getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * @param creditCardNumber the creditCardNumber to set
	 */
	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	/**
	 * @return the creditCardType
	 */
	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	/**
	 * @param creditCardType the creditCardType to set
	 */
	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	/**
	 * @return the creditCardSecurityCode
	 */
	public Integer getCreditCardSecurityCode() {
		return creditCardSecurityCode;
	}

	/**
	 * @param creditCardSecurityCode the creditCardSecurityCode to set
	 */
	public void setCreditCardSecurityCode(Integer creditCardSecurityCode) {
		this.creditCardSecurityCode = creditCardSecurityCode;
	}

	/**
	 * @return the creditCardExpiryDate
	 */
	public String getCreditCardExpiryDate() {
		return creditCardExpiryDate;
	}

	/**
	 * @param creditCardExpiryDate the creditCardExpiryDate to set
	 */
	public void setCreditCardExpiryDate(String creditCardExpiryDate) {
		this.creditCardExpiryDate = creditCardExpiryDate;
	}
	
}