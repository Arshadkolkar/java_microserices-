/**
 * 
 */
package com.sca.dao.repository.common;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.common.EntityAdditionalInfo;

/**
 * 
 * @author subhash
 *
 */
@Repository
public interface EntityAdditionalInfoRepository
		extends JpaRepository<EntityAdditionalInfo, Integer>, JpaSpecificationExecutor<EntityAdditionalInfo> {

	List<EntityAdditionalInfo> findByEntityReferenceId(Long projectId);

	EntityAdditionalInfo findByEntityReferenceIdAndParamName(Long projectId, String string);
}
