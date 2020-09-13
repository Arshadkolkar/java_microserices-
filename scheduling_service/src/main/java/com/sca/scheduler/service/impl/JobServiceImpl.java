/**
 * 
 */
package com.sca.scheduler.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sca.common.exception.InvalidInputException;
import com.sca.dao.domain.scheduler.Job;
import com.sca.dto.scheduler.JobDto;
import com.sca.dao.repository.scheduler.JobRepository;

/**
 * 
 * @author subhash
 *
 */
@Service
@Transactional
public class JobServiceImpl implements com.sca.scheduler.service.JobService {

	@Autowired
	private JobRepository jobRepository;

	/**
	 * 
	 */
	@Override
	public void createJob(String accessToken, JobDto jobDto) {

		Job job = new Job();

		job.setJobGroup(jobDto.getJobGroup());
		job.setJobName(jobDto.getJobName());
		job.setJobDescription(jobDto.getJobDescription());
		job.setJobClass(jobDto.getJobClass());
		job.setIsActive(jobDto.getIsActive());

		job.setCreatedBy(jobDto.getCreatedBy());
		job.setCreatedDate(Calendar.getInstance());

		jobRepository.save(job);

		jobDto.setJobId(job.getJobId());

	}

	/**
	 * 
	 */
	@Override
	public void deleteJob(String accessToken, Long jobId) {

		jobRepository.deleteById(jobId);

	}

	/**
	 * 
	 */
	@Override
	public void updateJob(String accessToken, JobDto jobDto) throws InvalidInputException {

		Optional<Job> jobOptional = jobRepository.findById(jobDto.getJobId());

		if (jobOptional.isPresent()) {
			Job job = jobOptional.get();

			job.setJobGroup(jobDto.getJobGroup());
			job.setJobName(jobDto.getJobName());
			job.setJobDescription(jobDto.getJobDescription());
			job.setJobClass(jobDto.getJobClass());
			job.setIsActive(jobDto.getIsActive());

			job.setUpdatedBy(jobDto.getUpdatedBy());
			job.setUpdatedDate(Calendar.getInstance());

			jobRepository.save(job);

			jobDto.setCreatedBy(job.getCreatedBy());
			jobDto.setCreatedDate(job.getCreatedDate());
			jobDto.setUpdatedDate(job.getUpdatedDate());
		} else {
			throw new InvalidInputException("Could not find job details to update");
		}
	}

	/**
	 * 
	 */
	@Override
	public JobDto getJobByJobId(String accessToken, Long jobId) {

		Job job = jobRepository.getOne(jobId);
		JobDto jobDto = this.copyToJobDto(null, job);

		return jobDto;
	}

	private JobDto copyToJobDto(JobDto jobDto, Job job) {

		if (job != null) {

			if (jobDto == null) {
				jobDto = new JobDto();
			}

			jobDto.setJobId(job.getJobId());
			jobDto.setJobGroup(job.getJobGroup());
			jobDto.setJobName(job.getJobName());
			jobDto.setJobDescription(job.getJobDescription());
			jobDto.setJobClass(job.getJobClass());

			jobDto.setIsActive(job.getIsActive());
			jobDto.setCreatedBy(job.getCreatedBy());
			jobDto.setCreatedDate(job.getCreatedDate());
			jobDto.setUpdatedBy(job.getUpdatedBy());
			jobDto.setUpdatedDate(job.getUpdatedDate());

		}

		return jobDto;
	}

	/**
	 * 
	 */
	@Override
	public JobDto getJobByJobName(String accessToken, String jobName) {
		Job job = jobRepository.findByJobName(jobName);
		JobDto jobDto = this.copyToJobDto(null, job);
		return jobDto;
	}

	/**
	 * 
	 */
	@Override
	public List<JobDto> getJobsByJobGroup(String accessToken, String jobGroup) {

		List<JobDto> jobDtoList = null;

		List<Job> jobList = jobRepository.findByJobGroup(jobGroup);

		if ((jobList != null) && (jobList.size() > 0)) {
			jobDtoList = new ArrayList<JobDto>();

			for (Job job : jobList) {
				jobDtoList.add(this.copyToJobDto(null, job));
			}
		}

		return jobDtoList;
	}

	/**
	 * 
	 */
	@Override
	public List<JobDto> getAllJobs(String accessToken) {

		List<JobDto> jobDtoList = null;

		List<Job> jobList = jobRepository.findAll();

		if ((jobList != null) && (jobList.size() > 0)) {
			jobDtoList = new ArrayList<JobDto>();

			for (Job job : jobList) {
				jobDtoList.add(this.copyToJobDto(null, job));
			}
		}

		return jobDtoList;
	}

}
