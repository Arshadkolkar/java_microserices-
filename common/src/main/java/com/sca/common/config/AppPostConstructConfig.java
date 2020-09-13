package com.sca.common.config;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author subhash
 *
 */
@Configuration
public class AppPostConstructConfig {

	/**
	 * 
	 */
	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

}
