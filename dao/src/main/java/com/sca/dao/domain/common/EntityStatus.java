/**
 * 
 */
package com.sca.dao.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author subhash
 *
 */
@Entity
@Table(name = "entity_status")
public class EntityStatus {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "entity_status_id")
	private Integer entityStatusId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private Integer description;

	/**
	 * @return the entityStatusId
	 */
	public Integer getEntityStatusId() {
		return entityStatusId;
	}

	/**
	 * @param entityStatusId the entityStatusId to set
	 */
	public void setEntityStatusId(Integer entityStatusId) {
		this.entityStatusId = entityStatusId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public Integer getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(Integer description) {
		this.description = description;
	}
}
