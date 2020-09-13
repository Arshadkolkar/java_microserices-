package com.sca.dto.common;

import java.util.List;

public class UserPropertyInfoDto {
	private String address;
	private List<ProjectDetailDto> projects;

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the projects
	 */
	public List<ProjectDetailDto> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(List<ProjectDetailDto> projects) {
		this.projects = projects;
	}

}
