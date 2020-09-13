/**
 * 
 */
package com.sca.dto.location;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.modelmapper.ModelMapper;

import com.sca.dao.domain.location.Country;

/**
 * 
 * @author subhash
 *
 */
public class CountryDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer countryId;
	private String name;
	private String displayName;
	List<StateDto> states;

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public List<StateDto> getStates() {
		return states;
	}

	public void setStates(List<StateDto> states) {
		this.states = states;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}

	public Country convertToEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, Country.class);
	}

}
