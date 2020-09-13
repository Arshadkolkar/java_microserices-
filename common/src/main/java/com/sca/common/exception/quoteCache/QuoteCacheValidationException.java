package com.sca.common.exception.quoteCache;

import java.util.ArrayList;
import java.util.List;

import com.sca.common.exception.ErrorCodes;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.response.ValidationError;
import com.sca.dto.order.QuoteCacheDto;

public class QuoteCacheValidationException extends InvalidInputException {

	private static final long serialVersionUID = 1L;

	public QuoteCacheValidationException(QuoteCacheDto quoteCacheDto) {

		List<ValidationError> validationErrors = new ArrayList<ValidationError>();

		if ((quoteCacheDto.getWmqId() == null) || (quoteCacheDto.getWmqId().isEmpty())) {

			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("wmqId cannot be null");
			validationErrors.add(validationError);

		}

		if ((quoteCacheDto.getDesignFile() == null) || (quoteCacheDto.getDesignFile().isEmpty())) {

			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("designFile cannot be null");
			validationErrors.add(validationError);

		}
		if ((quoteCacheDto.getElectricalTestingCost() == null)
				|| (quoteCacheDto.getElectricalTestingCost().isEmpty())) {

			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("electricalTestingCost cannot be null");
			validationErrors.add(validationError);

		}
		if ((quoteCacheDto.getQuoteRequestJSON() == null) || (quoteCacheDto.getQuoteRequestJSON().isEmpty())) {

			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("quoteRequestJSON cannot be null");
			validationErrors.add(validationError);

		}
		if ((quoteCacheDto.getQuoteResponsePriceMatrixJSON() == null)
				|| (quoteCacheDto.getQuoteResponsePriceMatrixJSON().isEmpty())) {

			ValidationError validationError = new ValidationError();
			validationError.setCode(ErrorCodes.InvalidInput.getStatusCode());
			validationError.setMessage("quoteResponsePriceMatrixJSON cannot be null");
			validationErrors.add(validationError);

		}

		if (validationErrors.size() > 0) {

			this.validationResponse.setValidationErrorList(validationErrors);

		}
	}

}
