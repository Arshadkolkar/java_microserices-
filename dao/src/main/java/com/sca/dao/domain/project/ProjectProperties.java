package com.sca.dao.domain.project;

import javax.persistence.Embeddable;

@Embeddable
public class ProjectProperties {

	private String project_name;
	private String assembly_part_number;
	private String revision;
	private String board_name;
	private String description;
	private String company_name;
	private int quantity_individual_boards;
	
	public ProjectProperties() {}
	
	public ProjectProperties(String project_name, String assembly_part_number, String revision, String board_name,
			String description, String company_name, int quantity_individual_boards) {
		this.project_name = project_name;
		this.assembly_part_number = assembly_part_number;
		this.revision = revision;
		this.board_name = board_name;
		this.description = description;
		this.company_name = company_name;
		this.quantity_individual_boards = quantity_individual_boards;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getAssembly_part_number() {
		return assembly_part_number;
	}
	public void setAssembly_part_number(String assembly_part_number) {
		this.assembly_part_number = assembly_part_number;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public int getQuantity_individual_boards() {
		return quantity_individual_boards;
	}
	public void setQuantity_individual_boards(int quantity_individual_boards) {
		this.quantity_individual_boards = quantity_individual_boards;
	}
	
}
