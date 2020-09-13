/**
 * 
 */
package com.sca.dto.security;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.sca.dto.security.UserDto;

/**
 * 
 * @author subhash
 *
 */
public class Users {

	@JacksonXmlElementWrapper(localName = "users")
	@JacksonXmlProperty(localName = "user")
	@JsonProperty("users")
	private List<UserDto> userList;

	public void setUserList(List<UserDto> userList) {
		this.userList = userList;
	}

	public void addUser(UserDto user) {

		if (userList == null) {
			userList = new ArrayList<UserDto>();
		}

		userList.add(user);
	}
}