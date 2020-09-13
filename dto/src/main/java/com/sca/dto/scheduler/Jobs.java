/**
 * 
 */
package com.sca.dto.scheduler;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Jobs {

	@JacksonXmlElementWrapper(localName = "jobs")
	@JacksonXmlProperty(localName = "job")
	@JsonProperty("jobs")
	private List<JobDto> jobList;

	/**
	 * 
	 * @param jobList
	 */
	public void setJobList(List<JobDto> jobList) {
		this.jobList = jobList;
	}

	/**
	 * 
	 * @param job
	 */
	public void addJob(JobDto job) {

		if (jobList == null) {
			jobList = new ArrayList<JobDto>();
		}

		jobList.add(job);
	}
	
}
