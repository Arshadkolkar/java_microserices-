/**
 * 
 */
package com.sca.common.logger;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.appender.db.ColumnMapping;
import org.apache.logging.log4j.core.appender.db.jdbc.ColumnConfig;
import org.apache.logging.log4j.core.appender.db.jdbc.JdbcAppender;
import org.apache.logging.log4j.core.filter.ThresholdFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.sca.common.util.JUnitUtil;
import com.sca.common.util.ScaService;

/**
 * 
 * @author subhash
 *
 */
@Configuration
public class LoggerConfig {
	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${logger.datasource.url}")
	private String url;

	@Value("${logger.datasource.username}")
	private String userName;

	@Value("${logger.datasource.password}")
	private String password;

	@Value("${logger.datasource.validation-query}")
	private String validationQuery;

	@Value("${logger.appender.level}")
	private Level appenderLevel;

	@Value("${logger.appender.name}")
	private String appenderName;

	@Value("${logger.appender.table-name}")
	private String appenderTableName;

	/**
	 * 
	 */
	@PostConstruct
	public void onStartUp() {

		// IGNORE LOGGING FOR JUNIT TESTS
		if (JUnitUtil.isJUnitTest()) {
			return;
		}
		if (applicationName.equals("sierra_dao") || applicationName.equals("sierra_common"))
			return;

		// Get serviceId based on applicationName
		Integer serviceId = ScaService.valueOf(applicationName).getServiceId();
		// Create a new connectionSource build from the Spring properties
		LoggerConnectionSource connectionSource = new LoggerConnectionSource(url, userName, password, validationQuery);

		// This is the mapping between the columns in the table and what to
		// insert in it.
		ColumnConfig[] columnConfigs = new ColumnConfig[6];
		// columnConfigs[0] =
		// ColumnConfig.newBuilder().setName("application_log_id").setPattern("0").setUnicode(false).build();
		columnConfigs[0] = ColumnConfig.newBuilder().setName("service_id").setUnicode(false)
				.setLiteral("" + serviceId + "").build();
		columnConfigs[1] = ColumnConfig.newBuilder().setName("logger").setPattern("%logger").setUnicode(false).build();
		columnConfigs[2] = ColumnConfig.newBuilder().setName("log_level").setPattern("%level").setUnicode(false)
				.build();
		columnConfigs[3] = ColumnConfig.newBuilder().setName("message").setPattern("%message").setUnicode(false)
				.build();
		columnConfigs[4] = ColumnConfig.newBuilder().setName("throwable").setPattern("%ex{full}").setUnicode(false)
				.build();
		columnConfigs[5] = ColumnConfig.newBuilder().setName("log_date").setEventTimestamp(true).build();

		// filter for the appender to keep only errors
		ThresholdFilter filter = ThresholdFilter.createFilter(appenderLevel, null, null);

		// The creation of the new database appender passing:
		// - the name of the appender
		// - ignore exceptions encountered when appending events are logged
		// - the filter created previously
		// - the connectionSource,
		// - log buffer size,
		// - the name of the table
		// - the config of the columns.
		JdbcAppender appender = JdbcAppender.newBuilder().setBufferSize(1).setColumnConfigs(columnConfigs)
				.setColumnMappings(new ColumnMapping[] {}).setConnectionSource(connectionSource)
				.setTableName(appenderTableName).setName(appenderName).setIgnoreExceptions(true).setFilter(filter)
				.build();
		// start the appender, and this is it...
		appender.start();
		((Logger) LogManager.getRootLogger()).addAppender(appender);
	}
}
