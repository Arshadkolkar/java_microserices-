package com.sca.dao.repository.scheduler;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sca.dao.domain.scheduler.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {

	//Job findByJobId(Long jobId);
	
	Job findByJobName(String jobName);
	
	List<Job> findByJobGroup(String jobGroup);
}
