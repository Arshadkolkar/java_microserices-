/**
 * 
 */
package com.sca.dto.scheduler;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.modelmapper.ModelMapper;

import com.sca.dao.domain.scheduler.JobTrigger;
import com.sca.dto.common.BaseEntityDto;

/**
 * 
 * @author subhash
 *
 */
public class JobTriggerDto extends BaseEntityDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long triggerId;
	private Long jobId;
	private Date startDate;
	private Date endDate;
	private Integer start24Hour;
	private Integer startMinute;
	private Integer end24Hour;
	private Integer endMinute;
	private String repeatEvery;
	private Integer repeatInterval;
	private boolean sundayEnabled;
	private boolean mondayEnabled;
	private boolean tuesdayEnabled;
	private boolean wednesdayEnabled;
	private boolean thursdayEnabled;
	private boolean fridayEnabled;
	private boolean saturdayEnabled;
	private String dayNumberOfMonth;

	public Long getTriggerId() {
		return triggerId;
	}

	public void setTriggerId(Long triggerId) {
		this.triggerId = triggerId;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getStart24Hour() {
		return start24Hour;
	}

	public void setStart24Hour(Integer start24Hour) {
		this.start24Hour = start24Hour;
	}

	public Integer getStartMinute() {
		return startMinute;
	}

	public void setStartMinute(Integer startMinute) {
		this.startMinute = startMinute;
	}

	public Integer getEnd24Hour() {
		return end24Hour;
	}

	public void setEnd24Hour(Integer end24Hour) {
		this.end24Hour = end24Hour;
	}

	public Integer getEndMinute() {
		return endMinute;
	}

	public void setEndMinute(Integer endMinute) {
		this.endMinute = endMinute;
	}

	public String getRepeatEvery() {
		return repeatEvery;
	}

	public void setRepeatEvery(String repeatEvery) {
		this.repeatEvery = repeatEvery;
	}

	public Integer getRepeatInterval() {
		return repeatInterval;
	}

	public void setRepeatInterval(Integer repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	public boolean isSundayEnabled() {
		return sundayEnabled;
	}

	public void setSundayEnabled(boolean sundayEnabled) {
		this.sundayEnabled = sundayEnabled;
	}

	public boolean isMondayEnabled() {
		return mondayEnabled;
	}

	public void setMondayEnabled(boolean mondayEnabled) {
		this.mondayEnabled = mondayEnabled;
	}

	public boolean isTuesdayEnabled() {
		return tuesdayEnabled;
	}

	public void setTuesdayEnabled(boolean tuesdayEnabled) {
		this.tuesdayEnabled = tuesdayEnabled;
	}

	public boolean isWednesdayEnabled() {
		return wednesdayEnabled;
	}

	public void setWednesdayEnabled(boolean wednesdayEnabled) {
		this.wednesdayEnabled = wednesdayEnabled;
	}

	public boolean isThursdayEnabled() {
		return thursdayEnabled;
	}

	public void setThursdayEnabled(boolean thursdayEnabled) {
		this.thursdayEnabled = thursdayEnabled;
	}

	public boolean isFridayEnabled() {
		return fridayEnabled;
	}

	public void setFridayEnabled(boolean fridayEnabled) {
		this.fridayEnabled = fridayEnabled;
	}

	public boolean isSaturdayEnabled() {
		return saturdayEnabled;
	}

	public void setSaturdayEnabled(boolean saturdayEnabled) {
		this.saturdayEnabled = saturdayEnabled;
	}

	public String getDayNumberOfMonth() {
		return dayNumberOfMonth;
	}

	public void setDayNumberOfMonth(String dayNumberOfMonth) {
		this.dayNumberOfMonth = dayNumberOfMonth;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}

	public JobTrigger convertToEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, JobTrigger.class);
	}

	public JobTriggerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
