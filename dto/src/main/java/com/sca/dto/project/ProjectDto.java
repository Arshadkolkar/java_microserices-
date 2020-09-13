/**
 * 
 */
package com.sca.dto.project;

import java.io.Serializable;
import java.util.UUID;

import com.sca.dao.domain.project.ProjectProperties;

public class ProjectDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID project_id;
	private String user_id;

	private ProjectProperties project_properties;

	public UUID getProject_id() {
		return project_id;
	}

	public void setProject_id(UUID project_id) {
		this.project_id = project_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public ProjectProperties getProject_properties() {
		return project_properties;
	}

	public void setProject_properties(ProjectProperties project_properties) {
		this.project_properties = project_properties;
	}
}
