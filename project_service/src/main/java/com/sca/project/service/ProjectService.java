package com.sca.project.service;

import java.util.UUID;

import com.sca.dto.project.ProjectDto;

public interface ProjectService {
	
	void saveProject(ProjectDto projectDto);

	String findProjectsByUserId(String user_id);

	void deleteProjectById(UUID projectId);

	void updateProjectById(UUID projectId, ProjectDto projectBody);

	String getProjectById(UUID projectId);
}
