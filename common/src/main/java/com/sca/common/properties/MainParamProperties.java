/**
 * 
 */
package com.sca.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author subhash
 *
 */
@Component
// prefix main-param, find main-param.* values
@ConfigurationProperties("main-param")
public class MainParamProperties {

	private String environment;
	private String defaultEmail;
	private String contactEmail;
	private String scaMainUrl;
	private String googleMapKey;
	private String ipStackUrl;
	private String ipStackKey;

	/**
	 * @return the environment
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	/**
	 * @return the defaultEmail
	 */
	public String getDefaultEmail() {
		return defaultEmail;
	}

	/**
	 * @param defaultEmail the defaultEmail to set
	 */
	public void setDefaultEmail(String defaultEmail) {
		this.defaultEmail = defaultEmail;
	}

	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	/**
	 * @return the scaMainUrl
	 */
	public String getScaMainUrl() {
		return scaMainUrl;
	}

	/**
	 * @param scaMainUrl the scaMainUrl to set
	 */
	public void setScaMainUrl(String scaMainUrl) {
		this.scaMainUrl = scaMainUrl;
	}

	/**
	 * @return the googleMapKey
	 */
	public String getGoogleMapKey() {
		return googleMapKey;
	}

	/**
	 * @param googleMapKey the googleMapKey to set
	 */
	public void setGoogleMapKey(String googleMapKey) {
		this.googleMapKey = googleMapKey;
	}

	/**
	 * @return the ipStackUrl
	 */
	public String getIpStackUrl() {
		return ipStackUrl;
	}

	/**
	 * @param ipStackUrl the ipStackUrl to set
	 */
	public void setIpStackUrl(String ipStackUrl) {
		this.ipStackUrl = ipStackUrl;
	}

	/**
	 * @return the ipStackKey
	 */
	public String getIpStackKey() {
		return ipStackKey;
	}

	/**
	 * @param ipStackKey the ipStackKey to set
	 */
	public void setIpStackKey(String ipStackKey) {
		this.ipStackKey = ipStackKey;
	}

}
