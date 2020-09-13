/** 
 * This is a controller class that provides REST APIs to manage Country data
 */
package com.sca.location.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sca.common.exception.ExceptionUtil;
import com.sca.common.exception.GenericException;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.location.Countries;
import com.sca.dto.location.CountryDto;
import com.sca.location.service.CountryService;
import com.sca.location.util.Constants;

/**
 * 
 * @author
 *
 */
@RestController
@RequestMapping(Constants.COUNTRY_REST_URL)
public class CountryController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private ExceptionUtil exceptionUtil;

	/**
	 * This method returns Country by CountryId
	 * 
	 * @param accessToken
	 * @param countryId
	 * @return
	 * @throws GenericException
	 */
	@GetMapping(value = "/{countryId}")
	public ResponseEntity<CountryDto> getCountryByCountryId(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@PathVariable(value = "countryId", required = true) Integer countryId) throws GenericException {

		CountryDto countryDto = null;

		try {

			if (countryId > 0) {
				countryDto = countryService.getCountryByCountryId(accessToken, countryId);
			}

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get User details for User Id = " + countryId);
		}

		return ResponseEntity.ok(countryDto);
	}

	/**
	 * This method returns all Countries
	 * 
	 * @param accessToken
	 * @param countryName
	 * @return
	 * @throws GenericException
	 */
	@GetMapping
	public ResponseEntity<ValidationResponse> getAllCountries(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "countryName", required = false) String countryName) throws GenericException {

		ValidationResponse response = null;
		Countries countries = null;

		try {

			List<CountryDto> countryList = null;

			if (countryName != null) {
				countryList = new ArrayList<CountryDto>();
				countryList.add(countryService.getCountryByCountryName(accessToken, countryName));
			} else {
				countryList = countryService.getAllCountries(accessToken);
			}

			if ((countryList == null) || (countryList.size() < 1)) {
				throw new InvalidInputException("No countries found for search criteria");
			} else {
				countries = new Countries();
				countries.setcountryList(countryList);
			}

			response = new ValidationResponse();
			response.setMessage(countries);
			response.setSuccess(true);

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get States");
		}

		return ResponseEntity.ok(response);
	}

}
