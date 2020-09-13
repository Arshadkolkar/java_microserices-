/**
 * 
 */
package com.sca.dto.security;

import java.io.Serializable;
import java.util.Calendar;

import org.modelmapper.ModelMapper;

import com.sca.dao.domain.security.User;

/**
 * 
 * @author subhash
 *
 */
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long scaUserId;
	private String memberId;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String companyName;
	private String accessToken;
	private String sessionId;
	private Calendar lastLoginDate;
	private Calendar lastOrderDate;
	private Calendar logoutDate;
	private String userId;
	private String refreshToken;
	private String jobTitle;

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

	private String sdrname;

	private Integer statusCode;

	private String errorMessage;

	/**
	 * @return the scaUserId
	 */
	public Long getScaUserId() {
		return scaUserId;
	}

	/**
	 * @param scaUserId the scaUserId to set
	 */
	public void setScaUserId(Long scaUserId) {
		this.scaUserId = scaUserId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the logoutDate
	 */
	public Calendar getLogoutDate() {
		return logoutDate;
	}

	/**
	 * @param logoutDate the logoutDate to set
	 */
	public void setLogoutDate(Calendar logoutDate) {
		this.logoutDate = logoutDate;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Calendar getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Calendar lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Calendar getLastOrderDate() {
		return lastOrderDate;
	}

	public void setLastOrderDate(Calendar lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
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

	public String getSdrname() {
		return sdrname;
	}

	public void setSdrname(String sdrname) {
		this.sdrname = sdrname;
	}

	public User convertToEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, User.class);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
