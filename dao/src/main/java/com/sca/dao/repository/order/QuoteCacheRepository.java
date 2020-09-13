package com.sca.dao.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sca.dao.domain.order.QuoteCacheData;

@Repository
public interface QuoteCacheRepository
		extends JpaRepository<QuoteCacheData, Integer>, JpaSpecificationExecutor<QuoteCacheData> {

	QuoteCacheData findByWmqId(String wmqId);
}
