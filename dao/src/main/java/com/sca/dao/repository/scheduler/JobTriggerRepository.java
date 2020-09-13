package com.sca.dao.repository.scheduler;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.scheduler.JobTrigger;

@Repository
public interface JobTriggerRepository  extends JpaRepository<JobTrigger, Long>, JpaSpecificationExecutor<JobTrigger> {

	JobTrigger findByJobId(Long jobId);
	
	JobTrigger findByTriggerId(Long triggerId);
	
	//List<JobTrigger> findByJobId(String jobGroup);
}
