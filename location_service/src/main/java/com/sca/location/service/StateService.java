/**
 * 
 */
package com.sca.location.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.dto.location.CountryDto;
import com.sca.dto.location.StateDto;

/**
 * 
 * @author subhash
 *
 */
@Service
@Transactional
public interface StateService {

	/**
	 * 
	 * @param accessToken
	 * @param countryId
	 * @return
	 */
	List<StateDto> getStates(String accessToken, Integer countryId);
	
	/**
	 * 
	 * @param accessToken
	 * @param stateName
	 * @return
	 */
	
	StateDto getStateByStateName(String accessToken, String stateName);

	/**
	 * 
	 * @param accessToken
	 * @param stateId
	 * @return
	 */
	StateDto getStateByStateId(String accessToken, Integer stateId);

}
