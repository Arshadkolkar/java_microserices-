package com.sca.dao.domain.audit;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author subhash
 *
 */
@Entity
@Table(name = "amq_error_log")
public class AmqErrorLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "amq_error_log_id")
	private Long amqErrorLogId;

	@Column(name = "amq_message")
	private String amqMessage;

	@Column(name = "error_message")
	private String errorMessage;

	@Column(name = "publisher_service_id")
	private Integer publisherServiceId;

	@Column(name = "subscriber_service_id")
	private Integer subscriberServiceId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "created_date", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "MM")
	private Calendar createdDate;

	/**
	 * @return the amqErrorLogId
	 */
	public Long getAmqErrorLogId() {
		return amqErrorLogId;
	}

	/**
	 * @param amqErrorLogId the amqErrorLogId to set
	 */
	public void setAmqErrorLogId(Long amqErrorLogId) {
		this.amqErrorLogId = amqErrorLogId;
	}

	/**
	 * @return the amqMessage
	 */
	public String getAmqMessage() {
		return amqMessage;
	}

	/**
	 * @param amqMessage the amqMessage to set
	 */
	public void setAmqMessage(String amqMessage) {
		this.amqMessage = amqMessage;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the publisherServiceId
	 */
	public Integer getPublisherServiceId() {
		return publisherServiceId;
	}

	/**
	 * @param publisherServiceId the publisherServiceId to set
	 */
	public void setPublisherServiceId(Integer publisherServiceId) {
		this.publisherServiceId = publisherServiceId;
	}

	/**
	 * @return the subscriberServiceId
	 */
	public Integer getSubscriberServiceId() {
		return subscriberServiceId;
	}

	/**
	 * @param subscriberServiceId the subscriberServiceId to set
	 */
	public void setSubscriberServiceId(Integer subscriberServiceId) {
		this.subscriberServiceId = subscriberServiceId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the createdDate
	 */
	public Calendar getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}
}
