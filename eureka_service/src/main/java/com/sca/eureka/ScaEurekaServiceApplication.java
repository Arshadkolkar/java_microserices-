/**
 * 
 */
package com.sca.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.sca.common.logger.DiagnosticLogger;

/**
 * 
 * @author subhash
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class ScaEurekaServiceApplication {

	private static final DiagnosticLogger log = DiagnosticLogger.getLogger(ScaEurekaServiceApplication.class);

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		log.info("EurekaServiceApplication is starting..............");
		
		SpringApplication.run(ScaEurekaServiceApplication.class, args);
		
		log.info("EurekaServiceApplication started..............");
	}

}
