/**
 * 
 */
package com.sca.scheduler.service.impl;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.common.exception.InvalidInputException;
import com.sca.dao.domain.scheduler.JobTrigger;
import com.sca.dto.scheduler.JobTriggerDto;
import com.sca.dao.repository.scheduler.JobTriggerRepository;

/**
 * 
 * @author
 *
 */
@Service
@Transactional
public class JobTriggerServiceImpl implements com.sca.scheduler.service.JobTriggerService {

	@Autowired
	private JobTriggerRepository jobTriggerRepository;

	/**
	 * 
	 */
	@Override
	public void createJobTrigger(String accessToken, JobTriggerDto jobTriggerDto) {

		JobTrigger jobTrigger = new JobTrigger();

		jobTrigger.setJobId(jobTriggerDto.getJobId());
		jobTrigger.setStartDate(jobTriggerDto.getStartDate());
		jobTrigger.setEndDate(jobTriggerDto.getEndDate());
		jobTrigger.setStart24Hour(jobTriggerDto.getStart24Hour());
		jobTrigger.setStartMinute(jobTriggerDto.getStartMinute());
		jobTrigger.setEnd24Hour(jobTriggerDto.getEnd24Hour());
		jobTrigger.setEndMinute(jobTriggerDto.getEndMinute());
		jobTrigger.setRepeatEvery(jobTriggerDto.getRepeatEvery());
		jobTrigger.setRepeatInterval(jobTriggerDto.getRepeatInterval());
		jobTrigger.setSundayEnabled(jobTriggerDto.isSundayEnabled());
		jobTrigger.setMondayEnabled(jobTriggerDto.isMondayEnabled());
		jobTrigger.setTuesdayEnabled(jobTriggerDto.isTuesdayEnabled());
		jobTrigger.setWednesdayEnabled(jobTriggerDto.isWednesdayEnabled());
		jobTrigger.setThursdayEnabled(jobTriggerDto.isThursdayEnabled());
		jobTrigger.setFridayEnabled(jobTriggerDto.isFridayEnabled());
		jobTrigger.setSaturdayEnabled(jobTriggerDto.isSaturdayEnabled());
		jobTrigger.setDayNumberOfMonth(jobTriggerDto.getDayNumberOfMonth());

		jobTrigger.setIsActive(jobTriggerDto.getIsActive());
		jobTrigger.setCreatedBy(jobTriggerDto.getCreatedBy());
		jobTrigger.setCreatedDate(Calendar.getInstance());

		jobTriggerRepository.save(jobTrigger);

		jobTriggerDto.setTriggerId(jobTrigger.getTriggerId());

	}

	/**
	 * 
	 */
	@Override
	public void deleteJobTrigger(String accessToken, Long triggerId) {

		jobTriggerRepository.deleteById(triggerId);

	}

	/**
	 * 
	 */
	@Override
	public void updateJobTrigger(String accessToken, JobTriggerDto jobTriggerDto) throws InvalidInputException {

		Optional<JobTrigger> jobTriggerOptional = jobTriggerRepository.findById(jobTriggerDto.getTriggerId());

		if (jobTriggerOptional.isPresent()) {
			JobTrigger jobTrigger = jobTriggerOptional.get();

			jobTrigger.setJobId(jobTriggerDto.getJobId());
			jobTrigger.setStartDate(jobTriggerDto.getStartDate());
			jobTrigger.setEndDate(jobTriggerDto.getEndDate());
			jobTrigger.setStart24Hour(jobTriggerDto.getStart24Hour());
			jobTrigger.setStartMinute(jobTriggerDto.getStartMinute());
			jobTrigger.setEnd24Hour(jobTriggerDto.getEnd24Hour());
			jobTrigger.setEndMinute(jobTriggerDto.getEndMinute());
			jobTrigger.setRepeatEvery(jobTriggerDto.getRepeatEvery());
			jobTrigger.setRepeatInterval(jobTriggerDto.getRepeatInterval());
			jobTrigger.setSundayEnabled(jobTriggerDto.isSundayEnabled());
			jobTrigger.setMondayEnabled(jobTriggerDto.isMondayEnabled());
			jobTrigger.setTuesdayEnabled(jobTriggerDto.isTuesdayEnabled());
			jobTrigger.setWednesdayEnabled(jobTriggerDto.isWednesdayEnabled());
			jobTrigger.setThursdayEnabled(jobTriggerDto.isThursdayEnabled());
			jobTrigger.setFridayEnabled(jobTriggerDto.isFridayEnabled());
			jobTrigger.setSaturdayEnabled(jobTriggerDto.isSaturdayEnabled());
			jobTrigger.setDayNumberOfMonth(jobTriggerDto.getDayNumberOfMonth());

			jobTrigger.setUpdatedBy(jobTriggerDto.getUpdatedBy());
			jobTrigger.setUpdatedDate(Calendar.getInstance());

			jobTriggerRepository.save(jobTrigger);

			jobTriggerDto.setCreatedBy(jobTrigger.getCreatedBy());
			jobTriggerDto.setCreatedDate(jobTrigger.getCreatedDate());
			jobTriggerDto.setUpdatedDate(jobTrigger.getUpdatedDate());
		} else {
			throw new InvalidInputException("Could not find job trigger details to update");
		}
	}

