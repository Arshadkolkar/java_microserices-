package com.sca.dao.domain.project;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

	private static final long serialVersionUID = -2878322995481840187L;
	
	@Id
	@GeneratedValue(generator = "UUID")
	/*
	 * @GenericGenerator( name = "UUID", strategy = "org.hibernate.id.UUIDGenerator"
	 * )
	 */
	@Column(name = "project_id", updatable = false, nullable = false)
	private UUID projectId;
    
	@Column(name = "user_id")
	private String userId;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "project_properties", joinColumns = @JoinColumn(name = "project_id"))
	private Set<ProjectProperties> projectProperties = new HashSet<>();
    
	@Column(name="status")
	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public UUID getProjectId() {
		return projectId;
	}

	public void setProjectId(UUID projectId) {
		this.projectId = projectId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Set<ProjectProperties> getProjectProperties() {
		return projectProperties;
	}

	public void setProjectProperties(Set<ProjectProperties> projectProperties) {
		this.projectProperties = projectProperties;
	}

	public Project(){}
	
	public Project(UUID projectId, String userId, Set<ProjectProperties> projectProperties, boolean status) {
		this.projectId = projectId;
		this.userId = userId;
		this.projectProperties = projectProperties;
		this.status = status;
	}

}
