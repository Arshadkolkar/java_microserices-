package com.sca.location.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.dao.domain.location.Country;
import com.sca.dao.repository.location.CountryRepository;
import com.sca.dao.repository.location.StateRepository;
import com.sca.dto.location.CountryDto;

@Service
@Transactional
public class CountryServiceImpl implements com.sca.location.service.CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Override
	public CountryDto getCountryByCountryId(String accessToken, Integer countryId) {

		CountryDto countryDto = null;
		if ((countryId != null) && (countryId > 0)) {
			Country country = countryRepository.getOne(countryId);
			countryDto = this.copyToCountryDto(null, country);
		}

		return countryDto;
	}

	private CountryDto copyToCountryDto(CountryDto countryDto, Country country) {

		if (country != null) {

			if (countryDto == null) {
				countryDto = new CountryDto();
			}

			countryDto.setCountryId(country.getCountryId());
			countryDto.setName(country.getName());
			countryDto.setDisplayName(country.getDisplayName());
			countryDto.setCountryId(country.getCountryId());

		}

		return countryDto;
	}

	@Override
	public CountryDto getCountryByCountryName(String accessToken, String countryName) {

		CountryDto countryDto = null;
		if (countryName != null) {
			Country country = countryRepository.findByName(countryName);
			countryDto = this.copyToCountryDto(null, country);
		}
		return countryDto;
	}

	@Override
	public List<CountryDto> getAllCountries(String accessToken) {

		List<CountryDto> countryDtoList = null;

		List<Country> countryList = countryRepository.findAll();

		if ((countryList != null) && (countryList.size() > 0)) {
			countryDtoList = new ArrayList<CountryDto>();

			for (Country country : countryList) {
				countryDtoList.add(this.copyToCountryDto(null, country));
			}
		}

		return countryDtoList;
	}

}
