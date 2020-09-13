package com.sca.payment.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sca.common.exception.InvalidInputException;
import com.sca.common.exception.payment.PaymentValidationException;
import com.sca.dao.repository.payment.PaymentRepository;
import com.sca.dto.payment.CreditCardDto;
import com.sca.payment.service.impl.PaymentServiceImpl;

public class PaymentValidationExceptionTest {
	
	@InjectMocks
	PaymentServiceImpl paymentService;
	
	@Mock
	PaymentRepository paymentRepository;
	
	CreditCardDto creditCardDto = null;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		creditCardDto = new CreditCardDto();
		creditCardDto.setCreditCardHolderName("Rahul");
		creditCardDto.setCreditCardNumber(123456789123456088L);
		creditCardDto.setCreditCardSecurityCode(165);
		creditCardDto.setCreditCardExpiryDate("12/2018");
		creditCardDto.setScaUserId(1L);
		creditCardDto.setCreditCardTypeId(1);
		creditCardDto.setCreditCardName("Discover");
	}

	@Test
	final void testCreateCreditCard(){
		
		PaymentValidationException paymentValidationException = new PaymentValidationException();
		
		InvalidInputException exception = assertThrows(InvalidInputException.class, () -> paymentValidationException.getCreditCardValitionErrors(creditCardDto));
		
		assertNotNull(exception);
		
		for (Map.Entry<String,Object> entry : exception.getValidationResponse().getAdditionalData().entrySet()) {
            
			if(entry.getValue().equals("Credit card name should not be blank or empty")) {
			    assertEquals("Credit card name should not be blank or empty", entry.getValue());
			}
			
			if(entry.getValue().equals("Credit card name contain special character")) {
			    assertEquals("Credit card name contain special character", entry.getValue());
			}
			
			if(entry.getValue().equals("Credit card should not be blank or empty."))
			    assertEquals("Credit card should not be blank or empty.", entry.getValue());
			
			if(entry.getValue().equals("Credit card type cannot be other than American Express card")) {
			    assertEquals("Credit card type cannot be other than American Express card", entry.getValue());
			}
			
			if(entry.getValue().equals("American Express card can be start with 3 only")) {
			    assertEquals("American Express card can be start with 3 only", entry.getValue());
			}
			
			if(entry.getValue().equals("Credit card type cannot be other than Visa card"))
			    assertEquals("Credit card type cannot be other than Visa card", entry.getValue());
			
			if(entry.getValue().equals("Credit card type cannot be other than Mastercard card")) {
			    assertEquals("Credit card type cannot be other than Mastercard card", entry.getValue());
			}
			
			if(entry.getValue().equals("Credit card type cannot be other than Discover card")) {
			    assertEquals("Credit card type cannot be other than Discover card", entry.getValue());
			}
			
			if(entry.getValue().equals("Security code should not be blank or less than 3 digits"))
			    assertEquals("Security code should not be blank or less than 3 digits", entry.getValue());
			
			if(entry.getValue().equals("Expiry date should not be empty or blank")) {
			    assertEquals("Expiry date should not be empty or blank", entry.getValue());
			}
			
			if(entry.getValue().equals("Expiry date should have proper format of mm/yyyy")) {
			    assertEquals("Expiry date should have proper format of mm/yyyy", entry.getValue());
			}
			
			if(entry.getValue().equals("Discover card can be start with 6"))
			    assertEquals("Discover card can be start with 6", entry.getValue());
			
			if(entry.getValue().equals("Visa card can be start with 4"))
			    assertEquals("Visa card can be start with 4", entry.getValue());
			
			if(entry.getValue().equals("Mastercard card can be start with 5"))
			    assertEquals("Mastercard card can be start with 5", entry.getValue());
			
			if(entry.getValue().equals("American Express card can be start with 3"))
			    assertEquals("American Express card can be start with 3", entry.getValue());
			
			if(entry.getValue().equals("Visa card cannot be less than 16 digits"))
			    assertEquals("Visa card cannot be less than 16 digits", entry.getValue());
			
			if(entry.getValue().equals("Mastercard card cannot be less than 16 digits"))
			    assertEquals("Mastercard card cannot be less than 16 digits", entry.getValue());
			
			if(entry.getValue().equals("Discover card cannot be less than 16 digits"))
			    assertEquals("Discover card cannot be less than 16 digits", entry.getValue());
			
			if(entry.getValue().equals("American Express card cannot be less than 15 digits"))
			    assertEquals("American Express card cannot be less than 15 digits", entry.getValue());
			
			if(entry.getValue().equals("Visa card cannot be more than 16 digits"))
			    assertEquals("Visa card cannot be more than 16 digits", entry.getValue());
			
			if(entry.getValue().equals("Mastercard card cannot be more than 16 digits"))
			    assertEquals("Mastercard card cannot be more than 16 digits", entry.getValue());
			
			if(entry.getValue().equals("Discover card cannot be more than 16 digits"))
			    assertEquals("Discover card cannot be more than 16 digits", entry.getValue());
			
			if(entry.getValue().equals("American Express card cannot be more than 15 digits"))
			    assertEquals("American Express card cannot be more than 15 digits", entry.getValue());
		}    
		
	}
}
