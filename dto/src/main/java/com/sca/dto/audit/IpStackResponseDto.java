/**
 * 
 */
package com.sca.dto.audit;

/**
 * 
 * @author subhash
 *
 */
public class IpStackResponseDto {
	private String ip;

	private String country_code;

	private String country_name;

	private String region_code;

	private String region_name;

	private String city;

	private String zip;

	private String latitude;

	private String longitude;

	private String clientIpLookupResponse;

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the country_code
	 */
	public String getCountry_code() {
		return country_code;
	}

	/**
	 * @param country_code the country_code to set
	 */
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	/**
	 * @return the country_name
	 */
	public String getCountry_name() {
		return country_name;
	}

	/**
	 * @param country_name the country_name to set
	 */
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	/**
	 * @return the region_code
	 */
	public String getRegion_code() {
		return region_code;
	}

	/**
	 * @param region_code the region_code to set
	 */
	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	/**
	 * @return the region_name
	 */
	public String getRegion_name() {
		return region_name;
	}

	/**
	 * @param region_name the region_name to set
	 */
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the clientIpLookupResponse
	 */
	public String getClientIpLookupResponse() {
		return clientIpLookupResponse;
	}

	/**
	 * @param clientIpLookupResponse the clientIpLookupResponse to set
	 */
	public void setClientIpLookupResponse(String clientIpLookupResponse) {
		this.clientIpLookupResponse = clientIpLookupResponse;
	}

}
