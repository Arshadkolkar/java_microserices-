/**
 * 
 */
package com.sca.dao.domain.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author subhash
 *
 */
@Entity
@Table(name = "service_category")
public class ServiceCategory extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_category_id")
	private Integer serviceCategoryId;

	@Column(name = "service_category_external_name", length = 150, unique = true)
	@NotNull
	private String serviceCategoryExternalName;

	@Column(name = "service_category_internal_name", length = 150, unique = true)
	@NotNull
	private String serviceCategoryInternalName;

	public ServiceCategory() {
		super();
	}

	public ServiceCategory(Integer serviceCategoryId) {
		super();
		this.serviceCategoryId = serviceCategoryId;
	}

	/**
	 * @return the serviceCategoryId
	 */
	public Integer getServiceCategoryId() {
		return serviceCategoryId;
	}

	/**
	 * @param serviceCategoryId the serviceCategoryId to set
	 */
	public void setServiceCategoryId(Integer serviceCategoryId) {
		this.serviceCategoryId = serviceCategoryId;
	}

	/**
	 * @return the serviceCategoryExternalName
	 */
	public String getServiceCategoryExternalName() {
		return serviceCategoryExternalName;
	}

	/**
	 * @param serviceCategoryExternalName the serviceCategoryExternalName to set
	 */
	public void setServiceCategoryExternalName(String serviceCategoryExternalName) {
		this.serviceCategoryExternalName = serviceCategoryExternalName;
	}

	/**
	 * @return the serviceCategoryInternalName
	 */
	public String getServiceCategoryInternalName() {
		return serviceCategoryInternalName;
	}

	/**
	 * @param serviceCategoryInternalName the serviceCategoryInternalName to set
	 */
	public void setServiceCategoryInternalName(String serviceCategoryInternalName) {
		this.serviceCategoryInternalName = serviceCategoryInternalName;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
