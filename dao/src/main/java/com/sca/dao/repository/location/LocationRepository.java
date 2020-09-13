package com.sca.dao.repository.location;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.location.Address;
import com.sca.dao.domain.security.User;

@Repository
public interface LocationRepository extends JpaRepository<Address, Long>, JpaSpecificationExecutor<Address> {

	List<Address> findByScaUserId(Long scaUserId);

	@Modifying
	@Query("update address a set a.isDefault = false where a.isDefault = true and a.scaUserId = :scaUserId and a.addressType.addressTypeId = :addressTypeId")
	void changeDefaultAddress(@Param("scaUserId") Long scaUserId, @Param("addressTypeId") Long addressTypeId);

}
