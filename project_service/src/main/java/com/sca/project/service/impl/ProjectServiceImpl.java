package com.sca.project.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.sca.common.exception.InvalidInputException;
import com.sca.dao.domain.project.Project;
import com.sca.dao.domain.project.ProjectProperties;
import com.sca.dao.repository.project.ProjectRepository;
import com.sca.dto.project.ProjectDto;

@Service
@Transactional
public class ProjectServiceImpl implements com.sca.project.service.ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Override
	public void saveProject(ProjectDto projectDto) {
		Project project = new Project();
		// project.setProjectId(projectDto.getProject_id());
		project.setUserId(projectDto.getUser_id());
		Set<ProjectProperties> project_properties_object = new HashSet<>();
		project_properties_object.add(new ProjectProperties(projectDto.getProject_properties().getProject_name(),
				projectDto.getProject_properties().getAssembly_part_number(),
				projectDto.getProject_properties().getRevision(), projectDto.getProject_properties().getBoard_name(),
				projectDto.getProject_properties().getDescription(),
				projectDto.getProject_properties().getCompany_name(),
				projectDto.getProject_properties().getQuantity_individual_boards()));
		project.setProjectProperties(project_properties_object);
		project.setStatus(true);
		projectRepository.save(project);
	}

	@Override
	public String findProjectsByUserId(String userId) {
		List<ProjectDto> list_of_project = new ArrayList<ProjectDto>();
		List<Project> fetching_project_list = projectRepository.findAllByUserId(userId);
		if (!fetching_project_list.isEmpty()) {
			for (int i = 0; i < fetching_project_list.size(); i++) {
				ProjectDto project_dto_object = new ProjectDto();
				project_dto_object.setProject_id(fetching_project_list.get(i).getProjectId());
				project_dto_object.setUser_id(fetching_project_list.get(i).getUserId());
				ProjectProperties project_properties_object = new ProjectProperties();
				Iterator<ProjectProperties> itr = fetching_project_list.get(i).getProjectProperties().iterator();
				while (itr.hasNext()) {
					project_properties_object = itr.next();
					project_properties_object
							.setAssembly_part_number(project_properties_object.getAssembly_part_number() != null
									? project_properties_object.getAssembly_part_number()
									: "");
					project_properties_object.setBoard_name(project_properties_object.getBoard_name() != null
							? project_properties_object.getBoard_name()
							: "");
					project_properties_object.setCompany_name(project_properties_object.getCompany_name() != null
							? project_properties_object.getCompany_name()
							: "");
					project_properties_object.setDescription(project_properties_object.getDescription() != null
							? project_properties_object.getDescription()
							: "");
					project_properties_object.setProject_name(project_properties_object.getProject_name() != null
							? project_properties_object.getProject_name()
							: "");
					project_properties_object.setQuantity_individual_boards(
							project_properties_object.getQuantity_individual_boards() != 0
									? project_properties_object.getQuantity_individual_boards()
									: 0);
					project_properties_object.setRevision(
							project_properties_object.getRevision() != null ? project_properties_object.getRevision()
									: "");
				}
				if (fetching_project_list.get(i).isStatus()) {
					project_dto_object.setProject_properties(project_properties_object);
					list_of_project.add(project_dto_object);
				}
			}
		}
		return new Gson().toJson(list_of_project);
	}

	@Override
	public void deleteProjectById(UUID projectId) throws InvalidInputException {
		Project fetching_project = projectRepository.getOne(projectId);
		fetching_project.setStatus(false);
		projectRepository.save(fetching_project);
	}

	@Override
	public void updateProjectById(UUID projectId, ProjectDto projectDto) throws InvalidInputException {
		Project fetching_project = projectRepository.getOne(projectId);
		Set<ProjectProperties> project_properties_object = new HashSet<>();
		project_properties_object.add(new ProjectProperties(projectDto.getProject_properties().getProject_name(),
				projectDto.getProject_properties().getAssembly_part_number(),
				projectDto.getProject_properties().getRevision(), projectDto.getProject_properties().getBoard_name(),
				projectDto.getProject_properties().getDescription(),
				projectDto.getProject_properties().getCompany_name(),
				projectDto.getProject_properties().getQuantity_individual_boards()));
		fetching_project.setProjectProperties(project_properties_object);
		projectRepository.save(fetching_project);
	}

	@Override
	public String getProjectById(UUID projectId) throws InvalidInputException {
		Optional<Project> optional_project_list = projectRepository.findById(projectId);
		ProjectDto project_dto_object = new ProjectDto();
		ProjectProperties project_properties_object = null;
		boolean flag = optional_project_list.get().isStatus();
		if (optional_project_list.isPresent() && flag) {
			project_dto_object.setProject_id(optional_project_list.get().getProjectId());
			project_dto_object.setUser_id(optional_project_list.get().getUserId());
			while (optional_project_list.get().getProjectProperties().iterator().hasNext() && flag) {
				project_properties_object = new ProjectProperties();
				project_properties_object = optional_project_list.get().getProjectProperties().iterator().next();
				new ProjectProperties(project_properties_object.getProject_name(),
						project_properties_object.getAssembly_part_number(), project_properties_object.getRevision(),
						project_properties_object.getBoard_name(), project_properties_object.getDescription(),
						project_properties_object.getCompany_name(),
						project_properties_object.getQuantity_individual_boards());
				flag = false;
			}
			project_dto_object.setProject_properties(project_properties_object);
		}
		return new Gson().toJson(project_dto_object);
	}
}
