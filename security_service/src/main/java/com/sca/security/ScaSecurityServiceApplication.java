/**
 * This is the main class for SCA Security Service 
 *  
 * @author subhash
 * @version 1.0.0
 * @since 22-May-2020
 *
 */
package com.sca.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * @author subhash
 *
 */
@EnableDiscoveryClient
@EnableAsync
@SpringBootApplication
@ComponentScan({ "com.sca.common", "com.sca.fems", "com.sca.security" })
@EntityScan({ "com.sca.dao.domain.common", "com.sca.dao.domain.security", "com.sca.dao.domain.location",
		"com.sca.dao.domain.payment", "com.sca.dao.domain.file", "com.sca.dao.domain.notification",
		"com.sca.dao.domain.order", "com.sca.dao.domain.project", "com.sca.dao.domain.scheduler",
		"com.sca.dao.domain.shipping"})
@EnableJpaRepositories({ "com.sca.dao.repository.security", "com.sca.dao.repository.location" })
public class ScaSecurityServiceApplication {

	/**
	 * 
	 * This is the main method of SCA Security Service
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ScaSecurityServiceApplication.class, args);
	}

}
