package com.sca.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MetrosLatLongDto {

	private String metro;

	private String latitude;

	private String longitude;

	public MetrosLatLongDto() {
		super();
	}

	public MetrosLatLongDto(String metro) {
		super();
		this.metro = metro;
	}

	/**
	 * @return the metro
	 */
	public String getMetro() {
		return metro;
	}

	/**
	 * @param metro the metro to set
	 */
	public void setMetro(String metro) {
		this.metro = metro;
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

}
