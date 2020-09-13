/**
 * 
 */
package com.sca.dao.repository.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.audit.ApplicationLog;

/**
 * 
 * @author subhash
 *
 */
@Repository
public interface ApplicationLogRepository
		extends JpaRepository<ApplicationLog, Integer>, JpaSpecificationExecutor<ApplicationLog> {
}
