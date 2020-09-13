package com.sca.common.exception.payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sca.common.exception.ErrorCodes;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.response.ValidationError;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.payment.CreditCardDto;

public class PaymentValidationException extends InvalidInputException {

	private static final long serialVersionUID = 1L;

	public void getCreditCardValitionErrors(CreditCardDto creditCardDto) throws InvalidInputException {

		long creditCardNumber = creditCardDto.getCreditCardNumber();
		int creditCardSize = getCreditCardSize(creditCardNumber);

		List<ValidationError> validationErrors = new ArrayList<ValidationError>();

		// Validate Card Holder Name
		if (creditCardDto.getCreditCardHolderName() == null || creditCardDto.getCreditCardHolderName().isEmpty()
				|| creditCardDto.getCreditCardHolderName().isBlank()) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Credit card name should not be blank or empty");
			validationErrors.add(validationError);

			// Validate Special Character of Credit Card Holder Name
		} else {
			String creditCardHolderName = creditCardDto.getCreditCardHolderName().replaceAll("\\s", "");
			Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
			Matcher matcher = pattern.matcher(creditCardHolderName);
			boolean isStringContainsSpecialCharacter = matcher.find();
			if (isStringContainsSpecialCharacter) {
				ValidationError validationError = new ValidationError();
				validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
				validationError.setMessage("Credit card name contain special character");
				validationErrors.add(validationError);
			}
		}

		// if Credit card number is blank or empty
		if (creditCardSize == 0) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Credit card should not be blank or empty.");
			validationErrors.add(validationError);

			// checking Credit card number is 15
		} else if (creditCardSize == 15 && creditCardDto.getCreditCardTypeId() == 2) {

			// checking credit card number which has 15 digits number but not started with
			// 3.
			if (!prefixMatched(creditCardNumber, 3)) {
				ValidationError validationError = new ValidationError();
				validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
				validationError.setMessage("American Express card can be start with 3 only");
				validationErrors.add(validationError);
			}

			// credit card number size is 16
		} else if (creditCardSize == 16) {

			// checking credit card number which has 16 digits number but not started with
			// 4, 5, and 6.
			if (!((prefixMatched(creditCardNumber, 4) && creditCardDto.getCreditCardTypeId() == 3) || (prefixMatched(creditCardNumber, 5) && creditCardDto.getCreditCardTypeId() == 4) || (prefixMatched(creditCardNumber, 6) && creditCardDto.getCreditCardTypeId() == 1))) {
  
				ValidationError validationError = new ValidationError();
				validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());

				// Discover - 6
				if (creditCardDto.getCreditCardTypeId() == 1) {
					validationError.setMessage(creditCardDto.getCreditCardName() + " card can be start with 6");
					validationErrors.add(validationError);

					// American Express - 3 followed by 34 or 37
				} else if (creditCardDto.getCreditCardTypeId() == 2) {
					validationError.setMessage(creditCardDto.getCreditCardName() + " card can be start with 3");
					validationErrors.add(validationError);

					// Visa - 4
				} else if (creditCardDto.getCreditCardTypeId() == 3) {
					validationError.setMessage(creditCardDto.getCreditCardName() + " card can be start with 4");
					validationErrors.add(validationError);

					// Mastercard - 5.
				} else if (creditCardDto.getCreditCardTypeId() == 4) {
					validationError.setMessage(creditCardDto.getCreditCardName() + " card can be start with 5");
					validationErrors.add(validationError);
				}

			}

			// credit card number size is less than 15
		} else if (creditCardSize <= 15) {

			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());

			if (creditCardDto.getCreditCardTypeId() == 1 || creditCardDto.getCreditCardTypeId() == 3
					|| creditCardDto.getCreditCardTypeId() == 4) {

				validationError.setMessage(creditCardDto.getCreditCardName() + " card cannot be less than 16 digits");
				validationErrors.add(validationError);
			} else if (creditCardDto.getCreditCardTypeId() == 2) {

				validationError.setMessage(creditCardDto.getCreditCardName() + " card cannot be less than 15 digits");
				validationErrors.add(validationError);
			}

			// credit card number size is more than 16
		} else {

			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());

			if (creditCardDto.getCreditCardTypeId() == 1 || creditCardDto.getCreditCardTypeId() == 3
					|| creditCardDto.getCreditCardTypeId() == 4) {

				validationError.setMessage(creditCardDto.getCreditCardName() + " card cannot be more than 16 digits");
				validationErrors.add(validationError);
			} else if (creditCardDto.getCreditCardTypeId() == 2) {

				validationError.setMessage(creditCardDto.getCreditCardName() + " card cannot be more than 15 digits");
				validationErrors.add(validationError);
			}

		}

		// Credit Card ccv validation
		int creditSecurityCodeSize = getCreditCardSize(creditCardDto.getCreditCardSecurityCode());

		if (creditSecurityCodeSize == 0) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("ccv number should not be blank or empty");
			validationErrors.add(validationError);
		}else if (creditSecurityCodeSize < 3) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("ccv number should not be less than 3 digits");
			validationErrors.add(validationError);
		}

		// Validate expiry date
		if (creditCardDto.getCreditCardExpiryDate() == null || creditCardDto.getCreditCardExpiryDate().isEmpty()
				|| creditCardDto.getCreditCardExpiryDate().isBlank()) {
			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("Expiry date should not be empty or blank");
			validationErrors.add(validationError);
		} else {
			if (creditCardDto.getCreditCardExpiryDate().length() < 7) {
				ValidationError validationError = new ValidationError();
				validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
				validationError.setMessage("Expiry date should have proper format of DD/YYYY");
				validationErrors.add(validationError);
			}
		}

		// Validation Errors List is greater than 0
		if (validationErrors.size() > 0) {
			InvalidInputException invalidInputException = new InvalidInputException();
			ValidationResponse validationResponse = invalidInputException.getValidationResponse();
			validationResponse.setValidationErrorList(validationErrors);
			Map<String, Object> additionalMessage = new HashMap<>();
			for (int i = 0; i < validationErrors.size(); i++) {
				additionalMessage.put(i + "", validationErrors.get(i).getMessage());
				validationResponse.setAdditionalData(additionalMessage);
			}
			throw invalidInputException;
		}

	}

	// fetching credit card size
	public int getCreditCardSize(long creditCardNumber) {

		String creditCardLength = creditCardNumber + "";
		return creditCardLength.length();
	}

	// whether credit card number is start with correct digits or not
	public boolean prefixMatched(long creditCardNumber, int digits) {

		return getCreditCardPrefix(creditCardNumber, getCreditCardSize(digits)) == digits;
	}

	// returning start digits of card number
	public long getCreditCardPrefix(long creditCardNumber, int digits) {

		if (getCreditCardSize(creditCardNumber) > digits) {
			String creditCardChangedToNumber = creditCardNumber + "";
			return Long.parseLong(creditCardChangedToNumber.substring(0, digits));
		}

		return creditCardNumber;
	}

}