	/**
	 * 
	 */
	@Override
	public JobTriggerDto getJobTriggerByTriggerId(String accessToken, Long triggerId) {

		JobTrigger jobTrigger = jobTriggerRepository.getOne(triggerId);
		JobTriggerDto jobTriggerDto = this.copyToJobTriggerDto(null, jobTrigger);

		return jobTriggerDto;
	}

	private JobTriggerDto copyToJobTriggerDto(JobTriggerDto jobTriggerDto, JobTrigger jobTrigger) {

		if (jobTrigger != null) {

			if (jobTriggerDto == null) {
				jobTriggerDto = new JobTriggerDto();
			}

			jobTriggerDto.setTriggerId(jobTrigger.getTriggerId());
			jobTriggerDto.setJobId(jobTrigger.getJobId());
			jobTriggerDto.setStartDate(jobTrigger.getStartDate());
			jobTriggerDto.setEndDate(jobTrigger.getEndDate());
			jobTriggerDto.setStart24Hour(jobTrigger.getStart24Hour());
			jobTriggerDto.setStartMinute(jobTrigger.getStartMinute());
			jobTriggerDto.setEnd24Hour(jobTrigger.getEnd24Hour());
			jobTriggerDto.setEndMinute(jobTrigger.getEndMinute());
			jobTriggerDto.setRepeatEvery(jobTrigger.getRepeatEvery());
			jobTriggerDto.setRepeatInterval(jobTrigger.getRepeatInterval());
			jobTriggerDto.setSundayEnabled(jobTrigger.isSundayEnabled());
			jobTriggerDto.setMondayEnabled(jobTrigger.isMondayEnabled());
			jobTriggerDto.setTuesdayEnabled(jobTrigger.isTuesdayEnabled());
			jobTriggerDto.setWednesdayEnabled(jobTrigger.isWednesdayEnabled());
			jobTriggerDto.setThursdayEnabled(jobTrigger.isThursdayEnabled());
			jobTriggerDto.setFridayEnabled(jobTrigger.isFridayEnabled());
			jobTriggerDto.setSaturdayEnabled(jobTrigger.isSaturdayEnabled());
			jobTriggerDto.setDayNumberOfMonth(jobTrigger.getDayNumberOfMonth());

			jobTriggerDto.setIsActive(jobTrigger.getIsActive());
			jobTriggerDto.setCreatedBy(jobTrigger.getCreatedBy());
			jobTriggerDto.setCreatedDate(jobTrigger.getCreatedDate());
			jobTriggerDto.setUpdatedBy(jobTrigger.getUpdatedBy());
			jobTriggerDto.setUpdatedDate(jobTrigger.getUpdatedDate());

		}

		return jobTriggerDto;
	}

	/**
	 * 
	 */
	@Override
	public JobTriggerDto getJobTriggerByJobId(String accessToken, Long jobId) {
		JobTrigger jobTrigger = jobTriggerRepository.findByJobId(jobId);
		JobTriggerDto jobTriggerDto = this.copyToJobTriggerDto(null, jobTrigger);
		return jobTriggerDto;
	}

}
