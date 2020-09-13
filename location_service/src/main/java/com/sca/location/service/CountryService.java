/**
 * 
 */
package com.sca.location.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.dto.location.CountryDto;

/**
 * 
 * @author subhash
 *
 */
@Service
@Transactional
public interface CountryService {

	/**
	 * 
	 * @param accessToken
	 * @param countryId
	 * @return
	 */
	CountryDto getCountryByCountryId(String accessToken, Integer countryId);

	/**
	 * 
	 * @param accessToken
	 * @param countryName
	 * @return
	 */
	CountryDto getCountryByCountryName(String accessToken, String countryName);

	/**
	 * 
	 * @param accessToken
	 * @return
	 */
	List<CountryDto> getAllCountries(String accessToken);

}
