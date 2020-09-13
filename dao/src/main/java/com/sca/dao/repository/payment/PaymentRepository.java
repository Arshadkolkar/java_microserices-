package com.sca.dao.repository.payment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sca.dao.domain.payment.CreditCard;
import com.sca.dao.domain.security.User;

public interface PaymentRepository extends JpaRepository<CreditCard, Long>, JpaSpecificationExecutor<CreditCard> {
	
	List<CreditCard> findByUser(User user);
	
	@Modifying
	@Query("update creditCard a set a.isDefault = false where a.isDefault = true and a.user.scaUserId = :scaUserId")
	void changeDefaultPayment(@Param("scaUserId") Long scaUserId);
}
