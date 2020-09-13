/**
 * 
 */
package com.sca.dao.domain.audit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.sca.dao.domain.common.BaseEntity;
import com.sca.dao.domain.common.Service;

/**
 * 
 * @author subhash
 *
 */
@Entity
@Table(name = "service_entity")
public class ServiceEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_entity_id")
	private Integer serviceEntityId;

	@ManyToOne
	@JoinColumn(name = "service_id", referencedColumnName = "service_id", nullable = false)
	private Service service;

	@Column(name = "entity")
	private String entity;

	@Column(name = "entity_primary_key")
	private String entityPrimaryKey;

	/**
	 * @return the serviceEntityId
	 */
	public Integer getServiceEntityId() {
		return serviceEntityId;
	}

	/**
	 * @param serviceEntityId the serviceEntityId to set
	 */
	public void setServiceEntityId(Integer serviceEntityId) {
		this.serviceEntityId = serviceEntityId;
	}

	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}

	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}

	/**
	 * @return the entityPrimaryKey
	 */
	public String getEntityPrimaryKey() {
		return entityPrimaryKey;
	}

	/**
	 * @param entityPrimaryKey the entityPrimaryKey to set
	 */
	public void setEntityPrimaryKey(String entityPrimaryKey) {
		this.entityPrimaryKey = entityPrimaryKey;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
