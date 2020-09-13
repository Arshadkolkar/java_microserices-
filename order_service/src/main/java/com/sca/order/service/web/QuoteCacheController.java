/**
 * 
 */
package com.sca.order.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.sca.common.exception.ExceptionUtil;
import com.sca.common.exception.GenericException;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.order.QuoteCacheDto;
import com.sca.order.service.QuoteCacheService;
import com.sca.order.util.Constants;

/**
 * 
 * @author subhash
 *
 */
@RestController
@RequestMapping(Constants.QUOTE_CACHE_REST_URL)
public class QuoteCacheController {

	// private static final DiagnosticLogger logger =
	// DiagnosticLogger.getLogger(QuoteCacheController.class);

	@Autowired
	private ExceptionUtil exceptionUtil;

	@Autowired
	private QuoteCacheService quoteCacheService;

	/**
	 * 
	 * @param accessToken
	 * @param femsUserId
	 * @param quoteCacheDto
	 * @return
	 * @throws GenericException
	 */
	@PostMapping
	public ResponseEntity<ValidationResponse> saveQuoteCacheData(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestBody QuoteCacheDto quoteCacheDto) throws GenericException {

		ValidationResponse response = new ValidationResponse();

		try {
			quoteCacheService.saveQuoteCacheData(accessToken, quoteCacheDto);

			response = new ValidationResponse();
			response.setMessage(quoteCacheDto);
		} catch (InvalidInputException invalidInputException) {
			response = invalidInputException.getValidationResponse();
		} catch (Exception ex) {
			exceptionUtil.processException(ex,
					"Failed to save quote cache data for quote with wqid = " + quoteCacheDto.getWmqId());
		}

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @param accessToken
	 * @param wqid
	 * @return
	 * @throws GenericException
	 */
	@GetMapping
	public ResponseEntity<QuoteCacheDto> getQuoteCacheData(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "wmqId", required = true) String wmqId) throws GenericException {

		QuoteCacheDto quoteCacheDto = null;

		try {
			quoteCacheDto = quoteCacheService.getQuoteCacheData(accessToken, wmqId);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get quote cache details with wmqId = " + wmqId);
		}

		return ResponseEntity.ok(quoteCacheDto);
	}

	/**
	 * 
	 * @param accessToken
	 * @param wmqId
	 * @param userId
	 * @param quoteCacheDto
	 * @return quote details i.e price matrix and part information
	 * @throws GenericException
	 */
	@PostMapping(path = "/quote")
	public ResponseEntity<ValidationResponse> getQuoteDetails(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "wmqId", required = true) String wmqId,
			@RequestParam(value = "userId", required = true) String userId, @RequestBody QuoteCacheDto quoteCacheDto)
			throws GenericException {

		ValidationResponse response = new ValidationResponse();

		try {
			JsonNode partAndQuoteDetials = quoteCacheService.getQuoteDetails(accessToken, wmqId, userId, quoteCacheDto);

			response = new ValidationResponse();
			response.setMessage(partAndQuoteDetials);
		} catch (InvalidInputException ex) {
			response = ex.getValidationResponse();
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get quote details");
		}

		return ResponseEntity.ok(response);
	}
}
