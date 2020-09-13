/**
 * 
 */
package com.sca.dao.domain.payment;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "credit_card_type")
public class CreditCardType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "credit_card_type_id")
	private Integer creditCardTypeId;

	@OneToMany(mappedBy = "creditCardType", cascade = CascadeType.ALL)
	private List<CreditCard> creditCards;

	@Column(name = "name")
	private String name;

	@Column(name = "display_name")
	private String displayName;

	/**
	 * @return the creditCardTypeId
	 */
	public Integer getCreditCardTypeId() {
		return creditCardTypeId;
	}

	/**
	 * @param creditCardTypeId the creditCardTypeId to set
	 */
	public void setCreditCardTypeId(Integer creditCardTypeId) {
		this.creditCardTypeId = creditCardTypeId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the creditCards
	 */
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	/**
	 * @param creditCards the creditCards to set
	 */
	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

}