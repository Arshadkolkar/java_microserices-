/**
 * This is the main class for SCA Scheduling Service 
 *  
 * @author siva
 * @version 1.0.0
 * @since 22-May-2020
 *
 */
package com.sca.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * @author
 *
 */
@EnableDiscoveryClient
@EnableAsync
@SpringBootApplication
@ComponentScan({ "com.sca.common", "com.sca.scheduler" })
@EntityScan({ "com.sca.dao.domain.common", "com.sca.dao.domain.scheduler" })
@EnableJpaRepositories("com.sca.dao.repository.scheduler")
public class ScaSchedulerServiceApplication {

	/**
	 * 
	 * This is the main method of SCA Scheduling Service
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ScaSchedulerServiceApplication.class, args);
	}

}
