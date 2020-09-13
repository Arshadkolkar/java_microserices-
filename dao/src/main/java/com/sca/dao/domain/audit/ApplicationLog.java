/**
 * 
 */
package com.sca.dao.domain.audit;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import com.sca.dao.domain.common.Service;

/**
 * 
 * @author subhash
 *
 */
@Entity
@Table(name = "application_log")
public class ApplicationLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_log_id")
	private Integer applicationLogId;

	@ManyToOne
	@JoinColumn(name = "service_id", referencedColumnName = "service_id", nullable = false)
	private Service service;

	@Column(name = "logger", length = 250)
	@NotNull
	private String logger;

	@Column(name = "log_level", length = 10)
	@NotNull
	private String logLevel;

	@Column(name = "message")
	private String message;

	@Column(name = "throwable")
	private String throwable;

	@Column(name = "log_date", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "MM")
	private Calendar logDate;

	/**
	 * @return the applicationLogId
	 */
	public Integer getApplicationLogId() {
		return applicationLogId;
	}

	/**
	 * @param applicationLogId the applicationLogId to set
	 */
	public void setApplicationLogId(Integer applicationLogId) {
		this.applicationLogId = applicationLogId;
	}

	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}

	/**
	 * @return the logger
	 */
	public String getLogger() {
		return logger;
	}

	/**
	 * @param logger the logger to set
	 */
	public void setLogger(String logger) {
		this.logger = logger;
	}

	/**
	 * @return the logLevel
	 */
	public String getLogLevel() {
		return logLevel;
	}

	/**
	 * @param logLevel the logLevel to set
	 */
	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the throwable
	 */
	public String getThrowable() {
		return throwable;
	}

	/**
	 * @param throwable the throwable to set
	 */
	public void setThrowable(String throwable) {
		this.throwable = throwable;
	}

	/**
	 * @return the logDate
	 */
	public Calendar getLogDate() {
		return logDate;
	}

	/**
	 * @param logDate the logDate to set
	 */
	public void setLogDate(Calendar logDate) {
		this.logDate = logDate;
	}

	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("serviceId")
				.toString();
	}

}
