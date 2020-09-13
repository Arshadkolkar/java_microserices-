/**
 * 
 */
package com.sca.dto.scheduler;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.modelmapper.ModelMapper;

import com.sca.dao.domain.scheduler.Job;
import com.sca.dto.common.BaseEntityDto;

public class JobDto extends BaseEntityDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long jobId;
	private String jobGroup;
	private String jobName;
	private String jobDescription;
	private String jobClass;

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobClass() {
		return jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}

	public Job convertToEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, Job.class);
	}

	public JobDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
