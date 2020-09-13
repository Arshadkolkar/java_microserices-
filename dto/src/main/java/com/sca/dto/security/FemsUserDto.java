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
public class FemsUserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userID;
	private String firstName;
	private String lastName;
	private String registrationEmail;
	private String registrationCompany;
	private String phone;
	private String jobTitle;
	private String errorMessage;
	private String fax;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String webAccountManagerName;
	private String webAccountMangerEmail;
	private String webAccountManagerPhone;
	private String marketoScore;
	private String lifecycleTag;
	private String lastLoginDate;
	private String lastOrderDate;
	private String sdrname;
	private String memberID;
	private String password;

	public FemsUserDto() {

	}

	public FemsUserDto(UserDto userDto) {
		this.firstName = userDto.getFirstName();
		this.lastName = userDto.getLastName();
		this.registrationEmail = userDto.getEmail();
		this.registrationCompany = userDto.getCompanyName();
		this.phone = userDto.getPhoneNumber();
		this.jobTitle = userDto.getJobTitle();
		this.fax = userDto.getFax();
		this.addressLine1 = userDto.getAddressLine1();
		this.addressLine2 = userDto.getAddressLine2();
		this.city = userDto.getCity();
		this.state = userDto.getState();
		this.country = userDto.getCountry();
		this.zip = userDto.getZip();
		this.webAccountManagerName = userDto.getWebAccountManagerName();
		this.webAccountMangerEmail = userDto.getWebAccountMangerEmail();
		this.webAccountManagerPhone = userDto.getWebAccountManagerPhone();
		this.marketoScore = userDto.getMarketoScore();
		this.lifecycleTag = userDto.getLifecycleTag();
		this.lastLoginDate = userDto.getLogoutDate() != null ? userDto.getLogoutDate().toString() : "";
		this.lastOrderDate = userDto.getLastOrderDate() != null ? userDto.getLastOrderDate().toString() : "";
		this.sdrname = userDto.getSdrname();
		this.errorMessage = userDto.getErrorMessage();
	}

	public FemsUserDto(String email, String password) {
		this.memberID = email;
		this.password = password;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegistrationEmail() {
		return registrationEmail;
	}

	public void setRegistrationEmail(String registrationEmail) {
		this.registrationEmail = registrationEmail;
	}

	public String getRegistrationCompany() {
		return registrationCompany;
	}

	public void setRegistrationCompany(String registrationCompany) {
		this.registrationCompany = registrationCompany;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getWebAccountManagerName() {
		return webAccountManagerName;
	}

	public void setWebAccountManagerName(String webAccountManagerName) {
		this.webAccountManagerName = webAccountManagerName;
	}

	public String getWebAccountMangerEmail() {
		return webAccountMangerEmail;
	}

	public void setWebAccountMangerEmail(String webAccountMangerEmail) {
		this.webAccountMangerEmail = webAccountMangerEmail;
	}

	public String getWebAccountManagerPhone() {
		return webAccountManagerPhone;
	}

	public void setWebAccountManagerPhone(String webAccountManagerPhone) {
		this.webAccountManagerPhone = webAccountManagerPhone;
	}

	public String getMarketoScore() {
		return marketoScore;
	}

	public void setMarketoScore(String marketoScore) {
		this.marketoScore = marketoScore;
	}

	public String getLifecycleTag() {
		return lifecycleTag;
	}

	public void setLifecycleTag(String lifecycleTag) {
		this.lifecycleTag = lifecycleTag;
	}

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastOrderDate() {
		return lastOrderDate;
	}

	public void setLastOrderDate(String lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}

	public String getSdrname() {
		return sdrname;
	}

	public void setSdrname(String sdrname) {
		this.sdrname = sdrname;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
