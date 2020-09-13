package com.sca.dto.common;

public class SearchResourceDto {

	private String professionalBusinessTypes;
	private String homeLatitude;
	private String homeLongitude;
	private int radius;
	private int pageId;
	private int limit;

	public SearchResourceDto() {
		super();
	}

	public SearchResourceDto(String professionalBusinessTypes, String homeLatitude, String homeLongitude, int radius) {
		super();
		this.professionalBusinessTypes = professionalBusinessTypes;
		this.homeLatitude = homeLatitude;
		this.homeLongitude = homeLongitude;
		this.radius = radius;
	}

	public SearchResourceDto(String professionalBusinessTypes, String homeLatitude, String homeLongitude, int radius,
			int pageId, int limit) {
		super();
		this.professionalBusinessTypes = professionalBusinessTypes;
		this.homeLatitude = homeLatitude;
		this.homeLongitude = homeLongitude;
		this.radius = radius;
		this.pageId = pageId;
		this.limit = limit;
	}

	/**
	 * @return the professionalBusinessTypes
	 */
	public String getProfessionalBusinessTypes() {
		return professionalBusinessTypes;
	}

	/**
	 * @return the homeLatitude
	 */
	public String getHomeLatitude() {
		return homeLatitude;
	}

	/**
	 * @return the homeLongitude
	 */
	public String getHomeLongitude() {
		return homeLongitude;
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @return the pageId
	 */
	public int getPageId() {
		return pageId;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param professionalBusinessTypes the professionalBusinessTypes to set
	 */
	public void setProfessionalBusinessTypes(String professionalBusinessTypes) {
		this.professionalBusinessTypes = professionalBusinessTypes;
	}

	/**
	 * @param homeLatitude the homeLatitude to set
	 */
	public void setHomeLatitude(String homeLatitude) {
		this.homeLatitude = homeLatitude;
	}

	/**
	 * @param homeLongitude the homeLongitude to set
	 */
	public void setHomeLongitude(String homeLongitude) {
		this.homeLongitude = homeLongitude;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * @param pageId the pageId to set
	 */
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

}
