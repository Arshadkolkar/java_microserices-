package com.sca.dto.location;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.sca.dto.location.StateDto;

public class States {

	@JacksonXmlElementWrapper(localName = "states")
	@JacksonXmlProperty(localName = "state")
	@JsonProperty("states")
	private List<StateDto> stateList;

	public void setStateList(List<StateDto> stateList) {
		this.stateList = stateList;
	}

	public void addUser(StateDto state) {

		if (stateList == null) {
			stateList = new ArrayList<StateDto>();
		}

		stateList.add(state);
	}
}
