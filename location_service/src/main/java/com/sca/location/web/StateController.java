/**
 * This is a controller class that provides REST APIs to manage State data
 */
package com.sca.location.web;

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
import com.sca.common.response.ValidationResponse;
import com.sca.dto.location.StateDto;
import com.sca.dto.location.States;
import com.sca.location.service.StateService;
import com.sca.location.util.Constants;

/**
 * 
 * @author
 *
 */
@RestController
@RequestMapping(Constants.STATE_REST_URL)
public class StateController {

//	private static final DiagnosticLogger logger = DiagnosticLogger.getLogger(StateController.class);

	@Autowired
	private StateService stateService;

	@Autowired
	private ExceptionUtil exceptionUtil;

	/**
	 * This method returns State by StateId
	 * 
	 * @param accessToken
	 * @param stateId
	 * @return
	 * @throws GenericException
	 */
	@GetMapping(value = "/{stateId}")
	public ResponseEntity<StateDto> getStateByStateId(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@PathVariable(value = "stateId", required = false) Integer stateId) throws GenericException {

		StateDto stateDto = null;

		try {

			if (stateId > 0) {
				stateDto = stateService.getStateByStateId(accessToken, stateId);
			}

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get State details for state Id = " + stateId);
		}

		return ResponseEntity.ok(stateDto);
	}

	/**
	 * This method returns States by CountryId
	 * 
	 * @param accessToken
	 * @param countryId
	 * @return
	 * @throws GenericException
	 */
	@GetMapping
	public ResponseEntity<ValidationResponse> getStatesByCountryId(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "countryId", required = true) Integer countryId) throws GenericException {

		ValidationResponse response = null;
		States states = null;

		try {

			if (countryId > 0) {

				List<StateDto> stateList = stateService.getStates(accessToken, countryId);
				states = new States();
				states.setStateList(stateList);
			}

			response = new ValidationResponse();
			response.setMessage(states);
			response.setSuccess(true);

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get states for countryId =" + countryId);
		}

		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/state")
	public ResponseEntity<StateDto> getStateByStateName(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "stateName", required = true) String stateName) throws GenericException {

		StateDto stateDto = null;

		try {

			if (stateName!= null) {
				stateDto = stateService.getStateByStateName(accessToken, stateName);
			}

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get State details for state name = " + stateName);
		}

		return ResponseEntity.ok(stateDto);
	}

}
