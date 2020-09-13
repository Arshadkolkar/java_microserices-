package com.sca.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.sca.common.exception.GenericException;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.payment.CreditCardDto;
import com.sca.payment.service.PaymentService;
import com.sca.payment.web.PaymentController;

@ContextConfiguration({ "classpath:springDispatcher-servlet.xml" })
class ScaPaymentServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	PaymentController paymentController;

	@Mock
	PaymentService paymentService;

	CreditCardDto creditCardDto;

	private Long creditCardId = 3L;

	List<CreditCardDto> creditCardList = null;

	private Long userId = 1L;

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		creditCardDto = new CreditCardDto();
		creditCardDto.setCreditCardHolderName("Nirvaan");
		creditCardDto.setCreditCardNumber(1234567891234560L);
		creditCardDto.setCreditCardSecurityCode(123);
		creditCardDto.setCreditCardExpiryDate("12/23");
		creditCardDto.setScaUserId(1L);
		creditCardDto.setCreditCardName("Visa");

	}

	@Test
	public void testCreateCreditCard() throws GenericException {

		paymentService.createCreditCard(null, creditCardDto);

		ResponseEntity<ValidationResponse> response = paymentController.createCreditCard(null, creditCardDto);

		assertNotNull(response);

		assertEquals(200, response.getStatusCodeValue());

	}

	@Test
	public void testUpdateCreditCard() throws Exception {

		paymentService.updateCreditCard(null, creditCardDto);

		ResponseEntity<ValidationResponse> response = paymentController.updateCreditCard(null, creditCardDto);
		
		assertNotNull(response);

		assertEquals(200, response.getStatusCodeValue());

	}

	@Test
	final void testGetCreditCardByUserId() throws GenericException {

		when(paymentService.getCreditCardById(null, creditCardId)).thenReturn(creditCardDto);

		ResponseEntity<CreditCardDto> creditCardDto = paymentController.getCreditCard(null, userId);

		assertNotNull(creditCardDto);

		assertEquals(200, creditCardDto.getStatusCodeValue());
	}

	@Test
	final void testGetUserCreditCards() throws GenericException {

		when(paymentService.getUserCreditCards(null, userId)).thenReturn(creditCardList);

		ResponseEntity<List<CreditCardDto>> CreditCardDtoList = paymentController.getUserCreditCards(null, userId);

		assertNotNull(CreditCardDtoList);

		assertEquals(200, CreditCardDtoList.getStatusCodeValue());
	}

}
