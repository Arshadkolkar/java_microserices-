/**
 * 
 */
package com.sca.scheduler.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.dto.scheduler.JobDto; 

/**
 * 
 * @author subhash
 *
 */
@Service
@Transactional
public interface JobService {	

	/**
	 * 
	 * @param accessToken
	 * @param jobDto
	 */
	void createJob(String accessToken, JobDto jobDto);
	
	/**
	 * 
	 * @param accessToken
	 * @param jobDto
	 */
	void updateJob(String accessToken, JobDto jobDto);
	
	/**
	 * 
	 * @param accessToken
	 * @param jobId
	 */
	void deleteJob(String accessToken, Long jobId);

	/**
	 * 
	 * @param accessToken
	 * @param jobId
	 * @return
	 */
	JobDto getJobByJobId(String accessToken, Long jobId);

	/**
	 * 
	 * @param accessToken
	 * @param jobName
	 * @return
	 */
	JobDto getJobByJobName(String accessToken, String jobName);

	/**
	 * 
	 * @param accessToken
	 * @param jobGroup
	 * @return
	 */
	List<JobDto> getJobsByJobGroup(String accessToken, String jobGroup);

	/**
	 * 
	 * @param accessToken
	 * @return
	 */
	List<JobDto> getAllJobs(String accessToken);

}
