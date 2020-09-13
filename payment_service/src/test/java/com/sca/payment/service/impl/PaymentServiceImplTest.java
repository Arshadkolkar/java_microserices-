package com.sca.payment.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sca.dao.domain.payment.CreditCard;
import com.sca.dao.domain.payment.CreditCardType;
import com.sca.dao.domain.security.User;
import com.sca.dao.repository.payment.PaymentRepository;
import com.sca.dto.payment.CreditCardDto;

class PaymentServiceImplTest {

	@InjectMocks
	PaymentServiceImpl paymentService;
	
	@Mock
	PaymentRepository paymentRepository;

	CreditCard creditCard = null;
	List<CreditCard> crditCardList = null;
	CreditCardDto creditCardDto = null;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		creditCard = new CreditCard();
		creditCard.setCreditCardHolderName("Nirvaan");
		creditCard.setCreditCardNumber(1234567891234560L);
		creditCard.setCreditCardSecurityCode(123);
		creditCard.setCreditCardExpiryDate("12/23");


		User user = new User();
		user.setScaUserId(1L);

		creditCard.setUser(user);

		CreditCardType cct = new CreditCardType();
		cct.setCreditCardTypeId(3);
		cct.setDisplayName("Visa");
		creditCard.setCreditCardType(cct);
		
        crditCardList  = new ArrayList<>();
		
		crditCardList.add(creditCard);
		
		creditCardDto = new CreditCardDto();
		creditCardDto.setCreditCardHolderName("Buddha");
		creditCardDto.setCreditCardNumber(1234567891234560L);
		creditCardDto.setCreditCardSecurityCode(123);
		creditCardDto.setCreditCardExpiryDate("12/23");
		creditCardDto.setScaUserId(1L);
		creditCardDto.setCreditCardName("Visa");
	}

	@Test
	final void testGetCreditCardByUserId() {
		
		when(paymentRepository.getOne( any() )).thenReturn(creditCard);
		
		CreditCardDto creditCardDto = paymentService.getCreditCardById(null, 1L);
		
		assertNotNull(creditCardDto);
		
		assertEquals("Nirvaan", creditCardDto.getCreditCardHolderName());
		
	}
	
	@Test
	final void testGetUserCreditCards() {
		
		when(paymentRepository.findByUser( any() )).thenReturn(crditCardList);
		
		List<CreditCardDto> CreditCardDtoList = paymentService.getUserCreditCards(null, 1L);
		
		assertNotNull(CreditCardDtoList);
		
		assertEquals("Nirvaan", CreditCardDtoList.get(0).getCreditCardHolderName());
	}
	 
	@Test
	final void testCreateCreditCard() {
		
		paymentRepository.save( creditCard );
		
		User user = new User();
		user.setScaUserId(1L);
		
		List<CreditCard> creditCardList = paymentRepository.findByUser(user);
		
		assertNotNull(creditCardList);
		
		assertEquals(1, creditCardList.size());
	}

}
