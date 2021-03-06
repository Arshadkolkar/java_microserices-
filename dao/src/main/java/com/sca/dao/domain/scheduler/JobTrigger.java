package com.sca.dao.domain.scheduler;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sca.dao.domain.common.BaseEntity;

@Entity
@Table(name = "job_trigger")
public class JobTrigger extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trigger_id")
	private Long triggerId;
	
	@Column(name = "job_id", unique=true)
	private Long jobId;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "start_24hour")
	private Integer start24Hour;
	
	@Column(name = "start_minute")
	private Integer startMinute;
	
	@Column(name = "end_24hour")
	private Integer end24Hour;
	
	@Column(name = "end_minute")
	private Integer endMinute;
	
	@Column(name = "repeat_every")
	private String repeatEvery;
	
	@Column(name = "repeat_interval")
	private Integer repeatInterval;
	
	@Column(name = "sunday_enabled")
	private boolean sundayEnabled;
	
	@Column(name = "monday_enabled")
	private boolean mondayEnabled;
	
	@Column(name = "tuesday_enabled")
	private boolean tuesdayEnabled;
	
	@Column(name = "wednesday_enabled")
	private boolean wednesdayEnabled;
	
	@Column(name = "thursday_enabled")
	private boolean thursdayEnabled;
	
	@Column(name = "friday_enabled")
	private boolean fridayEnabled;
	
	@Column(name = "saturday_enabled")
	private boolean saturdayEnabled;
	
	@Column(name = "day_number_of_month")
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

}
