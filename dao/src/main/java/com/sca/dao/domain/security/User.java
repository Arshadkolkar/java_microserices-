/**
 * 
 */
package com.sca.dao.domain.security;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sca.dao.domain.common.BaseEntity;
import com.sca.dao.domain.payment.CreditCard;

/**
 * 
 * @author subhash
 *
 */
@Entity(name = "user")
@Table(name = "sca_user")
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sca_user_id")
	private Long scaUserId;

	@Column(name = "user_id")
	private String userId;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<CreditCard> creditCards;

	@Column(name = "member_id", unique = true)
	private String memberId;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "refresh_token")
	private String refreshToken;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "fax")
	private String fax;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "address_line2")
	private String addressLine2;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "zip")
	private String zip;

	@Column(name = "web_account_manager_name")
	private String webAccountManagerName;

	@Column(name = "web_account_manager_email")
	private String webAccountMangerEmail;

	@Column(name = "web_account_manager_phone")
	private String webAccountManagerPhone;

	@Column(name = "marke_to_score")
	private String marketoScore;

	@Column(name = "life_cycle_tag")
	private String lifecycleTag;

	@Column(name = "last_login_date")
	private String lastLoginDate;

	@Column(name = "logout_date")
	private String logoutDate;
	
	@Column(name = "last_order_date")
	private String lastOrderDate;

	@Column(name = "sdr_name")
	private String sdrname;

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getFax() {
		return fax;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public String getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(String logoutDate) {
		this.logoutDate = logoutDate;
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

	

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
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

}
