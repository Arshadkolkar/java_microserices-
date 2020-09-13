/**
 * 
 */
package com.sca.location.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.dao.domain.location.Country;
import com.sca.dao.domain.location.State;
import com.sca.dao.repository.location.CountryRepository;
import com.sca.dao.repository.location.StateRepository;
import com.sca.dto.location.StateDto;

/**
 * 
 * @author
 *
 */
@Service
@Transactional
public class StateServiceImpl implements com.sca.location.service.StateService {

	@Autowired
	private StateRepository stateRepository;

	/**
	 * 
	 */
	@Override
	public StateDto getStateByStateId(String accessToken, Integer stateId) {
		
		StateDto stateDto = null;

		if ((stateId != null) && (stateId > 0)) {

			State state = stateRepository.getOne(stateId);
			stateDto = this.copyToStateDto(null, state);

		}
		
		return stateDto;
	}

	private StateDto copyToStateDto(StateDto stateDto, State state) {

		if (state != null) {

			if (stateDto == null) {
				stateDto = new StateDto();
			}

			stateDto.setStateId(state.getStateId());
			stateDto.setName(state.getName());
			stateDto.setDisplayName(state.getDisplayName());
		}

		return stateDto;
	}

	/**
	 * 
	 */
	@Override
	public List<StateDto> getStates(String accessToken, Integer countryId) {

		List<StateDto> stateDtoList = null;

		Country country = new Country();
		country.setCountryId(countryId);

		List<State> stateList = stateRepository.findByCountry(country);

		if ((stateList != null) && (stateList.size() > 0)) {
			stateDtoList = new ArrayList<StateDto>();

			for (State state : stateList) {
				stateDtoList.add(this.copyToStateDto(null, state));
			}
		}

		return stateDtoList;
	}

	@Override
	public StateDto getStateByStateName(String accessToken, String stateName) {

		State state = stateRepository.findByName(stateName);
		StateDto stateDto = this.copyToStateDto(null, state);
		return stateDto;
	}

}
