/**
 * THis is the main class for Common service
 */
package com.sca.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sca.common.logger.DiagnosticLogger;

/**
 * 
 * @author subhash
 *
 */
@SpringBootApplication
public class ScaCommonApplication {
	private final static DiagnosticLogger logger = DiagnosticLogger.getLogger(ScaCommonApplication.class);

	public static void main(String[] args) {
		
		logger.debug("****** Starting SierraCommonApplication ******");
		
		SpringApplication.run(ScaCommonApplication.class, args);
		
		logger.debug("****** SierraCommonApplication started ******");
	}

}
