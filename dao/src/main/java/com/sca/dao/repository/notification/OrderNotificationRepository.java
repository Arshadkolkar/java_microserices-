package com.sca.dao.repository.notification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.notification.OrderNotification;

@Repository
public interface OrderNotificationRepository
		extends JpaRepository<OrderNotification, Integer>, JpaSpecificationExecutor<OrderNotification> {
	
	List<OrderNotification> findByOrderId(Long orderId);

	List<OrderNotification> findByWmqId(String wmqId);

}
