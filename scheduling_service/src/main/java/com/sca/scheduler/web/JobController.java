/**
 * 
 */
package com.sca.scheduler.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sca.common.exception.ExceptionUtil;
import com.sca.common.exception.GenericException;
import com.sca.common.exception.InvalidInputException;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.scheduler.JobDto;
import com.sca.dto.scheduler.Jobs;
import com.sca.scheduler.service.JobService;
import com.sca.scheduler.util.Constants;

/**
 * 
 * @author
 *
 */
@RestController
@RequestMapping(Constants.JOB_REST_URL)
public class JobController {

	@Autowired
	private JobService jobService;

	@Autowired
	private ExceptionUtil exceptionUtil;

	/**
	 * 
	 * @param accessToken
	 * @param jobDto
	 * @return
	 * @throws GenericException
	 */
	@PostMapping
	public ResponseEntity<ValidationResponse> createJob(
			@RequestHeader(value = "access-token", required = true) String accessToken, @RequestBody JobDto jobDto)
			throws GenericException {
		ValidationResponse response = null;

		try {

			jobService.createJob(accessToken, jobDto);

			response = new ValidationResponse();
			response.setMessage(jobDto);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to save the Job details..");
		}

		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ValidationResponse> deleteJob(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@PathVariable(value = "id", required = true) Long id) throws GenericException {

		ValidationResponse response = null;
		try {
			jobService.deleteJob(accessToken, id);

			response = new ValidationResponse();
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to delete Job details..");
		}

		return ResponseEntity.ok(response);
	}

	@PutMapping
	public ResponseEntity<ValidationResponse> updateJob(
			@RequestHeader(value = "access-token", required = true) String accessToken, @RequestBody JobDto jobDto)
			throws GenericException {
		ValidationResponse response = null;

		try {

			jobService.updateJob(accessToken, jobDto);

			response = new ValidationResponse();
			response.setMessage(jobDto);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to update the Job details for job id = " + jobDto.getJobId());
		}

		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/{jobId}")
	public ResponseEntity<JobDto> getJobByJobId(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@PathVariable(value = "jobId", required = false) Long jobId) throws GenericException {

		JobDto jobDto = null;

		try {

			if (jobId > 0) {
				jobDto = jobService.getJobByJobId(accessToken, jobId);
			}

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get Job details for job Id = " + jobId);
		}

		return ResponseEntity.ok(jobDto);
	}

	@GetMapping
	public ResponseEntity<ValidationResponse> getJobs(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "job-name", required = false) String jobName,
			@RequestParam(value = "job-group", required = false) String jobGroup) throws GenericException {

		ValidationResponse response = null;
		Jobs jobs = null;

		try {

			List<JobDto> jobList = null;

			if ((jobName != null) && (jobGroup == null)) {
				jobList = new ArrayList<JobDto>();
				jobList.add(jobService.getJobByJobName(accessToken, jobName));
			} else {
				if ((jobName == null) && (jobGroup != null)) {
					jobList = jobService.getJobsByJobGroup(accessToken, jobGroup);
				} else {
					jobList = jobService.getAllJobs(accessToken);
				}
			}

			if ((jobList == null) || (jobList.size() < 1)) {
				throw new InvalidInputException("No jobs found for this search criteria");
			} else {
				jobs = new Jobs();
				jobs.setJobList(jobList);
			}

			response = new ValidationResponse();
			response.setMessage(jobs);
			response.setSuccess(true);

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get Jobs list");
		}

		return ResponseEntity.ok(response);
	}

}
