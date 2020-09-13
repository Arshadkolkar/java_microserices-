/**
 * 
 */
package com.sca.payment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sca.common.exception.ExceptionUtil;
import com.sca.common.exception.GenericException;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.payment.CreditCardDto;
import com.sca.payment.service.PaymentService;
import com.sca.payment.util.Constants;

/**
 * 
 * @author Jay
 *
 */
@RestController
@RequestMapping(Constants.PAYMENT_REST_URL)
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@Autowired
	private ExceptionUtil exceptionUtil;

	@PostMapping
	public ResponseEntity<ValidationResponse> createCreditCard(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestBody CreditCardDto creditCardDto) throws GenericException {

		ValidationResponse response = null;

		try {

			if (creditCardDto != null) {
				paymentService.createCreditCard(accessToken, creditCardDto);
			}

			response = new ValidationResponse();
			response.setMessage(creditCardDto);

		} catch (InvalidInputException invalidInputException) {
			response = invalidInputException.getValidationResponse();
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to create credit card");
		}

		return ResponseEntity.ok(response);

	}

	@PutMapping
	public ResponseEntity<ValidationResponse> updateCreditCard(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestBody CreditCardDto creditCardDto) throws GenericException {

		ValidationResponse response = null;

		try {

			if (creditCardDto != null) {
				paymentService.updateCreditCard(accessToken, creditCardDto);
			}

			response = new ValidationResponse();
			response.setMessage(creditCardDto);

		} catch (InvalidInputException invalidInputException) {
			response = invalidInputException.getValidationResponse();
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to update credit card");
		}

		return ResponseEntity.ok(response);

	}

	@GetMapping
	public ResponseEntity<CreditCardDto> getCreditCard(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "creditCardId", required = true) Long creditCardId) throws GenericException {

		CreditCardDto creditCardDto = null;

		try {

			if (creditCardId > 0) {
				creditCardDto = paymentService.getCreditCardById(accessToken, creditCardId);
			}

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get Credit Card for credit card id = " + creditCardId);
		}

		return ResponseEntity.ok(creditCardDto);
	}

	@GetMapping(value = "/{scaUserId}")
	public ResponseEntity<List<CreditCardDto>> getUserCreditCards(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@PathVariable(value = "scaUserId", required = true) Long scaUserId) throws GenericException {

		List<CreditCardDto> creditCardDtoList = null;

		try {

			if (scaUserId > 0) {
				creditCardDtoList = paymentService.getUserCreditCards(accessToken, scaUserId);
			} else {
				throw new InvalidInputException("Could not find list of credit card of sca user id =" + scaUserId);
			}

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get List of Credit Cards for sca user id = " + scaUserId);
		}

		return ResponseEntity.ok(creditCardDtoList);
	}

	@DeleteMapping
	public ResponseEntity<ValidationResponse> deleteUserCreditCard(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "creditCardId", required = true) Long creditCardId) throws GenericException {

		ValidationResponse response = null;

		try {

			if (creditCardId > 0) {
				paymentService.deleteUserCreditCard(accessToken, creditCardId);
			}

			response = new ValidationResponse();
			response.setMessage("Sucessfully deleted credit card id is " + creditCardId);

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to delete credit card");
		}

		return ResponseEntity.ok(response);
	}
}
