/**
 * 
 */
package com.sca.dao.repository.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.audit.UserEventType;

/**
 * 
 * @author subhash
 *
 */
@Repository
public interface UserEventTypeRepository
		extends JpaRepository<UserEventType, Integer>, JpaSpecificationExecutor<UserEventType> {

	UserEventType findByUserEventTypeExternalName(String userEventTypeName);
}
