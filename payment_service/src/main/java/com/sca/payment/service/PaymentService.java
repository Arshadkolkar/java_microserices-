/**
 * 
 */
package com.sca.payment.service;

import java.util.List;

import com.sca.dto.payment.CreditCardDto;

/**
 * 
 * @author Jay
 *
 */
 
public interface PaymentService {

	/**
	 * 
	 * @param accessToken
	 * @param creditCard
	 */
	void createCreditCard(String accessToken, CreditCardDto creditCardDto);

	/**
	 * 
	 * @param accessToken
	 * @param creditCard
	 */
	void updateCreditCard(String accessToken, CreditCardDto creditCardDto);

	/**
	 * 
	 * @param accessToken
	 * @param creditCardId
	 * @return
	 */
	CreditCardDto getCreditCardById(String accessToken, Long creditCardId);

	/**
	 * 
	 * @param accessToken
	 * @param userId
	 * @return
	 */
	List<CreditCardDto> getUserCreditCards(String accessToken, Long userId);
	
	/**
	 * 
	 * @param accessToken
	 * @param creditCardId
	 */
	void deleteUserCreditCard(String accessToken, Long creditCardId);

}
