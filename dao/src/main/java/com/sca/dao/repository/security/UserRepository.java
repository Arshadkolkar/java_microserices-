/**
 * 
 */
package com.sca.dao.repository.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.security.User;

/**
 * 
 * @author subhash
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	User findByMemberIdOrEmail(String userName, String emailId);
	
	List<User> findByCompanyName(String companyName);
	
	User findByUserId(String userId);

}
