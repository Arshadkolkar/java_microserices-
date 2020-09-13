/**
 * 
 */
package com.sca.dao.repository.audit;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.audit.IpAuditLog;

/**
 * 
 * @author subhash
 *
 */
@Repository
public interface IpAuditLogRepository extends JpaRepository<IpAuditLog, Long>, JpaSpecificationExecutor<IpAuditLog> {

	/**
	 * 
	 * @param clientIpAddress
	 * @param userId
	 * @param pageRequest
	 * @return
	 */
	@Query("Select i From IpAuditLog i Where i.clientIpAddress = :clientIpAddress And i.createdBy = :userId And DATE(i.createdDate) = CURRENT_DATE ORDER BY i.createdDate DESC")
	List<IpAuditLog> retrieveByParams(@Param("clientIpAddress") String clientIpAddress, @Param("userId") Long userId,
			org.springframework.data.domain.Pageable pageRequest);

	/**
	 * 
	 * @param clientIpAddress
	 * @param pageRequest
	 * @return
	 */
	@Query("Select i From IpAuditLog i Where i.clientIpAddress = :clientIpAddress And i.createdBy IS NULL And DATE(i.createdDate) = CURRENT_DATE ORDER BY i.createdDate DESC")
	List<IpAuditLog> retrieveByClientIpAddress(@Param("clientIpAddress") String clientIpAddress, Pageable pageRequest);

	/**
	 * 
	 * @param clientIpAddress
	 * @return
	 */
	@Query("Select i From IpAuditLog i Where i.createdBy IS NOT Null AND i.clientIpAddress = :clientIpAddress And (DATE(i.createdDate) = CURRENT_DATE OR DATE(i.createdDate) = SUBDATE(CURRENT_DATE,1)) ORDER BY i.createdDate DESC")
	List<IpAuditLog> retrieveByClientIpAddressAndDate(@Param("clientIpAddress") String clientIpAddress);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	IpAuditLog findTop1ByCreatedByAndClientZipCodeNotNullOrderByCreatedDateAsc(Long userId);

}
