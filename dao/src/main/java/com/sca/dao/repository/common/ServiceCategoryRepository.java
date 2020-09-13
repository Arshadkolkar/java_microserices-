/**
 * 
 */
package com.sca.dao.repository.common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.common.ServiceCategory;

/**
 * 
 * @author subhash
 *
 */
@Repository
public interface ServiceCategoryRepository
		extends JpaRepository<ServiceCategory, Long>, JpaSpecificationExecutor<ServiceCategory> {

	ServiceCategory findByServiceCategoryIdAndIsActiveIsTrue(@Param("serviceCategoryId") Integer serviceCategoryId);

	List<ServiceCategory> findAllByIsActiveIsTrue();

}
