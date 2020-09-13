/**
 * 
 */
package com.sca.payment.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.common.exception.InvalidInputException;
import com.sca.common.exception.payment.PaymentValidationException;
import com.sca.dao.domain.common.EntityStatusEnum;
import com.sca.dao.domain.payment.CreditCard;
import com.sca.dao.domain.payment.CreditCardType;
import com.sca.dao.domain.security.User;
import com.sca.dao.repository.payment.PaymentRepository;
import com.sca.dto.payment.CreditCardDto;
import com.sca.payment.service.PaymentService;

/**
 * 
 * @author Jay
 *
 */
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	private PaymentValidationException paymentValidationException = new PaymentValidationException();

	/**
	 * This service save credit card details.
	 * 
	 * @param accessToken
	 * @param femsUserId
	 * @param creditCardDto
	 */
	@Override
	public void createCreditCard(String accessToken, CreditCardDto creditCardDto) throws InvalidInputException {

		paymentValidationException.getCreditCardValitionErrors(creditCardDto);

		if (creditCardDto.getScaUserId() != null) {
			CreditCard creditCard = new CreditCard();

			// Passing User for user Id
			User user = new User();
			user.setScaUserId(creditCardDto.getScaUserId());
			creditCard.setUser(user);

			// Credit Card information
			creditCard.setCreditCardNumber(creditCardDto.getCreditCardNumber());

			creditCard.setCreditCardHolderName(creditCardDto.getCreditCardHolderName().replaceAll("\\s", ""));
			creditCard.setCreditCardSecurityCode(creditCardDto.getCreditCardSecurityCode());
			creditCard.setCreditCardExpiryDate(creditCardDto.getCreditCardExpiryDate());

			// Credit Card Type Information
			CreditCardType creditCardType = new CreditCardType();
			creditCardType.setCreditCardTypeId(creditCardDto.getCreditCardTypeId());
			creditCard.setCreditCardType(creditCardType);

			// Base Entity Information
			creditCard.setEntityStatusId(EntityStatusEnum.DRAFT.getValue());
			creditCard.setIsActive(true);
			creditCard.setCreatedDate(Calendar.getInstance());

			if (creditCardDto.isDefaultCreditCard()) {
				paymentRepository.changeDefaultPayment(creditCardDto.getScaUserId());
			}

			creditCard.setDefault(creditCardDto.isDefaultCreditCard());

			paymentRepository.save(creditCard);

			creditCardDto.setCreditCardId(creditCard.getCreditCardId());
			creditCardDto.setActiveCreditCard(creditCard.getIsActive());
			creditCardDto.setDefaultCreditCard(creditCard.isDefault());
		}

	}

	/**
	 * This service update credit card details.
	 * 
	 * @param accessToken
	 * @param femsUserId
	 * @param creditCardDto
	 */
	@Override
	public void updateCreditCard(String accessToken, CreditCardDto creditCardDto) {

		paymentValidationException.getCreditCardValitionErrors(creditCardDto);

		CreditCard creditCard = paymentRepository.getOne(creditCardDto.getCreditCardId());

		if (creditCard != null) {

			// Passing User Id to Credit Card
			User user = new User();
			user.setScaUserId(creditCardDto.getScaUserId());
			creditCard.setUser(user);

			// Information coming for update to Credit card
			creditCard.setCreditCardNumber(creditCardDto.getCreditCardNumber());
			creditCard.setCreditCardHolderName(creditCardDto.getCreditCardHolderName().replaceAll("\\s", ""));
			creditCard.setCreditCardSecurityCode(creditCardDto.getCreditCardSecurityCode());
			creditCard.setCreditCardExpiryDate(creditCardDto.getCreditCardExpiryDate());

			// Credit Card Type update
			CreditCardType creditCardType = new CreditCardType();
			creditCardType.setCreditCardTypeId(creditCardDto.getCreditCardTypeId());
			creditCard.setCreditCardType(creditCardType);

			if (creditCardDto.isDefaultCreditCard()) {

				paymentRepository.changeDefaultPayment(creditCardDto.getScaUserId());

			}

			creditCard.setDefault(creditCardDto.isDefaultCreditCard());

			creditCard.setIsActive(true);
			// Base Entity Information
			creditCard.setUpdatedDate(Calendar.getInstance());

			paymentRepository.save(creditCard);
		}

	}

	/**
	 * This service can fetch details of particular credit card details.
	 * 
	 * @param accessToken
	 * @param femsUserId
	 * @param creditCardId
	 * @return
	 */
	@Override
	public CreditCardDto getCreditCardById(String accessToken, Long creditCardId) throws InvalidInputException {

		CreditCard creditCard = paymentRepository.getOne(creditCardId);
		CreditCardDto creditCardDto = null;

		if (creditCard != null) {

			if (creditCard.getIsActive())
				creditCardDto = this.copyToCreditCardDto(null, creditCard);

		}

		if (creditCardDto == null) {
			throw new InvalidInputException("Could not find any credit card details");
		}

		return creditCardDto;
	}

	/**
	 * This service can fetch details of all credit card details of particular user.
	 * 
	 * @param accessToken
	 * @param femsUserId
	 * @param scaUserId
	 * @return
	 */
	@Override
	public List<CreditCardDto> getUserCreditCards(String accessToken, Long scaUserId) throws InvalidInputException {

		List<CreditCardDto> creditCardList = new ArrayList<>();

		User user = new User();
		user.setScaUserId(scaUserId);

		List<CreditCard> creditCards = paymentRepository.findByUser(user);

		if (creditCards != null) {

			for (CreditCard creditCard : creditCards) {

				CreditCardDto creditCardDto = null;

				if (creditCard.getIsActive()) {
					creditCardDto = this.copyToCreditCardDto(null, creditCard);
					creditCardList.add(creditCardDto);
				}
			}
		}

		if (creditCardList.isEmpty()) {
			throw new InvalidInputException("Could not find list of credit card of sca user id =" + scaUserId);
		}

		return creditCardList;
	}

	/**
	 * This method copy credit card info into credit card DTO.
	 * 
	 * @param creditCardDto
	 * @param creditCard
	 * @return
	 */

	private CreditCardDto copyToCreditCardDto(CreditCardDto creditCardDto, CreditCard creditCard) {

		if (creditCard != null) {

			if (creditCardDto == null) {
				creditCardDto = new CreditCardDto();
			}
			creditCardDto.setScaUserId(creditCard.getUser().getScaUserId());
			creditCardDto.setCreditCardId(creditCard.getCreditCardId());
			creditCardDto.setCreditCardNumber(creditCard.getCreditCardNumber());
			creditCardDto.setCreditCardHolderName(creditCard.getCreditCardHolderName());
			creditCardDto.setCreditCardTypeId(creditCard.getCreditCardType().getCreditCardTypeId());
			creditCardDto.setCreditCardName(creditCard.getCreditCardType().getDisplayName());
			creditCardDto.setCreditCardSecurityCode(creditCard.getCreditCardSecurityCode());
			creditCardDto.setCreditCardExpiryDate(creditCard.getCreditCardExpiryDate());
			creditCardDto.setDefaultCreditCard(creditCard.isDefault());
			creditCardDto.setActiveCreditCard(creditCard.getIsActive());

		}

		return creditCardDto;
	}

	/**
	 * delete Credit card Id
	 */
	@Override
	public void deleteUserCreditCard(String accessToken, Long creditCardId) {

		CreditCard creditCard = paymentRepository.getOne(creditCardId);

		if (creditCard != null) {
			creditCard.setIsActive(false);
			paymentRepository.save(creditCard);
		}

	}

}
