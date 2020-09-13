/**
 * This is the main class for sca Location Service 
 *  
 * @author subhash
 * @version 1.0.0
 * @since 17-Jul-2020
 *
 */
package com.sca.location;

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
@ComponentScan({ "com.sca.common", "com.sca.location" })
@EntityScan({ "com.sca.dao.domain.common", "com.sca.dao.domain.location" })
@EnableJpaRepositories("com.sca.dao.repository.location")
public class ScaLocationServiceApplication {

	/**
	 * 
	 * This is the main method of SCA Location Service
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ScaLocationServiceApplication.class, args);
	}

}
