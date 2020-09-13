package com.sca.project.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sca.common.exception.ExceptionUtil;
import com.sca.common.exception.GenericException;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.project.ProjectDto;
import com.sca.project.service.ProjectService;
import com.sca.project.util.Constants;

@RestController
@RequestMapping(Constants.PROJECT_REST_URL)
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@Autowired
	private ExceptionUtil exceptionUtil;

	@PostMapping(path = "/project")
	public ResponseEntity<String> saveProject(@RequestBody ProjectDto projectDto) throws GenericException {
		try {
			projectService.saveProject(projectDto);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to create project");
		}
		return ResponseEntity.ok(new Gson().toJson(projectDto));
	}

	@GetMapping(path = "/user_id/{user_id}")
	public ResponseEntity<String> getProjectsFromUserId(@PathVariable("user_id") String user_id)
			throws GenericException {
		String list_of_project = null;
		try {
			list_of_project = projectService.findProjectsByUserId(user_id);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to create project for user id = " + user_id);
		}

		return ResponseEntity.ok(list_of_project);
	}

	@PutMapping("/delete/project/{project_id}")
	public ResponseEntity<ValidationResponse> deleteProject(@PathVariable("project_id") UUID projectId)
			throws GenericException {
		ValidationResponse response = null;
		try {
			projectService.deleteProjectById(projectId);
			response = new ValidationResponse();
			response.setMessage("Sucessfully done.");
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to update the Project Id = " + projectId);
		}
		return ResponseEntity.ok(response);
	}

	@PutMapping("/project/{project_id}")
	public ResponseEntity<ValidationResponse> updateProject(@PathVariable("project_id") UUID projectId,
			@RequestBody ProjectDto projectBody) throws GenericException {
		ValidationResponse response = null;
		try {
			projectService.updateProjectById(projectId, projectBody);
			response = new ValidationResponse();
			response.setMessage("Sucessfully updated project.");
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to update the Project Id = " + projectId);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("/project/{project_id}")
	public ResponseEntity<String> getProjectFromProjectId(@PathVariable("project_id") UUID projectId) throws GenericException {
		String fetching_project = null;
		try {
			fetching_project = projectService.getProjectById(projectId);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to update the Project Id = " + projectId);
		}
		return ResponseEntity.ok(fetching_project);
	}
}
