/**
 * 
 */
package com.sca.scheduler.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sca.common.exception.InvalidInputException;
import com.sca.common.exception.ExceptionUtil;
import com.sca.common.exception.GenericException;
import com.sca.common.response.ValidationResponse;
import com.sca.dto.scheduler.JobTriggerDto;
import com.sca.scheduler.service.JobTriggerService;
import com.sca.scheduler.util.Constants;

/**
 * 
 * @author
 *
 */
@RestController
@RequestMapping(Constants.JOB_TRIGGER_REST_URL)
public class JobTriggerController {

	@Autowired
	private JobTriggerService jobTriggerService;

	@Autowired
	private ExceptionUtil exceptionUtil;

	/**
	 * 
	 * @param accessToken
	 * @param jobTriggerDto
	 * @return
	 * @throws GenericException
	 */
	@PostMapping
	public ResponseEntity<ValidationResponse> createJobTrigger(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestBody JobTriggerDto jobTriggerDto) throws GenericException {
		ValidationResponse response = null;

		try {

			jobTriggerService.createJobTrigger(accessToken, jobTriggerDto);

			response = new ValidationResponse();
			response.setMessage(jobTriggerDto);
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to save the Job trigger details..");
		}

		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ValidationResponse> deleteJobTrigger(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@PathVariable(value = "id", required = true) Long id) throws GenericException {

		ValidationResponse response = null;
		try {
			jobTriggerService.deleteJobTrigger(accessToken, id);

			response = new ValidationResponse();
		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to delete Job trigger details..");
		}

		return ResponseEntity.ok(response);
	}

	@PutMapping
	public ResponseEntity<ValidationResponse> updateJobTrigger(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestBody JobTriggerDto jobTriggerDto) throws GenericException {
		ValidationResponse response = null;

		try {

			jobTriggerService.updateJobTrigger(accessToken, jobTriggerDto);

			response = new ValidationResponse();
			response.setMessage(jobTriggerDto);
		} catch (Exception ex) {
			exceptionUtil.processException(ex,
					"Failed to update the Job trigger details for trigger id = " + jobTriggerDto.getTriggerId());
		}

		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<ValidationResponse> getJobTrigger(
			@RequestHeader(value = "access-token", required = true) String accessToken,
			@RequestParam(value = "trigger-id", required = false) Long triggerId,
			@RequestParam(value = "job-id", required = false) Long jobId) throws GenericException {

		ValidationResponse response = null;
		JobTriggerDto jobTrigger = null;

		try {

			// List<JobDto> jobList = null;

			if ((triggerId != null) && (jobId == null)) {
				jobTrigger = jobTriggerService.getJobTriggerByTriggerId(accessToken, triggerId);
			} else {
				if ((triggerId == null) && (jobId != null)) {
					jobTrigger = jobTriggerService.getJobTriggerByJobId(accessToken, jobId);
				}
			}

			if (jobTrigger == null) {
				throw new InvalidInputException("No job trigger found for this search criteria");
			}

			response = new ValidationResponse();
			response.setMessage(jobTrigger);
			response.setSuccess(true);

		} catch (Exception ex) {
			exceptionUtil.processException(ex, "Failed to get Job trigger details");
		}

		return ResponseEntity.ok(response);
	}

}
