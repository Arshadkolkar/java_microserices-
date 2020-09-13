/**
 * 
 */
package com.sca.dto.location;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.sca.dto.location.CountryDto;

/**
 * 
 * @author 
 *
 */
public class Countries {

	@JacksonXmlElementWrapper(localName = "countries")
	@JacksonXmlProperty(localName = "country")
	@JsonProperty("countries")
	private List<CountryDto> countryList;

	/**
	 * 
	 * @param countryList
	 */
	public void setcountryList(List<CountryDto> countryList) {
		this.countryList = countryList;
	}

	/**
	 * 
	 * @param country
	 */
	public void addCountry(CountryDto country) {

		if (countryList == null) {
			countryList = new ArrayList<CountryDto>();
		}

		countryList.add(country);
	}
}
