/**
 * 
 */
package com.sca.scheduler.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.dto.scheduler.JobTriggerDto;

/**
 * 
 * @author subhash
 *
 */
@Service
@Transactional
public interface JobTriggerService {

	/**
	 * 
	 * @param accessToken
	 * @param jobTriggerDto
	 */
	void createJobTrigger(String accessToken, JobTriggerDto jobTriggerDto);

	/**
	 * 
	 * @param accessToken
	 * @param jobTriggerDto
	 */
	void updateJobTrigger(String accessToken, JobTriggerDto jobTriggerDto);

	/**
	 * 
	 * @param accessToken
	 * @param triggerId
	 */
	void deleteJobTrigger(String accessToken, Long triggerId);

	/**
	 * 
	 * @param accessToken
	 * @param triggerId
	 * @return
	 */
	JobTriggerDto getJobTriggerByTriggerId(String accessToken, Long triggerId);

	/**
	 * 
	 * @param accessToken
	 * @param jobId
	 * @return
	 */
	JobTriggerDto getJobTriggerByJobId(String accessToken, Long jobId);

	// *List<JobDto> getJobsByJobGroup(String accessToken, String jobGroup);

	// *List<JobDto> getAllJobs(String accessToken);
}
