/**
 * 
 */
package com.sca.dto.security;

import java.io.Serializable;

/**
 * 
 * @author
 *
 */
public class FemsUserRegisterDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String memberId;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String userID;
	private String companyName;
	

	public FemsUserRegisterDto() {

	}

	public FemsUserRegisterDto(UserDto userDto) {
		this.memberId = userDto.getMemberId();
		this.password = userDto.getPassword();
		this.firstName = userDto.getFirstName();
		this.lastName = userDto.getLastName();
		this.email = userDto.getEmail();
		this.companyName = userDto.getCompanyName();
		this.phoneNumber = userDto.getPhoneNumber();
		this.userID = userDto.getUserId();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
}
