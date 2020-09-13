/**
 * 
 */
package com.sca.dao.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.security.User;
import com.sca.dao.domain.security.UserLogin;

/**
 * 
 * @author subhash
 *
 */
@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long>, JpaSpecificationExecutor<UserLogin> {
}
